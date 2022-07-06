
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;



public class TestingBebaKids {

    @BeforeEach
    public void waitToFinish() throws InterruptedException {
        wait(10);
    }



    @Test
    public void testCart() throws IOException, InterruptedException {
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

}
