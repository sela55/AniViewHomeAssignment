package org.selenium.base;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.selenium.Objects.MetaData;
import org.selenium.Utils.JacksonUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import java.io.IOException;


public class BaseTest {
    protected WebDriver driver;
    protected RequestSpecification request;
    protected Response response;
    protected MetaData metaData1;

    @BeforeClass
    public void startDriver() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        metaData1 = JacksonUtils.deserializeJson("metaData.json", MetaData.class);
        RestAssured.baseURI = metaData1.getBaseURI();
        request = RestAssured.given();
    }

    @AfterClass
    public void quitDriver() {
        driver.close();
    }
}
