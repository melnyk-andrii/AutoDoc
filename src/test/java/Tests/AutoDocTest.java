package Tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AutoDocTest extends BaseClass  {

    private String createdCarMarkAndModel = "MAZDA 3 Saloon (BK) (09.1999 - 06.2009)",
                   createdCarEngine = "2.0 MZR-CD (105 KW / 143 PS) (12.2006 - 06.2009)",
                   editedCarEngine = "280 SL 2.8 (134 KW / 182 PS) (09.1967 - 12.1971)";

    @Test(priority = 1)
    public void createCar() {
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 60);

        MobileElement carCreateButton = driver.findElementById("de.autodoc.gmbh:id/lvHeader");
        wait.until(ExpectedConditions.visibilityOf(carCreateButton)).click();

        MobileElement carMarkField = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        wait.until(ExpectedConditions.visibilityOf(carMarkField)).click();

        MobileElement searchField = driver.findElementById("de.autodoc.gmbh:id/etSearchField");
        wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.clear();
        searchField.sendKeys("Mazda");

        MobileElement searchList = driver.findElementById("de.autodoc.gmbh:id/rvList");
        wait.until(ExpectedConditions.visibilityOf(searchList));

        MobileElement firstElementInSearch = driver.findElementById("de.autodoc.gmbh:id/title");
        wait.until(ExpectedConditions.visibilityOf(firstElementInSearch)).click();

        wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys("3 Saloon (BK) (09.1999 - 06.2009)");
        wait.until(ExpectedConditions.visibilityOf(searchList));
        wait.until(ExpectedConditions.visibilityOf(firstElementInSearch)).click();

        wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys("2.0 MZR-CD (105 KW / 143 PS) (12.2006 - 06.2009)");
        wait.until(ExpectedConditions.visibilityOf(searchList));
        wait.until(ExpectedConditions.visibilityOf(firstElementInSearch)).click();

        String getCreatedCarMarkAndModel = driver.findElementByClassName("android.widget.TextView").getText();
        String getCreatedCarEngine = driver.findElementById("de.autodoc.gmbh:id/tvDesc").getText();

        Assert.assertEquals(getCreatedCarMarkAndModel, createdCarMarkAndModel);
        Assert.assertEquals(getCreatedCarEngine, createdCarEngine);
    }

    @Test(priority = 2)
    public void editCar() {

        WebDriverWait wait = new WebDriverWait(driver, 60);

        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        MobileElement carContainer = driver.findElementById("de.autodoc.gmbh:id/swipeContent");
        wait.until(ExpectedConditions.visibilityOf(carContainer)).click();


        Point location = carContainer.getLocation();
        Dimension dimension = carContainer.getSize();

        int anchor = dimension.getHeight() / 2;
        Double screenWidthStart = dimension.getWidth() * 0.8;
        int swipeStart = screenWidthStart.intValue();

        Double screenWidthEnd = dimension.getWidth() * 0.2;
        int swipeEnd = screenWidthEnd.intValue();

        (new TouchAction(driver))
                .press(PointOption.point(swipeStart, anchor + location.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(swipeEnd, anchor + location.y))
                .release().perform();

        MobileElement editButton = driver.findElementById("de.autodoc.gmbh:id/btnEdit");

        wait.until(ExpectedConditions.visibilityOf(editButton)).click();

        MobileElement editCarMark = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]");
        wait.until(ExpectedConditions.visibilityOf(editCarMark)).click();

        MobileElement searchInput = driver.findElementById("de.autodoc.gmbh:id/etSearchField");
        wait.until(ExpectedConditions.visibilityOf(searchInput)).clear();
        searchInput.sendKeys("mercedes-benz");
        MobileElement searchList = driver.findElementById("de.autodoc.gmbh:id/rvList");
        wait.until(ExpectedConditions.visibilityOf(searchList));
        MobileElement searchValueSelect = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout");
        searchValueSelect.click();

        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("W111 Coupe (W111) (01.1961 - 12.1971");
        wait.until(ExpectedConditions.visibilityOf(searchList));
        MobileElement el8 = driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[4]/android.widget.LinearLayout/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout");
        el8.click();
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys("280 SL 2.8 (134 KW / 182 PS) (09.1967 - 12.1971)");
        wait.until(ExpectedConditions.visibilityOf(searchList));
        MobileElement el10 = driver.findElementById("de.autodoc.gmbh:id/title");
        el10.click();

        MobileElement saveCarButton = driver.findElementById("de.autodoc.gmbh:id/tsbSaveCar");
        wait.until(ExpectedConditions.visibilityOf(saveCarButton)).click();

        String editedCreatedCarEngineText = driver.findElementById("de.autodoc.gmbh:id/tvDesc").getText();
        Assert.assertEquals(editedCreatedCarEngineText, editedCarEngine);
    }

    @Test(priority = 3)
    public void deleteCar() {
        WebDriverWait wait = new WebDriverWait(driver, 60);

        MobileElement carContainer = driver.findElementById("de.autodoc.gmbh:id/swipeContent");
        wait.until(ExpectedConditions.visibilityOf(carContainer)).click();


        Point location = carContainer.getLocation();
        Dimension dimension = carContainer.getSize();

        int anchor = dimension.getHeight() / 2;
        Double screenWidthStart = dimension.getWidth() * 0.8;
        int swipeStart = screenWidthStart.intValue();

        Double screenWidthEnd = dimension.getWidth() * 0.2;
        int swipeEnd = screenWidthEnd.intValue();

        (new TouchAction(driver))
                .press(PointOption.point(swipeStart, anchor + location.y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
                .moveTo(PointOption.point(swipeEnd, anchor + location.y))
                .release().perform();


        MobileElement deleteButton = driver.findElementById("de.autodoc.gmbh:id/btnDelete");

        wait.until(ExpectedConditions.visibilityOf(deleteButton)).click();

        MobileElement addCarButton = driver.findElementByClassName("android.widget.ImageButton");
        wait.until(ExpectedConditions.visibilityOf(addCarButton));
    }
}
