
import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.xml.sax.Attributes;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;


public class TestingBebaKids {

    @BeforeEach
    public void waitToFinish() throws InterruptedException {
        wait(10);
    }



    @Test
    public void testLogIn() throws IOException, InterruptedException {
        //Testing if right  picked products are in the basket

        setUpTestEnvironment test=new setUpTestEnvironment();
        WebDriver driver=test.getDriver();
        WebDriverWait wait=test.getWait1();
        JavascriptExecutor executor= test.getJs();

        wait.until(ExpectedConditions.titleIs("Najnoviji modni trendovi odeće, obuće i aksesoara | BEBAKIDS"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'login-btn')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'login_form')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_email"))).sendKeys("marija99milic@yahoo.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password"))).sendKeys("shara99xx");

        driver.findElement(By.xpath("//*[contains(@class,'btn btn-success btn-login confirm-loader')]")).click();

        Boolean display=wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Marija Milic"))).isDisplayed();

        assertEquals(true, display);


        driver.quit();
    }
    @Test
    public void testShopingCard() throws IOException
    {
        setUpTestEnvironment test=new setUpTestEnvironment();
        WebDriver driver=test.getDriver();
        WebDriverWait wait=test.getWait1();
        JavascriptExecutor executor= test.getJs();

        wait.until(ExpectedConditions.titleIs("Najnoviji modni trendovi odeće, obuće i aksesoara | BEBAKIDS"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class,'login-btn')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'login_form')]")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_email"))).sendKeys("marija99milic@yahoo.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password"))).sendKeys("shara99xx");

        driver.findElement(By.xpath("//*[contains(@class,'btn btn-success btn-login confirm-loader')]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'https://www.bebakids.com/landing-bebe')]"))).click();
        //wait.until(ExpectedConditions.titleIs("Landing bebe | BEBAKIDS"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@class,'cookie-agree-gdpr')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'modal-content text-center')]")));
        List<WebElement> list=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'close')]")));
        WebElement e=list.get(1);
        e.click();


//        List<WebElement> list1=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'icon fa fa-angle-right visible-xs')]")));
//        WebElement arrowDown=list1.get(0);
//
//        List<WebElement> list2=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[contains(@href,'https://www.bebakids.com/decija-odeca/beba-kids/muski/?sizeEU=56,62,68,74')]")));
//        WebElement babyBoys=list2.get(0);
//
//
//        Actions action=new Actions(driver);
//
//        action.moveToElement(arrowDown);
//        action.moveToElement(babyBoys).click();


        WebElement slider=driver.findElement(By.xpath("//*[contains(@class,'slider_recommend_baby')]"));
        executor.executeScript("slider.setAtributte('slider_recommend_baby','slider_recommend_baby active')");




    }

}
