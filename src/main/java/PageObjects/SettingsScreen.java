package PageObjects;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsScreen {
    public SettingsScreen(AndroidDriver<AndroidElement> driver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    public String strLangBtnCommon = "btnText_Select_select_language_";
    @AndroidFindBy(accessibility="title_nav_bar_select_language")
    public MobileElement titleText_Settings;
    @AndroidFindBy(accessibility="navBarLeftButton_nav_bar_select_language")
    public MobileElement btnNavBack;

    @AndroidFindBy(accessibility="please_sel_language")
    public MobileElement titleAboveLangList;

    @AndroidFindBy(accessibility="language_list_flat_list")
    public MobileElement list_Languages;

    @AndroidFindBy(accessibility="btnText_Select_select_language_en")
    public MobileElement btnSelectEnglish;
    @AndroidFindBy(accessibility="title_select_language_en")
    public MobileElement textEnglish;

    @AndroidFindBy(accessibility="btnText_Select_select_language_hi")
    public MobileElement btnSelectHindi;
    @AndroidFindBy(accessibility="title_select_language_hi")
    public MobileElement textHindi;
    @AndroidFindBy(accessibility="subTitle_select_language_hi")
    public MobileElement subtextHindi_English;

    @AndroidFindBy(accessibility="btnText_Select_select_language_ta")
    public MobileElement btnSelectTamil;
    @AndroidFindBy(accessibility="title_select_language_ta")
    public MobileElement textTamil;
    @AndroidFindBy(accessibility="subTitle_select_language_ta")
    public MobileElement subtextTamil_English;


}
