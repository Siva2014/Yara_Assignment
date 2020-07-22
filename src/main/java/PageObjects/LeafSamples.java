package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LeafSamples {
    public LeafSamples(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility="navBarLeftButton_mockLeafColorScreen")
    public MobileElement btnClose;

    @AndroidFindBy(accessibility="title_mockLeafColorScreen")
    public MobileElement textTitleLeafColorList;
    public String imgLeafAccessIDCommonString = "img_mockLeafColorScreen_";
    @AndroidFindBy(accessibility="img_mockLeafColorScreen_0")
    public MobileElement imgLeafList1;
    @AndroidFindBy(accessibility="img_mockLeafColorScreen_1")
    public MobileElement imgLeafList2;
    @AndroidFindBy(accessibility="img_mockLeafColorScreen_2")
    public MobileElement imgLeafList3;
    @AndroidFindBy(accessibility="img_mockLeafColorScreen_3")
    public MobileElement imgLeafList4;
    @AndroidFindBy(accessibility="img_mockLeafColorScreen_4")
    public MobileElement imgLeafList5;
    @AndroidFindBy(accessibility="img_mockLeafColorScreen_5")
    public MobileElement imgLeafList6;
    @AndroidFindBy(accessibility="img_mockLeafColorScreen_6")
    public MobileElement imgLeafList7;
    @AndroidFindBy(accessibility="img_mockLeafColorScreen_7")
    public MobileElement imgLeafList8;
    @AndroidFindBy(accessibility="img_mockLeafColorScreen_8")
    public MobileElement imgLeafList9;
    @AndroidFindBy(accessibility="img_mockLeafColorScreen_9")
    public MobileElement imgLeafList10;

    @AndroidFindBy(accessibility="riceLeafColor_mockLeafColorScreen")
    public MobileElement imgBigLeaf;
    @AndroidFindBy(accessibility="txt_leafPlace_mockLeafColorScreen")
    public MobileElement textPlaceLeafHere;

    @AndroidFindBy(accessibility="circledCheck_mockLeafColorScreen_2")
    public MobileElement imgSelectLeafColorVeryLightGreen;
    @AndroidFindBy(accessibility="circledCheck_mockLeafColorScreen_3")
    public MobileElement imgSelectLeafColorNormalLightGreen;
    @AndroidFindBy(accessibility="circledCheck_mockLeafColorScreen_4")
    public MobileElement imgSelectLeafColorNormalDarkGreen;
    @AndroidFindBy(accessibility="circledCheck_mockLeafColorScreen_5")
    public MobileElement imgSelectLeafColorVeryDarkGreen;

    @AndroidFindBy(accessibility="circleCheckedImg")
    public MobileElement imgCheckedCircle;

    @AndroidFindBy(accessibility="txt_leafColor_mockLeafColorScreen")
    public MobileElement titleSelectLeafColor;

    @AndroidFindBy(accessibility="button_btnNextLeaf")
    public MobileElement btnNextLeaf;
    @AndroidFindBy(accessibility="btnText_btnNextLeaf")
    public MobileElement textNextLeaf;

    @AndroidFindBy(accessibility="button_btnDone")
    public MobileElement btnDone;
    @AndroidFindBy(accessibility="btnText_btnNextLeaf")
    public MobileElement textDone;


}
