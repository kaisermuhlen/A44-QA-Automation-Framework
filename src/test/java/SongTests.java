import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SongTests extends BaseTest{
    @Test
    public void playSong(){
        openUrl();
        login("ekaterina.kurbatova@testpro.io", "te$t$tudent");
        WebElement buttonPlayOrResume = driver.findElement(By.cssSelector("[title='Play or resume']"));
        new Actions(driver)
                .moveToElement(buttonPlayOrResume)
                .perform();
        buttonPlayOrResume.click();

        WebElement pauseBtn = driver.findElement(By.cssSelector(".fa-pause"));
        Assert.assertTrue(pauseBtn.isDisplayed());
    }

        @Test
        public void addSongToPlaylist() {
            String text = "Dark Days";
            openUrl();

            login("ekaterina.kurbatova@testpro.io", "te$t$tudent");

            searchForSong(text);

            clickViewAllBtn();

            clickFirstSearchResultSong();

            clickAddToPlayListBtn();

            String playListName = generateRandomName();

            createNewPlayListWhileAddingSong(playListName);

            //Assert.assertTrue(isBannerDisplayed());
          WebElement banner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success")));
            Assert.assertTrue(banner.isDisplayed());

            Assert.assertEquals(text, getSongName());
        }

        public String getSongName(){
            WebElement songName = driver.findElement(By.cssSelector("#playlistWrapper .song-item .title"));
            String songText = songName.getText();
            return songText;
        }

   /*  public boolean isBannerDisplayed(){
         WebElement banner = driver.findElement(By.cssSelector(".success"));
            return banner.isDisplayed();
        }*/

        private void createNewPlayListWhileAddingSong(String playListName) {
            WebElement newPlayListNameInput = wait.until(ExpectedConditions
                    .elementToBeClickable(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']")));
            newPlayListNameInput.click();
            newPlayListNameInput.clear();
            newPlayListNameInput.sendKeys(playListName);
            new Actions(driver)
                    .keyDown(Keys.ENTER)
                    .perform();
        }

        private void clickAddToPlayListBtn() {
            WebElement addToBtn = wait.until(ExpectedConditions
                    .elementToBeClickable(By.cssSelector("[data-test='add-to-btn']")));
            addToBtn.click();
        }

        private void clickFirstSearchResultSong() {
            List<WebElement> songsInResults = driver.findElements(By.cssSelector(".search-results .song-item .title"));
            songsInResults.get(0).click();
        }

        private void clickViewAllBtn() {
            WebElement viewAllBtn = wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//button[@data-test='view-all-songs-btn']")));
            viewAllBtn.click();
        }

    }
