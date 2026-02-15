# Working Days API - Go Client

Working Days is a simple tool for getting the number of working days in a month. It returns the number of working days in the given month.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Go client for the [Working Days API](https://apiverve.com/marketplace/workingdays?utm_source=go&utm_medium=readme)

---

## Installation

```bash
go get github.com/apiverve/workingdays-api/go
```

---

## Configuration

Before using the Working Days API client, you need to obtain your API key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=go&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=go&utm_medium=readme)

The Working Days API documentation is found here: [https://docs.apiverve.com/ref/workingdays](https://docs.apiverve.com/ref/workingdays?utm_source=go&utm_medium=readme)

---

## Usage

```go
package main

import (
    "fmt"
    "log"

    "github.com/apiverve/workingdays-api/go"
)

func main() {
    // Create a new client
    client := workingdays.NewClient("YOUR_API_KEY")

    // Set up parameters
    params := map[string]interface{}{
        "country": "US",
        "month": 10,
        "year": 2026
    }

    // Make the request
    response, err := client.Execute(params)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Printf("Status: %s\n", response.Status)
    fmt.Printf("Data: %+v\n", response.Data)
}
```

---

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "workingDaysCount": 21,
    "nonWorkingDaysCount": 10,
    "workingDays": [
      "2023-10-02",
      "2023-10-03",
      "2023-10-04",
      "2023-10-05",
      "2023-10-06",
      "2023-10-10",
      "2023-10-11",
      "2023-10-12",
      "2023-10-13",
      "2023-10-16",
      "2023-10-17",
      "2023-10-18",
      "2023-10-19",
      "2023-10-20",
      "2023-10-23",
      "2023-10-24",
      "2023-10-25",
      "2023-10-26",
      "2023-10-27",
      "2023-10-30",
      "2023-10-31"
    ],
    "nonWorkingDays": [
      {
        "date": "2023-10-01",
        "reasons": [
          "weekend"
        ],
        "holiday_name": null
      },
      {
        "date": "2023-10-07",
        "reasons": [
          "weekend"
        ],
        "holiday_name": null
      },
      {
        "date": "2023-10-08",
        "reasons": [
          "weekend"
        ],
        "holiday_name": null
      },
      {
        "date": "2023-10-09",
        "reasons": [
          "public holiday"
        ],
        "holiday_name": "Columbus Day"
      },
      {
        "date": "2023-10-14",
        "reasons": [
          "weekend"
        ],
        "holiday_name": null
      },
      {
        "date": "2023-10-15",
        "reasons": [
          "weekend"
        ],
        "holiday_name": null
      },
      {
        "date": "2023-10-21",
        "reasons": [
          "weekend"
        ],
        "holiday_name": null
      },
      {
        "date": "2023-10-22",
        "reasons": [
          "weekend"
        ],
        "holiday_name": null
      },
      {
        "date": "2023-10-28",
        "reasons": [
          "weekend"
        ],
        "holiday_name": null
      },
      {
        "date": "2023-10-29",
        "reasons": [
          "weekend"
        ],
        "holiday_name": null
      }
    ]
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=go&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=go&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=go&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=go&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
