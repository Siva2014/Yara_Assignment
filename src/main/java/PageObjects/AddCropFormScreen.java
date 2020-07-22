package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddCropFormScreen {

    AndroidDriver<AndroidElement> driver;

    public AddCropFormScreen(AndroidDriver<AndroidElement> driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility="navBarLeftButton_nbNavBar")
    public MobileElement btnNavBack;
    @AndroidFindBy(accessibility="title_nbNavBar")
    public MobileElement textTitle;
    @AndroidFindBy(accessibility="subtitle_nbNavBar")
    public MobileElement textSubTitle;
    @AndroidFindBy(accessibility="roundedButton_nbNavBar")
    public MobileElement btnSave;
    @AndroidFindBy(accessibility="roundedButtonText_nbNavBar")
    public MobileElement textSave;

    @AndroidFindBy(xpath="//android.view.ViewGroup[@content-desc=\"textInput_txtFarmName\"]/android.view.ViewGroup[1]/android.widget.TextView\n")
    public MobileElement textPlaceHolderForFormName;
    @AndroidFindBy(xpath="//android.widget.EditText[@content-desc=\"textInput_txtFarmName\"]")
    public MobileElement editTextFarmName;
    @AndroidFindBy(accessibility="subText_txtFarmName")
    public MobileElement textBelowFormName;

    @AndroidFindBy(accessibility="txtTitleList_rblRiceVarieties")
    public MobileElement textRiceVarieties;
    public MobileElement viewGroupRiceVarieties() { return driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"roundedButton_rblRiceVarieties\"]"); }
    public MobileElement textGroupRiceVarieties() { return driver.findElementByXPath("//android.widget.TextView[@content-desc=\"roundedButtonText_rblRiceVarieties\"]"); }

    public MobileElement btnNonBasmaticRiceVariety() { return driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"roundedButton_rblRiceVarieties\"])[1]"); }
    public MobileElement btnBasmaticRiceVariety() { return driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"roundedButton_rblRiceVarieties\"])[2]"); }
    public MobileElement btnBoroRiceVariety() { return driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"roundedButton_rblRiceVarieties\"])[3]"); }
    public MobileElement btnDirectSeededRiceVariety() { return driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"roundedButton_rblRiceVarieties\"])[4]"); }

    public MobileElement textNonBasmaticRiceVariety() { return driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"roundedButtonText_rblRiceVarieties\"])[1]"); }
    public MobileElement textBasmaticRiceVariety() { return driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"roundedButtonText_rblRiceVarieties\"])[2]"); }
    public MobileElement textBoroRiceVariety() { return driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"roundedButtonText_rblRiceVarieties\"])[3]"); }
    public MobileElement textDirectSeededRiceVariety() { return driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"roundedButtonText_rblRiceVarieties\"])[4]"); }


    @AndroidFindBy(accessibility="txtSowingDateTitle_dtSowingdate")
    public MobileElement textTitleSowingDate;
    @AndroidFindBy(accessibility="txtDisplayDate_dtSowingdate")
    public MobileElement textSowingDate;
    @AndroidFindBy(accessibility="img_dtSowingdate")
    public MobileElement imgSowingDate;

    @AndroidFindBy(accessibility="sowingDate_dtSowingdate")
    public MobileElement textTitleCalendarPopup;
    @AndroidFindBy(accessibility="dateTitle_dtSowingdate")
    public MobileElement textDateCalendarPopup;
    @AndroidFindBy(accessibility="textCancel_dtSowingdate")
    public MobileElement textCancelCalendarPopup;
    @AndroidFindBy(accessibility="textSave_dtSowingdate")
    public MobileElement textSaveCalendarPopup;

    public MobileElement leftArrowMonthCalendarPopup() { return driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"calendarArrowImg_dtSowingdate\"])[1]"); }
    public MobileElement rightArrowMonthCalendarPopup() { return driver.findElementByXPath("(//android.widget.ImageView[@content-desc=\"calendarArrowImg_dtSowingdate\"])[2]"); }

    public MobileElement textDisplayedMonthYearCalendarPopup() { return driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"calendarComp_dtSowingdate\"]/android.view.ViewGroup/android.widget.TextView[1]"); }
    public MobileElement textMondayCalendarPopup() { return driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"calendarComp_dtSowingdate\"]/android.view.ViewGroup/android.widget.TextView[2]"); }
    public MobileElement textTuesdayCalendarPopup() { return driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"calendarComp_dtSowingdate\"]/android.view.ViewGroup/android.widget.TextView[3]"); }
    public MobileElement textWednesdayCalendarPopup() { return driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"calendarComp_dtSowingdate\"]/android.view.ViewGroup/android.widget.TextView[4]"); }
    public MobileElement textThursdayCalendarPopup() { return driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"calendarComp_dtSowingdate\"]/android.view.ViewGroup/android.widget.TextView[5]"); }
    public MobileElement textFridayCalendarPopup() { return driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"calendarComp_dtSowingdate\"]/android.view.ViewGroup/android.widget.TextView[6]"); }
    public MobileElement textSaterdayCalendarPopup() { return driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"calendarComp_dtSowingdate\"]/android.view.ViewGroup/android.widget.TextView[7]"); }
    public MobileElement textSundayCalendarPopup() { return driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"calendarComp_dtSowingdate\"]/android.view.ViewGroup/android.widget.TextView[8]"); }

    public MobileElement textSundayCalendarPopup(String dateString) { return driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"calendarComp_dtSowingdate\"]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[" + dateString + "]/android.widget.TextView"); }


    @AndroidFindBy(accessibility="txtTitleList_rblGrowingPeriods")
    public MobileElement textGrowingPeriod;

    public MobileElement btnLongGrowingPeriod() { return driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"roundedButton_rblGrowingPeriods\"])[1]"); }
    public MobileElement btnMediumGrowingPeriod() { return driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"roundedButton_rblGrowingPeriods\"])[2]"); }
    public MobileElement btnShortGrowingPeriod() { return driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"roundedButton_rblGrowingPeriods\"])[3]"); }

    public MobileElement textLongGrowingPeriod() { return driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"roundedButtonText_rblGrowingPeriods\"])[1]"); }
    public MobileElement textMediumGrowingPeriod() { return driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"roundedButtonText_rblGrowingPeriods\"])[2]"); }
    public MobileElement textShortGrowingPeriod() { return driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"roundedButtonText_rblGrowingPeriods\"])[3]"); }

    @AndroidFindBy(accessibility="txtTitleList_rblFarmSizes")
    public MobileElement textFarmSize;

    public MobileElement btnOneAcreFarmSize() { return driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"roundedButton_rblFarmSizes\"])[1]"); }
    public MobileElement btnFiveAcresFarmSize() { return driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"roundedButton_rblFarmSizes\"])[1]"); }
    public MobileElement btnMoreThanFiveAcresFarmSize() { return driver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"roundedButton_rblFarmSizes\"])[1]"); }


    public MobileElement textOneAcreFarmSize() { return driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"roundedButtonText_rblFarmSizes\"])[1]"); }
    public MobileElement textFiveAcresFarmSize() { return driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"roundedButtonText_rblFarmSizes\"])[1]"); }
    public MobileElement textMoreThanFiveAcresFarmSize() { return driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"roundedButtonText_rblFarmSizes\"])[1]"); }




}
