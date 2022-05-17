package tests;

import environment.EnvironmentManager;
import environment.RunEnvironment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoTest {
    static PageObjects page;	
    static WebDriver driver;

    @BeforeEach
    public void startBrowser() {
        EnvironmentManager.initWebDriver();
	driver = RunEnvironment.getWebDriver();
        page = new PageObjects(driver);

        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
    }

    @Test
    public void demo() {
         // Fill text boxes
        page.FillTextBox("firstname", "Test");
        page.FillTextBox("lastname", "Last");

        // Choose one of the radio buttons
        page.ChooseRadioButton("sex", 1);
        page.ChooseRadioButton("exp", 6);

        // Fill the date
        page.FillTextBoxViaXpath("/html/body/div[1]/div/div[2]/div[4]/div/form/table/tbody/tr[5]/td[2]/input",
                "17.10.1987");

        // Check on boxes
        page.ClickOnCheckBox("profession", 1);
        page.ClickOnCheckBox("tool", 2);

        // Select from list
        page.Select("continents", 2);
        page.Select("selenium_commands", 2);

        //Submit
        page.Submit("submit");

        // Confirm
        driver.switchTo().alert().accept();
    }

    @AfterEach
    public void tearDown() {
        EnvironmentManager.shutDownDriver();
    }
}
