package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class InstructionsScreen {

    public InstructionsScreen(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility="tutorial_backArrow_img")
    public MobileElement btnImgNavBack;

    @AndroidFindBy(accessibility="imgBackground_slide1")
    public MobileElement img_Step1;
    @AndroidFindBy(accessibility="header_slide1")
    public MobileElement textTitleHowToUseStep1;
    @AndroidFindBy(accessibility="step_slide1")
    public MobileElement textStep1;
    @AndroidFindBy(accessibility="content_slide1")
    public MobileElement textContentStep1;

    @AndroidFindBy(accessibility="imgBackground_slide2")
    public MobileElement img_Step2;
    @AndroidFindBy(accessibility="header_slide2")
    public MobileElement textTitleHowToUseStep2;
    @AndroidFindBy(accessibility="step_slide2")
    public MobileElement textStep2;
    @AndroidFindBy(accessibility="content_slide2")
    public MobileElement textContentStep2;

    @AndroidFindBy(accessibility="imgBackground_slide3")
    public MobileElement img_Step3;
    @AndroidFindBy(accessibility="header_slide3")
    public MobileElement textTitleHowToUseStep3;
    @AndroidFindBy(accessibility="step_slide3")
    public MobileElement textStep3;
    @AndroidFindBy(accessibility="content_slide3")
    public MobileElement textContentStep3;


    @AndroidFindBy(accessibility="button_skipButton")
    public MobileElement btnSkip;
    @AndroidFindBy(accessibility="btnText_skipButton")
    public MobileElement textSkip;

    @AndroidFindBy(accessibility="button_nextButton")
    public MobileElement btnNext;
    @AndroidFindBy(accessibility="btnText_nextButton")
    public MobileElement textNext;

    @AndroidFindBy(accessibility="button_startSampleButton")
    public MobileElement btnStartSample;
    @AndroidFindBy(accessibility="btnText_startSampleButton")
    public MobileElement textStartSample;
}
