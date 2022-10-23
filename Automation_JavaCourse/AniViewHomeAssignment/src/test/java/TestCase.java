import jdk.jfr.Description;
import org.selenium.base.BaseTest;
import org.selenium.pages.VideoPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.HashMap;
import java.util.Map;

public class TestCase extends BaseTest {
    private final String requestedURL = "https://www.vimeo.com/";

    @Test(priority = 1)
    @Description("The method below will post a comment to a video using the Vimeo API")
    public void postACommentWithAPI(){
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", metaData1.getContentType());
        headers.put("authorization", metaData1.getAuthorization());
        request.headers(headers);
        Map<String, String> body = new HashMap<>();
        body.put("text", metaData1.getText());
        request.body(body);
        response = request.post("videos/"+ metaData1.getVideoCode()+"/comments");
        Assert.assertEquals(response.getStatusCode(), 201);
    }

    @Test(priority = 2, dependsOnMethods = {"postACommentWithAPI"})
    public void checkTheCommentWasEstablishedViaUI() {
        driver.get(this.requestedURL + metaData1.getVideoCode() + "/");
        String commentID = response.body().jsonPath().get("link");
        commentID = commentID.split("#")[1];
        VideoPage videoPage = new VideoPage(driver, commentID);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(videoPage.getRequestedComment().getText(), metaData1.getText()); // verify that the comment ID are matched
        softAssert.assertEquals(videoPage.getRequestedUsername().getText(), metaData1.getUsername()); // verify that the name of the username are matched
        softAssert.assertAll();
    }
}
