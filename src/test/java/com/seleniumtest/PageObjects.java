package com.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageObjects {

    private final WebDriver driver;
    public PageObjects(WebDriver driver) {
        this.driver = driver;
    }

    public void FillTextBox(String tag, String value){
        this.driver.findElement(By.name(tag)).sendKeys(value);
    }

    public void FillTextBoxViaXpath(String tag, String value) {
        this.driver.findElement(By.xpath(tag)).sendKeys(value);
    }

    public void ChooseRadioButton(String tag, Integer elem) {
        WebElement radio = this.driver.findElements(By.name(tag)).get(elem);
        Actions actions = new Actions(driver);

        actions.moveToElement(radio).click().perform();
    }

    public void ClickOnCheckBox(String tag, Integer elem) {
        WebElement radio = this.driver.findElements(By.name(tag)).get(elem);
        Actions actions = new Actions(driver);

        actions.moveToElement(radio).click().perform();
    }

    public void Select(String tag, Integer index) {
        Select drp = new Select(this.driver.findElement(By.name(tag)));
        drp.selectByIndex(index);
    }

    public void Submit(String tag) {
        this.driver.findElement(By.name(tag)).click();
    }
}
