# [Working Days API](https://apiverve.com/marketplace/workingdays?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)

Working Days is a working days and business days API that counts the working days and non-working days for any country and month. Pass a two-letter country code and month number to get total counts, working date lists, and non-working days marked with holiday names.

The Working Days API provides a simple, reliable way to integrate working days functionality into your applications. Built for developers who need production-ready working days capabilities without the complexity of building from scratch.

**[View API Details →](https://apiverve.com/marketplace/workingdays?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)**

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![API Status](https://img.shields.io/badge/Status-Active-green.svg)](https://apiverve.com/marketplace/workingdays?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)
[![Method](https://img.shields.io/badge/Method-GET-blue.svg)](#)
[![Platform](https://img.shields.io/badge/Platform-Multi--Platform-orange.svg)](#installation)

**Available on:**
[![npm](https://img.shields.io/badge/npm-CB3837?style=flat&logo=npm&logoColor=white)](https://www.npmjs.com/package/@apiverve/workingdays)
[![NuGet](https://img.shields.io/badge/NuGet-004880?style=flat&logo=nuget&logoColor=white)](https://www.nuget.org/packages/APIVerve.API.WorkingDays)
[![PyPI](https://img.shields.io/badge/PyPI-3776AB?style=flat&logo=python&logoColor=white)](https://pypi.org/project/apiverve-workingdays/)
[![RubyGems](https://img.shields.io/badge/RubyGems-E9573F?style=flat&logo=rubygems&logoColor=white)](https://rubygems.org/gems/apiverve_workingdays)
[![Packagist](https://img.shields.io/badge/Packagist-F28D1A?style=flat&logo=packagist&logoColor=white)](https://packagist.org/packages/apiverve/workingdays)
[![Go](https://img.shields.io/badge/Go-00ADD8?style=flat&logo=go&logoColor=white)](#-go)
[![Dart](https://img.shields.io/badge/Dart-0175C2?style=flat&logo=dart&logoColor=white)](https://pub.dev/packages/apiverve_workingdays)
[![JitPack](https://img.shields.io/badge/JitPack-2E7D32?style=flat&logo=android&logoColor=white)](#-android-jitpack)

---

## Quick Start

### Using JavaScript

```javascript
async function callWorkingDaysAPI() {
    try {
        const params = new URLSearchParams({
            country: 'US',
            month: 10
        });

        const response = await fetch(`https://api.apiverve.com/v1/workingdays?${params}`, {
            method: 'GET',
            headers: {
                'x-api-key': 'YOUR_API_KEY_HERE'
            }
        });

        const data = await response.json();
        console.log(data);
    } catch (error) {
        console.error('Error:', error);
    }
}

callWorkingDaysAPI();
```

### Using cURL

```bash
curl -X GET "https://api.apiverve.com/v1/workingdays?country=US&month=10" \
  -H "x-api-key: YOUR_API_KEY_HERE"
```

**Get your API key:** [https://apiverve.com](https://apiverve.com)

**📁 For more examples, see the [examples folder](./examples/)**

---

## Installation

Choose your preferred programming language:

### 📦 NPM (JavaScript/Node.js)

```bash
npm install @apiverve/workingdays
```

[**View NPM Package →**](https://www.npmjs.com/package/@apiverve/workingdays) | [**Package Code →**](./npm/)

---

### 🔷 NuGet (.NET/C#)

```bash
dotnet add package APIVerve.API.WorkingDays
```

[**View NuGet Package →**](https://www.nuget.org/packages/APIVerve.API.WorkingDays) | [**Package Code →**](./nuget/)

---

### 🐍 Python (PyPI)

```bash
pip install apiverve-workingdays
```

[**View PyPI Package →**](https://pypi.org/project/apiverve-workingdays/) | [**Package Code →**](./python/)

---

### 💎 Ruby (RubyGems)

```bash
gem install apiverve_workingdays
```

[**View RubyGems Package →**](https://rubygems.org/gems/apiverve_workingdays) | [**Package Code →**](./ruby/)

---

### 🐘 PHP (Packagist)

```bash
composer require apiverve/workingdays
```

[**View Packagist Package →**](https://packagist.org/packages/apiverve/workingdays) | [**Package Code →**](./php/)

---

### 🎯 Dart (pub.dev)

```bash
dart pub add apiverve_workingdays
```

[**View pub.dev Package →**](https://pub.dev/packages/apiverve_workingdays) | [**Package Code →**](./dart/)

---

### 🤖 Android (JitPack)

```gradle
implementation 'com.github.apiverve:workingdays-api:1.0.0'
```

[**Package Code →**](./android/)

---

### 🐹 Go

```bash
go get github.com/apiverve/workingdays-api/go
```

[**Package Code →**](./go/)

---

## Why Use This API?

| Feature | Benefit |
|---------|---------|
| **Multi-language SDKs** | Native packages for JavaScript, Python, C#, Go, and Android |
| **Simple Integration** | Single API key authentication, consistent response format |
| **Production Ready** | 99.9% uptime SLA, served from 24 global regions |
| **Comprehensive Docs** | Full examples, OpenAPI spec, and dedicated support |

---

## Documentation

- 🏠 **API Home:** [Working Days API](https://apiverve.com/marketplace/workingdays?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)
- 📚 **API Reference:** [docs.apiverve.com/ref/workingdays](https://docs.apiverve.com/ref/workingdays)
- 📖 **OpenAPI Spec:** [openapi.yaml](./openapi.yaml)
- 💡 **Examples:** [examples/](./examples/)

---

## What Can You Build?

The Working Days API is commonly used for:

- **Web Applications** - Add working days features to your frontend or backend
- **Mobile Apps** - Native SDKs for Android development
- **Automation** - Integrate with n8n, Zapier, or custom workflows
- **SaaS Products** - Enhance your product with working days capabilities
- **Data Pipelines** - Process and analyze data at scale

---

## API Reference

### Authentication
All requests require an API key in the header:
```
x-api-key: YOUR_API_KEY_HERE
```

Get your API key: [https://apiverve.com](https://apiverve.com)

### Response Format

Every APIVerve endpoint returns the same envelope — check `status`, then read `data`:

```json
{
  "status": "ok",
  "error": null,
  "data": { ... }
}
```

### Example Response

A real response from the Working Days API:

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

## Support & Community

- 🏠 **API Home**: [Working Days API](https://apiverve.com/marketplace/workingdays?utm_source&#x3D;github&amp;utm_medium&#x3D;referral&amp;utm_content&#x3D;readme)
- 💬 **Support**: [https://apiverve.com/contact](https://apiverve.com/contact)
- 🐛 **Issues**: [GitHub Issues](../../issues)
- 📖 **Documentation**: [https://docs.apiverve.com](https://docs.apiverve.com)
- 🌐 **Website**: [https://apiverve.com](https://apiverve.com)

---

## Contributing

We welcome contributions! Please see [CONTRIBUTING.md](CONTRIBUTING.md) for guidelines.

---

## Security

For security concerns, please review our [Security Policy](SECURITY.md).

---

## License

This project is licensed under the **MIT License** - see the [LICENSE](LICENSE) file for details.

---

## Acknowledgments

Built with ❤️ by [APIVerve](https://apiverve.com)

Copyright © 2026 APIVerve. All rights reserved.
