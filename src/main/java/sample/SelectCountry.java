package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
public class SelectCountry {
   // public static WebDriver driver = null;
    @Test
   public void invoke1(){
       ChromeOptions options = new ChromeOptions();
       options.addArguments("start-maximized"); // open Browser in maximized mode
       options.addArguments("disable-infobars"); // disabling infobars
       options.addArguments("--disable-extensions"); // disabling extensions
       options.addArguments("--disable-gpu"); // applicable to windows os only
       options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
       options.addArguments("--no-sandbox"); // Bypass OS security model
       WebDriver driver = new ChromeDriver(options);
        driver.get("https://google.com");
   }


  /*  public void InvokeDriver() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40L, TimeUnit.SECONDS);



    }
    @Test
    public void cheki(){
        this.invoke1();

    }
   /* @Test
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

    }*/

}
