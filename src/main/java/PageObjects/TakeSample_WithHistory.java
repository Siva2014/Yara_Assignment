package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TakeSample_WithHistory {

    public TakeSample_WithHistory(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility="title_newSampleNavbar")
    public MobileElement textTitle;
    @AndroidFindBy(accessibility="navBarLeftButton_newSampleNavbar")
    public MobileElement btnClose;

    @AndroidFindBy(accessibility="title_addANewCrop")
    public MobileElement textTitleAddNewCrop;

    @AndroidFindBy(accessibility="img_add_NewCrop")
    public MobileElement imgAddCropBig;
    @AndroidFindBy(accessibility="title_add_NewCrop")
    public MobileElement textTrackNLevel;
    @AndroidFindBy(accessibility="button_button_add_new_crop")
    public MobileElement btnAddNewCrop;
    @AndroidFindBy(accessibility="btnText_button_add_new_crop")
    public MobileElement text_BtnAddNewCrop;
    @AndroidFindBy(accessibility="btnImg_button_add_new_crop")
    public MobileElement img_BtnAddNewCrop;



    @AndroidFindBy(accessibility="title_select_from_saved_crops")
    public MobileElement textSelectFromSaved;

    @AndroidFindBy(accessibility="savedCrops_saved_crops_0")
    public MobileElement listItem_1_SavedCrops;
    @AndroidFindBy(accessibility="img_saved_crops_0")
    public MobileElement img_Item1;
    @AndroidFindBy(accessibility="title_saved_crops_0")
    public MobileElement textFarmName_Item1;
    @AndroidFindBy(accessibility="subTitle_saved_crops_0")
    public MobileElement textDescription_Item1;
}
