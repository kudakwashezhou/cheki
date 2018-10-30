package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NavigationBar {
    public static WebDriver driver = null;

    public NavigationBar() {
    }

    public void InvokeDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40L, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void testLogoLink() {
        this.InvokeDriver();
        driver.get("https://www.cheki.co.ke/");

        try {
            Thread.sleep(200L);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, var3);
        }

        driver.findElement(By.xpath("//img[@alt='Cheki ']")).click();

        try {
            Thread.sleep(200L);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, var2);
        }

    }

    @Test(
            priority = 2
    )
    public void testTopLinks() {
        WebElement links = driver.findElement(By.cssSelector("nav.top-bar"));
        int mydriver = links.findElements(By.tagName("a")).size();

        for(int i = 0; i < mydriver; ++i) {
            String clickonlinkTab = Keys.chord(new CharSequence[]{Keys.CONTROL, Keys.ENTER});
            ((WebElement)links.findElements(By.tagName("a")).get(i)).sendKeys(new CharSequence[]{clickonlinkTab});

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
