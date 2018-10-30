package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class SelectCountry {
    public static WebDriver driver = null;


    public void InvokeDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40L, TimeUnit.SECONDS);
    }
@Test
    public void testCountries() {
        this.InvokeDriver();
        driver.get("https://www.cheki.com/");
        WebElement countries = driver.findElement(By.xpath("//div[@class='main']"));
        int mydriver = countries.findElements(By.tagName("a")).size();

        for(int i = 0; i < mydriver; ++i) {
            String clickonlinkTab = Keys.chord(new CharSequence[]{Keys.CONTROL, Keys.ENTER});
            ((WebElement)countries.findElements(By.tagName("a")).get(i)).sendKeys(new CharSequence[]{clickonlinkTab});

            try {
                Thread.sleep(5000L);
            } catch (InterruptedException var6) {
                var6.printStackTrace();
            }
        }

        Set<String> abc = driver.getWindowHandles();
        Iterator it = abc.iterator();

        while(it.hasNext()) {
            driver.switchTo().window((String)it.next());
            System.out.println(driver.getTitle());
        }

    }
}
