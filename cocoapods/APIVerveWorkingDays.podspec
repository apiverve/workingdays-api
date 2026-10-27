Pod::Spec.new do |s|
  s.name             = 'APIVerveWorkingDays'
  s.version          = '1.2.3'
  s.summary          = 'Working Days is a working days and business days API that counts the working days and non-working days for any country and month.'
  s.description      = <<-'DESC'
Working Days is a working days and business days API that counts the working days and non-working days for any country and month. Pass a two-letter country code and month number to get total counts, working date lists, and non-working days marked with holiday names.

This iOS/macOS SDK provides a convenient way to access the Working Days from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/workingdays?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/workingdays-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveWorkingDays/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
