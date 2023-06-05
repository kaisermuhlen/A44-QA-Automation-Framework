import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PlaylistTests extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
       // String playlist = generateRandomName();
        openUrl();
        login("ekaterina.kurbatova@testpro.io", "te$t$tudent");
//create playlist
        WebElement plusBtn = driver.findElement(By.cssSelector("[data-testid='sidebar-create-playlist-btn']"));
        plusBtn.click();
        WebElement newPlaylist = driver.findElement(By.cssSelector("[data-testid='playlist-context-menu-create-simple']"));
        newPlaylist.click();
        WebElement inputPlaylistName = driver.findElement(By.cssSelector("input[name='name']"));
        inputPlaylistName.click();
        inputPlaylistName.clear();
        inputPlaylistName.sendKeys("katerry");
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();

        Thread.sleep(3000);
        WebElement playlistHeader = driver.findElement(By.cssSelector("#playlistWrapper h1"));
        Assert.assertEquals(playlistHeader.getText(), "katerry");

        //Delete Playlist
        WebElement deletePlayListBtn = driver.findElement(By.cssSelector(".btn-delete-playlist"));
        deletePlayListBtn.click();

        //assertion
        WebElement banner = driver.findElement(By.cssSelector(".success"));
        Assert.assertTrue(banner.isDisplayed());

       /* List<WebElement> playlists = driver.findElements(By.cssSelector("#playlists a"));
        List<String> playlistNames = new ArrayList<>();

        for (int i = 0; i < playlists.size(); i++) {
            String playlistName = playlists.get(i).getText();
            playlistNames.add(playlistName);

          System.out.println(playlistNames);

            Assert.assertFalse(playlistNames.contains("katerry"));

        }*/


    }
}
