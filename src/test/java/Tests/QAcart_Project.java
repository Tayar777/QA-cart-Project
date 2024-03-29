package Tests;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QAcart_Project {

    SHAFT.GUI.WebDriver driver;

    @BeforeTest
    public void OpenBrowser ()
    {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://hatem-hatamleh.github.io/Selenium-html/");
    }

    @Test (priority = 1)
    public void Locators ()
    {
        By LocatorButton = By.xpath("//a[@class='button locators']");
        driver.element().click(LocatorButton);

        By SeleniumButton = By.id("selenium");
        By AppiumButton = By.name("appium");
        By CypressButton = By.cssSelector("[data-testid=cypress]");
        By WdioButton = By.id("wdio");
        By PlaywrightButton = By.name("playwright");
        By RestAssuredButton = By.cssSelector("[data-testid=rest]");
        By PostmanButton = By.id("postman");
        By DetoxButton = By.name("detox");

        driver.element().click(SeleniumButton);
        driver.element().click(AppiumButton);
        driver.element().click(CypressButton);
        driver.element().click(WdioButton);
        driver.element().click(PlaywrightButton);
        driver.element().click(RestAssuredButton);
        driver.element().click(PostmanButton);
        driver.element().click(DetoxButton);

        driver.browser().navigateBack();
    }

    @Test (priority = 2)
    public void Actions ()
    {
        By ActionsButton = By.xpath("//a[@class='button actions']");
        driver.element().click(ActionsButton);

        By FirstName_TextBox = By.name("firstName");
        By LastName_TextBox = By.name("lastName");
        By Level_DropDown = By.name("level");
        By Web_RadioButton = By.id("web");
        By ClickMe_Button = By.id("actions-button");

        driver.element().type(FirstName_TextBox, "Ahmed");
        driver.element().type(LastName_TextBox, "Tarek");
        driver.element().select(Level_DropDown, "Junior");
        driver.element().click(Web_RadioButton);
        driver.element().click(ClickMe_Button);

        driver.element().alert().isAlertPresent();
        String AlertText = driver.element().alert().getAlertText();
        System.out.println(AlertText);
        driver.element().alert().acceptAlert();

        driver.browser().navigateBack();
    }

    @Test (priority = 3)
    public void Windows ()
    {
        By WindowsButton = By.xpath("//a[@class='button windows']");
        driver.element().click(WindowsButton);
        String MainWindow = driver.browser().getWindowHandle();

        By YouTubeButton = By.xpath("//a[@class='button youtube']");
        driver.element().click(YouTubeButton);
        driver.browser().switchToWindow(MainWindow);

        By OfficialWebsiteButton = By.xpath("//a[@class='button website']");
        driver.element().click(OfficialWebsiteButton);
        driver.browser().switchToWindow(MainWindow);

        By LinkedInButton = By.xpath("//a[@class='button linkedin']");
        driver.element().click(LinkedInButton);
        driver.browser().switchToWindow(MainWindow);

        By FacebookButton = By.xpath("//a[@class='button facebook']");
        driver.element().click(FacebookButton);
        driver.browser().switchToWindow(MainWindow);

        driver.browser().navigateBack();
    }

    @Test (priority = 4)
    public void Waits ()
    {
        By WaitsButton = By.xpath("//a[@class='button waits']");
        driver.element().click(WaitsButton);

        By FirstButton = By.xpath("//button[@class='button primary']");
        driver.element().click(FirstButton);

        By SecondButton = By.xpath("//button[@class='button secondary']");
        driver.element().click(SecondButton);
        driver.element().alert().acceptAlert();

        driver.browser().navigateBack();
    }

    @Test (priority = 5)
    public void Alerts ()
    {
        By AlertsButton = By.xpath("//a[@class='button alerts']");
        driver.element().click(AlertsButton);

        By AlertButton = By.xpath("//button[@class='button alert']");
        driver.element().click(AlertButton);
        driver.element().alert().acceptAlert();

        By PromptButton = By.xpath("//button[@class='button prompt']");
        driver.element().click(PromptButton);
        driver.element().performAlertAction().typeIntoPromptAlert("Ahmed Tarek");
        driver.element().alert().acceptAlert();

        driver.browser().navigateBack();
    }

    @Test (priority = 6)
    public void Frames ()
    {
        By FramesButton = By.xpath("//a[@class='button frames']");
        driver.element().click(FramesButton);

        By OneFrame = By.name("qacart");
        driver.element().switchToIframe(OneFrame);

        By FirstName_TextBox = By.name("firstName");
        By LastName_TextBox = By.name("lastName");
        By Level_DropDown = By.name("level");
        By Web_RadioButton = By.id("web");
        By ClickMe_Button = By.id("actions-button");

        driver.element().type(FirstName_TextBox, "Ahmed");
        driver.element().type(LastName_TextBox, "Tarek");
        driver.element().select(Level_DropDown, "Junior");
        driver.element().click(Web_RadioButton);
        driver.element().click(ClickMe_Button);

        driver.element().alert().acceptAlert();

        driver.element().switchToDefaultContent();
        By NestedFrames1 = By.name("menu");
        driver.element().switchToIframe(NestedFrames1);

        By NestedFrames2 = By.name("links");
        driver.element().switchToIframe(NestedFrames2);

        By LocatorButton = By.xpath("//a[@class='button locators']");
        driver.element().click(LocatorButton);
    }

    @AfterTest
    public void QuitBrowser ()
    {
        driver.quit();
    }



}
