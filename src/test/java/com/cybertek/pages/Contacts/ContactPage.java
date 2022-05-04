package com.cybertek.pages.Contacts;

import com.cybertek.pages.BasePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactPage extends BasePage {

    public WebElement getContactEmail(String email) {
        String xpath = "//td[contains(text(),'" + email + "') and @data-column-label='Email']";
        return Driver.get().findElement(By.xpath(xpath));
    }
}
