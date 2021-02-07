package ru.otus;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import ru.otus.utils.AppManager;

/**
 * TestBase
 *
 * @author Alexander_Suvorov
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {

  protected AppManager appManager;

  @BeforeAll
  public void setup() {
    appManager = AppManager.getInstance();
  }

  @AfterAll
  public void setDown() {
    AppManager.stopInstance();
  }
}
