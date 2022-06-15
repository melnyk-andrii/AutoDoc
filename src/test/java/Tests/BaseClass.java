package Tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    AppiumDriver<MobileElement> driver;

    @BeforeSuite()
    public void setup()  {

        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability(CapabilityType.PLATFORM_NAME,"android");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
            caps.setCapability("appPackage","de.autodoc.gmbh");
            caps.setCapability("appActivity","de.autodoc.gmbh.ui.activity.SplashActivity");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
            caps.setCapability(MobileCapabilityType.NO_RESET,true);

            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            driver = new AndroidDriver<MobileElement>(url, caps);

            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        } catch (Exception exp) {
            System.out.println("Cause is: " + exp.getCause());
            System.out.println("Message is: " + exp.getMessage());
            exp.printStackTrace();
        }


    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }
}
