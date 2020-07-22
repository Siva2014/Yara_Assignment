package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WelcomeScreen {

        public WelcomeScreen(AndroidDriver<AndroidElement> driver)
        {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        }

        @AndroidFindBy(accessibility="rice_leaf_image_welcome_screen")
        public MobileElement imgLeaf;
        @AndroidFindBy(accessibility="text_welcome_to")
        public MobileElement textWelcome;
        @AndroidFindBy(accessibility="txtLeafColorChart")
        public MobileElement textLeafChart;
        @AndroidFindBy(accessibility="txt_smart_way_to_measure")
        public MobileElement textSmartWayToMeasure;


        @AndroidFindBy(accessibility="btnText_welcome_screen_continue")
        public MobileElement btnContinue;
        @AndroidFindBy(accessibility="btnText_welcome_screen_continue")
        public MobileElement textContinueBtn;

        @AndroidFindBy(accessibility="text_agree_and_Continue")
        public MobileElement textBelowAgreeContinue;
        @AndroidFindBy(accessibility="txt_version")
        public MobileElement textVersion;

}
