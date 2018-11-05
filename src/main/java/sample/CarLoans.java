package sample;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
public class CarLoans {
    public static WebDriver driver = null;

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

    @Test(priority = 1)
    public void testFinanceForm() {
        this.InvokeDriver();
        driver.get("https://www.cheki.co.ke/car-loans");

        try {
            Thread.sleep(200L);
        } catch (InterruptedException var7) {
            var7.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, var7);
        }

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement Element = driver.findElement(By.name("condition_type_id"));
        js.executeScript("arguments[0].scrollIntoView();", new Object[]{Element});
        Select s = new Select(driver.findElement(By.name("condition_type_id")));
        s.selectByVisibleText("Brand New");
        driver.findElement(By.name("name")).sendKeys(new CharSequence[]{"Testname"});
        driver.findElement(By.name("email")).sendKeys(new CharSequence[]{"Testemail@gmail.com"});
        s = new Select(driver.findElement(By.name("mobile_number_country")));
        s.selectByVisibleText("Zimbabwe (+263)");
        driver.findElement(By.name("mobile_number")).sendKeys(new CharSequence[]{"778177123"});
        driver.findElement(By.name("id_passport")).sendKeys(new CharSequence[]{"83-192351 P 83"});
        s = new Select(driver.findElement(By.name("employed")));
        s.selectByVisibleText("yes");
        driver.findElement(By.name("monthly_income")).sendKeys(new CharSequence[]{"25000"});
        driver.findElement(By.name("loan_amount")).sendKeys(new CharSequence[]{"75000"});
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        try {
            Thread.sleep(200L);
        } catch (InterruptedException var6) {
            var6.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, var6);
        }

        driver.findElement(By.xpath("//a[contains(text(),'Car Loans')]")).click();

        try {
            Thread.sleep(200L);
        } catch (InterruptedException var5) {
            var5.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, var5);
        }

    }

    @Test(
            priority = 2
    )
    public void testSubscribeNewsletter() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement Element = driver.findElement(By.cssSelector("input:nth-child(3)"));
        js.executeScript("arguments[0].scrollIntoView();", new Object[]{Element});
        driver.findElement(By.cssSelector("input:nth-child(3)")).sendKeys(new CharSequence[]{"test@gmail.com"});
        driver.findElement(By.cssSelector("input.alertsSubscribe__button")).click();
    }

    @Test(
            priority = 3
    )
    public void testFooterLeftLinks() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement Element = driver.findElement(By.xpath("//div[@class='first']"));
        js.executeScript("arguments[0].scrollIntoView();", new Object[]{Element});
        WebElement links = driver.findElement(By.xpath("//div[@class='first']"));
        int mydriver = links.findElements(By.tagName("a")).size();

        for(int i = 0; i < mydriver; ++i) {
            String clickonlinkTab = Keys.chord(new CharSequence[]{Keys.CONTROL, Keys.ENTER});
            ((WebElement)links.findElements(By.tagName("a")).get(i)).sendKeys(new CharSequence[]{clickonlinkTab});

            try {
                Thread.sleep(5000L);
            } catch (InterruptedException var9) {
                var9.printStackTrace();
            }
        }

        Set<String> abc = driver.getWindowHandles();
        Iterator it = abc.iterator();

        while(it.hasNext()) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException var8) {
                var8.printStackTrace();
            }

            driver.switchTo().window((String)it.next());
            System.out.println(driver.getTitle());
        }

    }

    @Test(
            priority = 4
    )
    public void testFooterMiddleLinks() {
        WebElement links = driver.findElement(By.xpath("//div[@class='second']"));
        int mydriver = links.findElements(By.tagName("a")).size();

        for(int i = 0; i < mydriver; ++i) {
            String clickonlinkTab = Keys.chord(new CharSequence[]{Keys.CONTROL, Keys.ENTER});
            ((WebElement)links.findElements(By.tagName("a")).get(i)).sendKeys(new CharSequence[]{clickonlinkTab});

            try {
                Thread.sleep(5000L);
            } catch (InterruptedException var7) {
                var7.printStackTrace();
            }
        }

        Set<String> abc = driver.getWindowHandles();
        Iterator it = abc.iterator();

        while(it.hasNext()) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException var6) {
                var6.printStackTrace();
            }

            driver.switchTo().window((String)it.next());
            System.out.println(driver.getTitle());
        }

    }

    @Test(
            priority = 5
    )
    public void testFooterRightLinks() {
        WebElement links = driver.findElement(By.xpath("//div[@class='last']"));
        int mydriver = links.findElements(By.tagName("a")).size();

        for(int i = 0; i < mydriver; ++i) {
            String clickonlinkTab = Keys.chord(new CharSequence[]{Keys.CONTROL, Keys.ENTER});
            ((WebElement)links.findElements(By.tagName("a")).get(i)).sendKeys(new CharSequence[]{clickonlinkTab});

            try {
                Thread.sleep(5000L);
            } catch (InterruptedException var7) {
                var7.printStackTrace();
            }
        }

        Set<String> abc = driver.getWindowHandles();
        Iterator it = abc.iterator();

        while(it.hasNext()) {
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException var6) {
                var6.printStackTrace();
            }

            driver.switchTo().window((String)it.next());
           // System.out.println(driver.getTitle());
        }

    }

}
