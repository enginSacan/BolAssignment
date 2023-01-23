# BolAssignment
This repo is created to show subject below:

* Test automation example for predefined scenarios for Bol.com


## How It Works

You need to install maven to your computer.

You have to go to the folder that you clone.

There is an example for run the tests of Return process:

```
mvn test -Dcucumber.options="--tags @Return"
```

You can have the result html, json and Junit XML in the target/cucumber-report folder.

OR 

You can download intellij idea with plugins below:
* Gherkin
* Cucumber for Java
* Cucumber+

You can execute feature file in the IDE.

## Structure

* Lombok library is used for creating model of the data from properties files in the resources folder and product.

* Generic data structure is used with the properties. 

* Page Object Oriented structure is used for the UI test.

* Page classes inherited from base class.

* Three options are added to run the test automation about browsers:
  * Chrome
  * Firefox
  * Headless

* If programmer want to use this suite in ci/cd pipeline there is also headless browser option is added to code.
* Base class is used to handle the complexity of selenium commands and handle the expected conditions.
* 23 January I added Page Factory example for one class also from selenium support.
## Requirement of the test
* Return policy for outside in Bol.com
* Add/Remove Voucher in the card

