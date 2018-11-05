package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Registration {
    public static WebDriver driver = null;

    public Registration() {
    }

    public void InvokeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kuda Zhou\\IdeaProjects\\chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40L, TimeUnit.SECONDS);

    }

    @Test
    public void testLoginLink() {
        this.InvokeDriver();
        driver.get("https://www.cheki.co.ke/");

        try {
            Thread.sleep(200L);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, var3);
        }

        driver.findElement(By.linkText("Login")).click();

        try {
            Thread.sleep(200L);
        } catch (InterruptedException var2) {
            var2.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, var2);
        }

        driver.findElement(By.linkText("Register Now As a Private Seller!")).click();
    }

    @Test
    public void testRegistration() {
        driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(new CharSequence[]{"testtest@gmail.com"});
        driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys(new CharSequence[]{"testtest"});
        driver.findElement(By.xpath("//input[@value='Register']")).click();
    }

}
