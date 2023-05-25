import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class ProfileTests extends BaseTest {

    @Test
    public void changeProfileName() {
        openUrl();
        enterEmail("demo@class.com");
        enterPassword("te$t$tudent");
        clickLoginBtn();
        // open profile
        WebElement avatar = driver.findElement(By.cssSelector(".avatar"));
        avatar.click();
        // type password
        WebElement currentPasswordInput = driver.findElement(By.id("inputProfileCurrentPassword"));
        currentPasswordInput.click();
        currentPasswordInput.clear();
        currentPasswordInput.sendKeys("te$t$tudent");
        // type new name

        // type email
        WebElement emailInput = driver.findElement(By.cssSelector("#inputProfileEmail"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("demo@class.com");
        // click save
        WebElement saveBtn = driver.findElement(By.cssSelector(".btn-submit"));
        saveBtn.click();
        // assert profile name is new
        driver.navigate().refresh();
        WebElement profile = driver.findElement(By.cssSelector(".view-profile>span"));
        String newName = profile.getText();
        //Assert.assertEquals(newName, name);
    }

   /* private String generateRandomName() {
        Faker faker = new Faker(new Locale("en-US"));
        String newName = faker.address().cityName();;
        return newName;
    }*/
}