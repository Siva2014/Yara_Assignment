package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActivityHistoryNone {

    public ActivityHistoryNone(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility="title_navbar_activity_history")
    public MobileElement textTitle;
    @AndroidFindBy(accessibility="navBarLeftButton_navbar_activity_history")
    public MobileElement btnSettings;

    @AndroidFindBy(accessibility="img_noDataComponent")
    public MobileElement imgNoDataComponent;
    @AndroidFindBy(accessibility="title_noDataComponent")
    public MobileElement textTrackNLevel;

    @AndroidFindBy(accessibility="img_button_new_Sample")
    public MobileElement imgPlusSign;


    @AndroidFindBy(accessibility="container_button_new_Sample")
    public MobileElement btnNewSample;
    @AndroidFindBy(accessibility="btnText_button_new_Sample")
    public MobileElement textNewSample;

}
