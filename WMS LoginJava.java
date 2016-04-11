package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class WMSLoginJava {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://qa.datascantech.com/amtrunk/qa-dst-dls1/dst ";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testWMSLoginJava() throws Exception {
    driver.findElement(By.id("IDToken1")).clear();
    driver.findElement(By.id("IDToken1")).sendKeys("wmstest");
    driver.findElement(By.id("IDToken2")).clear();
    driver.findElement(By.id("IDToken2")).sendKeys("password");
    driver.findElement(By.id("submitButton")).click();
    driver.findElement(By.id("gotomarketconfiguration")).click();
    driver.findElement(By.id("editcustomer")).click();
    driver.findElement(By.id("search")).clear();
    driver.findElement(By.id("search")).sendKeys("01121");
    driver.findElement(By.id("submitButton_top")).click();
    driver.findElement(By.id("closeButton_top")).click();
    driver.findElement(By.id("bookscontroller")).click();
    driver.findElement(By.id("logout")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
