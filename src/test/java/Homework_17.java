import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class Homework_17 extends BaseTest {
    @Test
    public void addSongToPlaylist() {
        String text = "Dark Days";
        openUrl();
        enterEmail("ekaterina.kurbatova@testpro.io");
        enterPassword("te$t$tudent");
        clickLoginBtn();

        //search for song
        WebElement searchForSong = driver.findElement(By.cssSelector("#searchForm>[type='search']"));
        searchForSong.click();
        searchForSong.clear();
        searchForSong.sendKeys(text);

        //View All
        WebElement viewAllSongs = driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        viewAllSongs.click();

        //select first song
        WebElement firstSong = driver.findElement(By.cssSelector(".search-results .song-item .title"));
        firstSong.click();

        //add to playlist
        WebElement addSongToPlaylist = driver.findElement(By.cssSelector("[data-test='add-to-btn']"));
        addSongToPlaylist.click();

        //create new Playlist
        String newName = generateRandomPlayListName();
        WebElement addNewPlaylist = driver.findElement(By.cssSelector("[id='songResultsWrapper'] [placeholder='Playlist name']"));
        addNewPlaylist.click();
        addNewPlaylist.clear();
        addNewPlaylist.sendKeys(newName);

        //click submit button
        new Actions(driver)
                .keyDown(Keys.ENTER)
                .perform();

       // WebElement submitButton = driver.findElement(By.cssSelector("#songsWrapper .new-playlist  button[title='Save']"));
       // submitButton.click();

        //assertion
        WebElement successPopup = driver.findElement(By.cssSelector(".success"));
        Assert.assertTrue(successPopup.isDisplayed());

        WebElement songName = driver.findElement(By.cssSelector("#playlistWrapper .song-item .title"));
        String songText = songName.getText();
        Assert.assertEquals(songText, text);








    }


}
