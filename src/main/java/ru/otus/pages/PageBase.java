package ru.otus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.otus.utils.AppManager;

public class PageBase {

  private static final int TIMEOUT = 12;
  protected WebDriver driver;
  protected WebDriverWait wait;
  protected AppManager appManager;

  PageBase(AppManager manager) {
    this.appManager = manager;
    this.driver = manager.getDriver();

    wait = new WebDriverWait(driver, TIMEOUT);
  }

  protected WebElement getElement(By locator) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  protected Boolean isElementExist(By locator) {
    try {
      getElement(locator);
      return true;
    } catch (TimeoutException ex) {
      return false;
    }
  }
}
