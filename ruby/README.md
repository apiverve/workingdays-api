# Working Days API - Ruby Gem

Working Days is a working days and business days API that counts the working days and non-working days for any country and month. Pass a two-letter country code and month number to get total counts, working date lists, and non-working days marked with holiday names.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_workingdays'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_workingdays
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_workingdays'

# Initialize the client
client = APIVerve::Workingdays::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  country: "US",
  month: 10,
  year: 2026
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ country: "US", month: 10, year: 2026 })
  puts response["data"]
rescue APIVerve::Workingdays::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Workingdays::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Workingdays::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/workingdays?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/workingdays?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/workingdays?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
