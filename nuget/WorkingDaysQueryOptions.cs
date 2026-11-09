using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.WorkingDays
{
    /// <summary>
    /// Query options for the Working Days API
    /// </summary>
    public class WorkingDaysQueryOptions
    {
        /// <summary>
        /// The 2-letter country code you want to get the number of working days for
        /// </summary>
        [JsonProperty("country")]
        public string Country { get; set; }

        /// <summary>
        /// The month you want to get the number of working days for
        /// </summary>
        [JsonProperty("month")]
        public int? Month { get; set; }

        /// <summary>
        /// The year you want to get the number of working days for
        /// </summary>
        [JsonProperty("year")]
        public int? Year { get; set; }

        /// <summary>
        /// Optional state or region code within the country for regional public holidays (e.g. CA for California, BY for Bavaria)
        /// </summary>
        [JsonProperty("region")]
        public string Region { get; set; }

        /// <summary>
        /// Comma-separated weekend days as names or numbers 0-6 (Sunday=0), or none. Defaults to sat,sun
        /// </summary>
        [JsonProperty("weekend")]
        public string Weekend { get; set; }

        /// <summary>
        /// Start date (YYYY-MM-DD). With end, counts working days across that range (up to 366 days, inclusive) instead of a month. With addDays, the date to count from (defaults to today)
        /// </summary>
        [JsonProperty("start")]
        public string Start { get; set; }

        /// <summary>
        /// End date (YYYY-MM-DD), inclusive. Used with start
        /// </summary>
        [JsonProperty("end")]
        public string End { get; set; }

        /// <summary>
        /// Number of working days to add to start (negative to subtract). The start date itself is not counted. Returns resultDate plus the days it stepped over
        /// </summary>
        [JsonProperty("addDays")]
        public int? AddDays { get; set; }
    }
}
