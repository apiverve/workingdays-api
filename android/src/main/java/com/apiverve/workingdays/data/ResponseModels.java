// Converter.java

// To use this code, add the following Maven dependency to your project:
//
//
//     com.fasterxml.jackson.core     : jackson-databind          : 2.9.0
//     com.fasterxml.jackson.datatype : jackson-datatype-jsr310   : 2.9.0
//
// Import this package:
//
//     import com.apiverve.data.Converter;
//
// Then you can deserialize a JSON string with
//
//     WorkingDaysData data = Converter.fromJsonString(jsonString);

package com.apiverve.workingdays.data;

import java.io.IOException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class Converter {
    // Date-time helpers

    private static final DateTimeFormatter DATE_TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            .appendOptional(DateTimeFormatter.ISO_INSTANT)
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssX"))
            .appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetDateTime parseDateTimeString(String str) {
        return ZonedDateTime.from(Converter.DATE_TIME_FORMATTER.parse(str)).toOffsetDateTime();
    }

    private static final DateTimeFormatter TIME_FORMATTER = new DateTimeFormatterBuilder()
            .appendOptional(DateTimeFormatter.ISO_TIME)
            .appendOptional(DateTimeFormatter.ISO_OFFSET_TIME)
            .parseDefaulting(ChronoField.YEAR, 2020)
            .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
            .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
            .toFormatter()
            .withZone(ZoneOffset.UTC);

    public static OffsetTime parseTimeString(String str) {
        return ZonedDateTime.from(Converter.TIME_FORMATTER.parse(str)).toOffsetDateTime().toOffsetTime();
    }
    // Serialize/deserialize helpers

    public static WorkingDaysData fromJsonString(String json) throws IOException {
        return getObjectReader().readValue(json);
    }

    public static String toJsonString(WorkingDaysData obj) throws JsonProcessingException {
        return getObjectWriter().writeValueAsString(obj);
    }

    private static ObjectReader reader;
    private static ObjectWriter writer;

    private static void instantiateMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule();
        module.addDeserializer(OffsetDateTime.class, new JsonDeserializer<OffsetDateTime>() {
            @Override
            public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                String value = jsonParser.getText();
                return Converter.parseDateTimeString(value);
            }
        });
        mapper.registerModule(module);
        reader = mapper.readerFor(WorkingDaysData.class);
        writer = mapper.writerFor(WorkingDaysData.class);
    }

    private static ObjectReader getObjectReader() {
        if (reader == null) instantiateMapper();
        return reader;
    }

    private static ObjectWriter getObjectWriter() {
        if (writer == null) instantiateMapper();
        return writer;
    }
}

// WorkingDaysData.java

package com.apiverve.workingdays.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class WorkingDaysData {
    private long workingDaysCount;
    private long nonWorkingDaysCount;
    private LocalDate[] workingDays;
    private NonWorkingDay[] nonWorkingDays;

    @JsonProperty("workingDaysCount")
    public long getWorkingDaysCount() { return workingDaysCount; }
    @JsonProperty("workingDaysCount")
    public void setWorkingDaysCount(long value) { this.workingDaysCount = value; }

    @JsonProperty("nonWorkingDaysCount")
    public long getNonWorkingDaysCount() { return nonWorkingDaysCount; }
    @JsonProperty("nonWorkingDaysCount")
    public void setNonWorkingDaysCount(long value) { this.nonWorkingDaysCount = value; }

    @JsonProperty("workingDays")
    public LocalDate[] getWorkingDays() { return workingDays; }
    @JsonProperty("workingDays")
    public void setWorkingDays(LocalDate[] value) { this.workingDays = value; }

    @JsonProperty("nonWorkingDays")
    public NonWorkingDay[] getNonWorkingDays() { return nonWorkingDays; }
    @JsonProperty("nonWorkingDays")
    public void setNonWorkingDays(NonWorkingDay[] value) { this.nonWorkingDays = value; }
}

// NonWorkingDay.java

package com.apiverve.workingdays.data;

import com.fasterxml.jackson.annotation.*;
import java.time.LocalDate;

public class NonWorkingDay {
    private LocalDate date;
    private Reason[] reasons;
    private String holidayName;

    @JsonProperty("date")
    public LocalDate getDate() { return date; }
    @JsonProperty("date")
    public void setDate(LocalDate value) { this.date = value; }

    @JsonProperty("reasons")
    public Reason[] getReasons() { return reasons; }
    @JsonProperty("reasons")
    public void setReasons(Reason[] value) { this.reasons = value; }

    @JsonProperty("holiday_name")
    public String getHolidayName() { return holidayName; }
    @JsonProperty("holiday_name")
    public void setHolidayName(String value) { this.holidayName = value; }
}

// Reason.java

package com.apiverve.workingdays.data;

import java.io.IOException;
import com.fasterxml.jackson.annotation.*;

public enum Reason {
    PUBLIC_HOLIDAY, WEEKEND;

    @JsonValue
    public String toValue() {
        switch (this) {
            case PUBLIC_HOLIDAY: return "public holiday";
            case WEEKEND: return "weekend";
        }
        return null;
    }

    @JsonCreator
    public static Reason forValue(String value) throws IOException {
        if (value.equals("public holiday")) return PUBLIC_HOLIDAY;
        if (value.equals("weekend")) return WEEKEND;
        throw new IOException("Cannot deserialize Reason");
    }
}