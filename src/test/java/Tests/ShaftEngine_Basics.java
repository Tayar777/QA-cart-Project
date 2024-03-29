package Tests;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ShaftEngine_Basics {

    /*
       - At first we create a maven project
       - Add the highlighted code to the POM.xml file (from this link: https://github.com/ShaftHQ/SHAFT_ENGINE?tab=readme-ov-file)
       - from src-> main -> resources -> properties -> customWebdriverCapabilities.properties    you can control all the properties
       - to know what are the properties which you can control. visit the website of the user guide of shaft (https://shafthq.github.io/docs/Getting_Started/first_steps)
       - some of these properties are (browser-waits-report-....)
     */

    @Test
    public void OpenChromeBrowser ()
    {
        SHAFT.GUI.WebDriver driver = new SHAFT.GUI.WebDriver();                       //Open the browser
        driver.browser().navigateToURL("https://www.facebook.com/");         //Navigate to URL
        String URL = driver.browser().getCurrentURL();                                //getURL
        String Title = driver.browser().getCurrentWindowTitle();                      //getTitle
        System.out.println(URL);
        System.out.println(Title);

        By Email_TextBox = By.cssSelector("[name=email]");                             //Locator
        By Password_TextBox = By.cssSelector("[name=pass]");
        By LoginButton = By.cssSelector("[name=login]");

        String name1 = driver.element().getText(LoginButton);                         //GetText
        System.out.println(name1);

        driver.element().type(Email_TextBox, "ahmedtarek");                      //SendKeys-sendText
        driver.element().type(Password_TextBox, "ahmedtarek");

        driver.browser().navigateToURL("https://www.facebook.com/signup");

        By FirstName = By.cssSelector("[name=firstname]");
        driver.element().type(FirstName, "Ahmed");

        By DOB_DropDown = By.cssSelector("[name=birthday_day]");
        driver.element().select(DOB_DropDown, "15");                    //SelectFromDrobDown

        By MaleRadioButton = By.xpath("//input[@value='2']");
        driver.element().click(MaleRadioButton);                                         //Click

        By SignUp_Button = By.xpath("//button[@name='websubmit']");
        driver.element().click(SignUp_Button);

        By AssertionElement = By.xpath("//div[@class='uiContextualLayer uiContextualLayerBelowLeft']");
        driver.assertThat().element(AssertionElement).exists();                               //Assertion
        String text = driver.element().getText(AssertionElement);
        System.out.println(text);


    }

}
