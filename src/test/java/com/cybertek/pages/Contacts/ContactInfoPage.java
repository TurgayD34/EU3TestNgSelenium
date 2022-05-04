package com.cybertek.pages.Contacts;

import com.cybertek.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage {

    @FindBy(css = "div.pull-left>h1.user-name")
    public WebElement fullName;

    @FindBy(xpath = "//a[@class='phone']")
    public WebElement phone;

    @FindBy(xpath = "//a[@class='email']")
    public WebElement email;
}
