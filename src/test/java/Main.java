import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args){

        setUpTestEnvironment test=new setUpTestEnvironment();
        WebDriver driver=test.getDriver();
        WebDriverWait wait=test.getWait1();
        JavascriptExecutor executor= test.getJs();

        wait.until(ExpectedConditions.titleIs("Najnoviji modni trendovi odeće, obuće i aksesoara | BEBAKIDS"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Prijavite se"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_email"))).sendKeys(Keys.COMMAND,"marija99milic@yahoo.com");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login_password"))).sendKeys(Keys.COMMAND,"shara99xx");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/div/form/div[3]/button/span[1]"))).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/header/div[3]/nav/div/ul/li[1]/a/span"))).click();
        wait.until(ExpectedConditions.titleIs("Landing bebe | BEBAKIDS"));

        List<WebElement> boysAndGirls =wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[1]/main/div[1]/div/div/div/div[1]/map/area[2]")));
        boysAndGirls.get(2).click();


    }
}
