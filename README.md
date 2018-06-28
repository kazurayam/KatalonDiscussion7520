Using org.openqa.selenium.WebElement#findElements(By.xpath) effectively in a Katalon Studio Test Case
====

## What is this repository?

This is a small [Katalon Studio](https://www.katalon.com/) project for demonstration purpose. You can clone this project out onto your pc
and run it with your Katalon Studio.

This project is developed with Katalon Studio version 5.4.2

This project is developed in order to answer to the question raised in the Katalon Forum:
https://forum.katalon.com/discussion/7520/the-xpath-for-the-url-is-correct-but-not-visible-if-added-via-addproperty

In this discussion, I proposed to write a Test Case using `org.openqa.selenium.WebElement#findElements(By.xpath)`. With this method call, we can get an
instance of `List<WebElement>` in the Test Case scope. We can iterate over the list as we want to.
This approach makes it easy for us to verify web elements displayed in the target Web page against some data in hand.

This Katalon project demonstrates a running test case.
