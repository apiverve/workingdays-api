Working Days API
============

Working Days is a simple tool for getting the number of working days in a month. It returns the number of working days in the given month.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Python API Wrapper for the [Working Days API](https://apiverve.com/marketplace/workingdays?utm_source=pypi&utm_medium=readme)

---

## Installation

Using `pip`:

```bash
pip install apiverve-workingdays
```

Using `pip3`:

```bash
pip3 install apiverve-workingdays
```

---

## Configuration

Before using the workingdays API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=pypi&utm_medium=readme)

---

## Quick Start

Here's a simple example to get you started quickly:

```python
from apiverve_workingdays.apiClient import WorkingdaysAPIClient

# Initialize the client with your APIVerve API key
api = WorkingdaysAPIClient("[YOUR_API_KEY]")

query = {
    "country": "US",
    "month": 10,
    "year": 2026
}

try:
    # Make the API call
    result = api.execute(query)

    # Print the result
    print(result)
except Exception as e:
    print(f"Error: {e}")
```

---

## Usage

The Working Days API documentation is found here: [https://docs.apiverve.com/ref/workingdays](https://docs.apiverve.com/ref/workingdays?utm_source=pypi&utm_medium=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```python
# Import the client module
from apiverve_workingdays.apiClient import WorkingdaysAPIClient

# Initialize the client with your APIVerve API key
api = WorkingdaysAPIClient("[YOUR_API_KEY]")
```

---

## Perform Request

Using the API client, you can perform requests to the API.

###### Define Query

```python
query = {
    "country": "US",
    "month": 10,
    "year": 2026
}
```

###### Simple Request

```python
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

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

## Error Handling

The API client provides comprehensive error handling through the `WorkingdaysAPIClientError` exception. Here are some examples:

### Basic Error Handling

```python
from apiverve_workingdays.apiClient import WorkingdaysAPIClient, WorkingdaysAPIClientError

api = WorkingdaysAPIClient("[YOUR_API_KEY]")

query = {
    "country": "US",
    "month": 10,
    "year": 2026
}

try:
    result = api.execute(query)
    print("Success!")
    print(result)
except WorkingdaysAPIClientError as e:
    print(f"API Error: {e.message}")
    if e.status_code:
        print(f"Status Code: {e.status_code}")
    if e.response:
        print(f"Response: {e.response}")
```

### Handling Specific Error Types

```python
from apiverve_workingdays.apiClient import WorkingdaysAPIClient, WorkingdaysAPIClientError

api = WorkingdaysAPIClient("[YOUR_API_KEY]")

query = {
    "country": "US",
    "month": 10,
    "year": 2026
}

try:
    result = api.execute(query)

    # Check for successful response
    if result.get('status') == 'success':
        print("Request successful!")
        print(result.get('data'))
    else:
        print(f"API returned an error: {result.get('error')}")

except WorkingdaysAPIClientError as e:
    # Handle API client errors
    if e.status_code == 401:
        print("Unauthorized: Invalid API key")
    elif e.status_code == 429:
        print("Rate limit exceeded")
    elif e.status_code >= 500:
        print("Server error - please try again later")
    else:
        print(f"API error: {e.message}")
except Exception as e:
    # Handle unexpected errors
    print(f"Unexpected error: {str(e)}")
```

### Using Context Manager (Recommended)

The client supports the context manager protocol for automatic resource cleanup:

```python
from apiverve_workingdays.apiClient import WorkingdaysAPIClient, WorkingdaysAPIClientError

query = {
    "country": "US",
    "month": 10,
    "year": 2026
}

# Using context manager ensures proper cleanup
with WorkingdaysAPIClient("[YOUR_API_KEY]") as api:
    try:
        result = api.execute(query)
        print(result)
    except WorkingdaysAPIClientError as e:
        print(f"Error: {e.message}")
# Session is automatically closed here
```

---

## Advanced Features

### Debug Mode

Enable debug logging to see detailed request and response information:

```python
from apiverve_workingdays.apiClient import WorkingdaysAPIClient

# Enable debug mode
api = WorkingdaysAPIClient("[YOUR_API_KEY]", debug=True)

query = {
    "country": "US",
    "month": 10,
    "year": 2026
}

# Debug information will be printed to console
result = api.execute(query)
```

### Manual Session Management

If you need to manually manage the session lifecycle:

```python
from apiverve_workingdays.apiClient import WorkingdaysAPIClient

api = WorkingdaysAPIClient("[YOUR_API_KEY]")

query = {
    "country": "US",
    "month": 10,
    "year": 2026
}

try:
    result = api.execute(query)
    print(result)
finally:
    # Manually close the session when done
    api.close()
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=pypi&utm_medium=readme).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=pypi&utm_medium=readme) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
