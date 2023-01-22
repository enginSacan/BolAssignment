# BolAssıgnment
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

Lombok library is used for creating model of the data from properties files in the resources folder and product.

Generic data structure is used with the properties. 

Page Object Oriented structure is used for the UI test.

Page classes inherited from base class.

WebDriverManager is used for getting browser drivers. To get the screenshots of the failure cases, 
you need to switch browser to Firefox. All options are commented out for usage. 

## Requirement of the test
* Return policy for outside in Bol.com
* Add/Remove Voucher in the card

