package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String BaseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp()
    {
        openBrowser(BaseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully()
    {
        //click on the ‘Sign In’ link
        WebElement ClickLink =driver.findElement(By.linkText("Sign In"));
        ClickLink.click();

        //* Verify the text ‘Welcome Back!’
        WebElement VerifyText = driver.findElement(By.xpath("//h1[@class='page__heading']"));
        String actualText = VerifyText.getText();
        String expectedTest = "Welcome Back!";
        Assert.assertEquals(expectedTest,actualText);

    }

    @Test
    public void verifyTheErrorMessage()
    {
        //click on the ‘Sign In’ link
        WebElement ClickLink =driver.findElement(By.linkText("Sign In"));
        ClickLink.click();

        //* Enter invalid username
        WebElement InvalidUsername = driver.findElement(By.xpath("//input[@id='user[email]']"));
        InvalidUsername.sendKeys("dfg@gmail.com");

        //* Enter invalid password
        WebElement InvalidPassword = driver.findElement(By.xpath("//input[@id='user[password]']"));
        InvalidPassword.sendKeys("dfg123456");

        //* Click on Login button
        WebElement LoginClick = driver.findElement(By.xpath("//input[@type='submit']")); // Click on Sign in button
        LoginClick.click();

        //* Verify the error message ‘Invalid email
        //or password.’
        WebElement VerifyText = driver.findElement(By.xpath("//div[@class='notice__form-error']"));
        String actualText = VerifyText.getText();
        String expectedText = "Invalid email or password.";
        Assert.assertEquals(expectedText,actualText);

    }
    @After
    public void closeBrowser()
    {
        //driver.quit();

    }

}
