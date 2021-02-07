package ru.otus.registration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.TestBase;
import ru.otus.pages.AccountSettingsPage;
import ru.otus.utils.Utils;

/**
 * RegistrationTest
 *
 * @author Alexander_Suvorov
 */
public class RegistrationTest extends TestBase {

  @Test
  public void checkLogin() {
    String name = "Ivan";
    String surname = "Fedorov";
    String email = Utils.getRandomEmail();
    AccountSettingsPage accountPage = appManager.getAccountSettingsPage();
    String errorMessage = "Photo was not loaded";

    appManager.getMainPage()
        .register(name, surname, email)
        .openProfile();

    String defaultImageUrl = accountPage.getPhotoUrl();
    accountPage.uploadFileAutoIT();
    String actualImageUrl = accountPage.getPhotoUrl();

    Assertions.assertNotEquals(defaultImageUrl, actualImageUrl, errorMessage);
  }
}
