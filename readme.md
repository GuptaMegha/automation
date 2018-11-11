# Test Automation Project using Cucumber Selenium Java

Project is created for TNT, as test assignment.


## Getting Started

It is a Maven Java project that can be cloned, build and run directly.

To build and run all test: 
```$xslt
mvn clean install
```
To run feature specific scenarios. For example To run all scenarios of Home page:
```$xslt
mvn clean test -Dcucumber.options="src/test/resources --tags @HomePage"
``` 

To run single scenario. For example To run account aanmaken scenario:
```$xslt
mvn clean test -Dcucumber.options="src/test/resources --tags @test_accountAanmaken"
``` 

## Summary

I tried to cover the TNT core functionalities with E2E tests. 
I tried to make tests not flaky by adding proper expected conditions for webelements.

With given more time, code can be refectored and improved.

## Bug
I was facing styling issue on TNT.com home page on windows platform.

