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
        public string Month { get; set; }

        /// <summary>
        /// The year you want to get the number of working days for
        /// </summary>
        [JsonProperty("year")]
        public string Year { get; set; }
    }
}
