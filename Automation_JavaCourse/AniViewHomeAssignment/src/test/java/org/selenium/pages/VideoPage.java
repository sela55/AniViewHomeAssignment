package org.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.selenium.base.BasePage;


public class VideoPage extends BasePage {

    private WebElement comments;
//    private final By dateTime;
    private final By overlay= By.xpath("//*[@class='sc-jXQZqI cFdgZB']");
    private By requestedUsername;
    private By requestedComment;
    private final String IDOfComments;


    public VideoPage(WebDriver driver, String idOfComment) {
        super(driver);
        scrollDown();
        waitForOverlaysToDisappear(overlay);
        this.IDOfComments = idOfComment;
    }

    public WebElement getRequestedComment() {
            requestedComment = (By.xpath("//*[@id='" + this.IDOfComments + "']//p[@class='first']"));
            return getElementAfterWait(requestedComment);
    }

    public WebElement getRequestedUsername() {
            requestedUsername = (By.xpath("//*[@id='" + this.IDOfComments + "']//span//a"));
            return getElementAfterWait(requestedUsername);
    }

    private void scrollDown() {
        Actions builder = new Actions(driver);
        builder.moveByOffset(50, 100).perform();
        WebElement element = getElementAfterWait(By.id("comments"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
