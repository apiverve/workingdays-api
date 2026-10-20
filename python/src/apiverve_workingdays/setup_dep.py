from setuptools import setup, find_packages

setup(
    name='apiverve_workingdays',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Working Days is a working days and business days API that counts the working days and non-working days for any country and month. Pass a two-letter country code and month number to get total counts, working date lists, and non-working days marked with holiday names.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/workingdays?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
