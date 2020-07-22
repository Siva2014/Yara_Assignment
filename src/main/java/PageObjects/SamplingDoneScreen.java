package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SamplingDoneScreen {
    public SamplingDoneScreen(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility="navBarLeftButton_navBar")
    public MobileElement btnClose;

    @AndroidFindBy(accessibility="title_navBar")
    public MobileElement textTitleLeafColorList;
    @AndroidFindBy(accessibility="img_almostDoneScreen_0")
    public MobileElement imgLeafList1;
    @AndroidFindBy(accessibility="img_almostDoneScreen_1")
    public MobileElement imgLeafList2;
    @AndroidFindBy(accessibility="img_almostDoneScreen_2")
    public MobileElement imgLeafList3;
    @AndroidFindBy(accessibility="img_almostDoneScreen_3")
    public MobileElement imgLeafList4;
    @AndroidFindBy(accessibility="img_almostDoneScreen_4")
    public MobileElement imgLeafList5;
    @AndroidFindBy(accessibility="img_almostDoneScreen_5")
    public MobileElement imgLeafList6;
    @AndroidFindBy(accessibility="img_almostDoneScreen_6")
    public MobileElement imgLeafList7;
    @AndroidFindBy(accessibility="img_almostDoneScreen_7")
    public MobileElement imgLeafList8;
    @AndroidFindBy(accessibility="img_almostDoneScreen_8")
    public MobileElement imgLeafList9;
    @AndroidFindBy(accessibility="img_almostDoneScreen_9")
    public MobileElement imgLeafList10;

    @AndroidFindBy(accessibility="img_lccDone")
    public MobileElement imgDone;
    @AndroidFindBy(accessibility="txt_almostdone")
    public MobileElement textThankYou;


    @AndroidFindBy(id = "android:id/content")
    public MobileElement frameForAlert;
    @AndroidFindBy(accessibility="title_alert_cancel_getResults")
    public MobileElement textTitleAlertStopSampling;
    @AndroidFindBy(accessibility="msg_alert_cancel_getResults")
    public MobileElement textSamplesWillNotBeSaved;
    @AndroidFindBy(accessibility="btnAllow_alert_cancel_getResults")
    public MobileElement btnYesAlert;
    @AndroidFindBy(accessibility="denyBtn_alert_cancel_getResults")
    public MobileElement btnCancelAlert;





}
