package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TakeSample_NoHistory {
    public TakeSample_NoHistory(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility="title_nav_bar_add_crop")
    public MobileElement textTitle;
    @AndroidFindBy(accessibility="navBarLeftButton_nav_bar_add_crop")
    public MobileElement btnSettings;

    @AndroidFindBy(accessibility="image_add_crop")
    public MobileElement imgAddCropBig;

    @AndroidFindBy(accessibility="image_add_crop_first")
    public MobileElement imgTrackNLevel;
    @AndroidFindBy(accessibility="txt_add_crop_first")
    public MobileElement textTrackNLevel;

    @AndroidFindBy(accessibility="image_add_crop_second")
    public MobileElement imgRegularChecks;
    @AndroidFindBy(accessibility="txt_add_crop_second")
    public MobileElement textRegularChecks;

    @AndroidFindBy(accessibility="image_add_crop_third")
    public MobileElement imgCreateMultipleFields;
    @AndroidFindBy(accessibility="txt_add_crop_third")
    public MobileElement textCreateMultipleFields;


    @AndroidFindBy(accessibility="button_add_crop")
    public MobileElement btnAddCrop;
    @AndroidFindBy(accessibility="btnText_add_crop")
    public MobileElement textAddCrop;
}
