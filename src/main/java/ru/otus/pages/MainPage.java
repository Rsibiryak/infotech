package ru.otus.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import ru.otus.utils.AppManager;

/**
 * MainPage
 *
 * @author Alexander_Suvorov
 */
public class MainPage extends PageBase {

  private By inputRegistrationButton = By.cssSelector(".header2__auth");
  private By registerTab = By.cssSelector("div[data-tab-id='register']");
  private By submitButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]");
  private By surnameField = By.cssSelector("input[placeholder='Фамилия']");
  private By nameField = By.cssSelector("input[placeholder='Имя *']");
  private By emailField = By.cssSelector("input[placeholder='Электронная почта *']");
  private By userName = By.cssSelector("p.header2-menu__item-text__username");
  private By personalAccountSettings = By.cssSelector("b.header2-menu__dropdown-text_name");
  private By agreeButton = By.cssSelector("button[name='agreement'][value='accept']");

  public MainPage(AppManager appManager) {
    super(appManager);
  }

  public MainPage register(String name, String surname, String email) {
    getElement(inputRegistrationButton).click();
    getElement(registerTab).click();

    getElement(nameField).sendKeys(name);
    getElement(surnameField).sendKeys(surname);
    getElement(emailField).sendKeys(email);

    getElement(submitButton).click();

    return this;
  }

  public AccountSettingsPage openProfile() {
    Actions actions = new Actions(driver);
    actions.moveToElement(getElement(userName)).build().perform();
    actions.moveToElement(getElement(personalAccountSettings)).click().build().perform();
    acceptPublishCV();

    return appManager.getAccountSettingsPage();
  }

  private void acceptPublishCV() {
    if (isElementExist(agreeButton)) {
      getElement(agreeButton).click();
    }
  }
}
