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
        /// The country you want to get the number of working days for (e.g. US)
        /// Example: US
        /// </summary>
        [JsonProperty("country")]
        public string Country { get; set; }

        /// <summary>
        /// The year you want to get the number of working days for (e.g. 2023)
        /// Example: 2023
        /// </summary>
        [JsonProperty("year")]
        public string Year { get; set; }

        /// <summary>
        /// The 2 digit month you want to get the number of working days for (e.g. 10)
        /// Example: 10
        /// </summary>
        [JsonProperty("month")]
        public string Month { get; set; }
    }
}
