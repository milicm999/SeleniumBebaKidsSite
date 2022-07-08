import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class setUpTestEnvironment {

    private WebDriver driver;
    private FirefoxOptions options;
    private DesiredCapabilities capabilities;
    private WebDriverWait wait1;

    private JavascriptExecutor js;

    public setUpTestEnvironment()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\milicm\\OneDrive - Comtrade Group\\Desktop\\QA assignment_Marija_Milic\\geckodriver.exe");
        FirefoxProfile profile = new FirefoxProfile();
//        File addblockefile= new File("C://Users/milicm/Downloads/adblock_plus-3.14.xpi");
//        profile.addExtension(addblockefile);
//        profile.setPreference("extensions.adblockplus.currentVersion", "2.4");
        options = new FirefoxOptions();
        options.setProfile(profile);
        driver=new FirefoxDriver(options);
        js=(JavascriptExecutor)driver;
        wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
        driver.manage().window().maximize();
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(0));
        driver.get("https://www.bebakids.com/");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public FirefoxOptions getOptions() {
        return options;
    }

    public void setOptions(FirefoxOptions options) {
        this.options = options;
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(DesiredCapabilities capabilities) {
        this.capabilities = capabilities;
    }

    public WebDriverWait getWait1() {
        return wait1;
    }

    public void setWait1(WebDriverWait wait1) {
        this.wait1 = wait1;
    }


    public JavascriptExecutor getJs() {
        return js;
    }

    public void setJs(JavascriptExecutor js) {
        this.js = js;
    }
}

