package com.seleniumtest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumTest {
    static PageObjects page;
    static ChromeOptions options;
    static WebDriver driver;

    @BeforeAll
    static void SetUp() {
        WebDriverManager.chromedriver().setup();

        options = new ChromeOptions();
        driver = new ChromeDriver(options);
        page = new PageObjects(driver);

        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
    }

    @Test
    public void ExecuteScenario() {
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

    @AfterAll
    static void TearDown() {
        driver.quit();
    }
}
