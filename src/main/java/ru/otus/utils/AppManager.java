package ru.otus.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.otus.pages.AccountSettingsPage;
import ru.otus.pages.MainPage;


/**
 * AppManager
 * <p>
 * Managing instances of all classes.
 *
 * @author Alexander_Suvorov
 */
public class AppManager {

  private static AppManager instance;
  private WebDriver driver;
  private MainPage mainPage;
  private AccountSettingsPage accountSettingsPage;
  private String baseUrl = "https://otus.ru";

  private AppManager() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(baseUrl);

    mainPage = new MainPage(this);
    accountSettingsPage = new AccountSettingsPage(this);
  }

  public static AppManager getInstance() {
    if (instance == null) {
      instance = new AppManager();
    }
    return instance;
  }

  public static void stopInstance() {
    if (instance != null) {
      instance.driver.quit();
    }
  }

  public WebDriver getDriver() {
    return driver;
  }

  public MainPage getMainPage() {
    return mainPage;
  }

  public AccountSettingsPage getAccountSettingsPage() {
    return accountSettingsPage;
  }
}
