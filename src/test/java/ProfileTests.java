import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test
    public void changeProfileName() {
        openUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        // open profile
        WebElement avatar = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".avatar")));
        avatar.click();
        // type password
        WebElement currentPasswordInput = wait.until(ExpectedConditions
                .elementToBeClickable(By.id("inputProfileCurrentPassword")));
        currentPasswordInput.click();
        currentPasswordInput.clear();
        currentPasswordInput.sendKeys("te$t$tudent");
        // type new name
        String name = generateRandomName();
        System.out.println(name);
        WebElement profileName = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#inputProfileName")));
        profileName.click();
        profileName.clear();
        profileName.sendKeys(name);
        // type email
        WebElement emailInput = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("#inputProfileEmail")));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("demo@class.com");
        // click save
        WebElement saveBtn = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector(".btn-submit")));
        saveBtn.click();
        // assert profile name is new
        driver.navigate().refresh();
        WebElement profile = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(".view-profile>span")));
        String newName = profile.getText();
        Assert.assertEquals(newName, name);
    }
}
