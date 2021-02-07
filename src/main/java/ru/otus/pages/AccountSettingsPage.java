package ru.otus.pages;

import org.openqa.selenium.By;
import ru.otus.utils.AppManager;

/**
 * AccountSettingsPage
 *
 * @author Alexander_Suvorov
 */
public class AccountSettingsPage extends PageBase {

  private By addPhotoButton = By.cssSelector("div.button_full2");
  private By applyPhotoButton = By.xpath("//button[contains(text(),'Выбрать')]");
  private By photoImage = By.cssSelector("div.settings-photo__photo");

  public AccountSettingsPage(AppManager manager) {
    super(manager);
  }

  public String getPhotoUrl() {
    String url = getElement(photoImage).getAttribute("style");
    return url.substring(url.indexOf('(') + 1, url.lastIndexOf(')')).replace("\"", "");
  }

  public void uploadFileAutoIT() {

    getElement(addPhotoButton).click();

    String basePath = System.getProperty("user.dir");
    String path = String
        .format("%s%s", basePath, "\\src\\main\\java\\ru\\otus\\utils\\uploadPhoto.exe");

    try {
      Runtime.getRuntime().exec(path);
      getElement(applyPhotoButton).click();
      Thread.sleep(4000); //Wait file loading.
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}
