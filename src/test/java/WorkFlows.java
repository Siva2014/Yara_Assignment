import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import PageObjects.*;
import org.testng.asserts.SoftAssert;


public class WorkFlows extends BaseClass{

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;

    //Declare necessary page objects
    SettingsScreen settings;
    ActivityHistoryNone activity;
    AddCropFormScreen addCrop;
    InstructionsScreen instructions;
    LeafSamples leafs;
    SamplingDoneScreen done;
    TakeSample_NoHistory ts_NH;
    TakeSample_WithHistory ts_WH;
    WelcomeScreen welcome;

    //Delcare necessary libraries framework library for automation related support
    //testLib for application related re-use
    FrameworkHelperFunctions lib;
    TestHelperFunctions testLib;

    @BeforeTest
    public void initialize() {
        try{
            killAllNodes();
            //start with default port mentioned in global properties
            service = startServer("");
            driver = setDriverWithCapabilities("appName", "");
            driver.manage().timeouts().implicitlyWait(Constants.LONG_WAIT, Constants.DEFAULT_TIMEUNIT);
            wait = new WebDriverWait(driver, Constants.LONG_WAIT);

            //Initialize page object classes
            settings = new SettingsScreen(driver);
            activity = new ActivityHistoryNone(driver);
            addCrop = new AddCropFormScreen(driver);
            instructions = new InstructionsScreen(driver);
            leafs = new LeafSamples(driver);
            done = new SamplingDoneScreen(driver);
            ts_NH = new TakeSample_NoHistory(driver);
            ts_WH = new TakeSample_WithHistory(driver);
            welcome = new WelcomeScreen(driver);

            //Initialize library classes
            lib = new FrameworkHelperFunctions(driver);
            testLib = new TestHelperFunctions(driver);

        }catch(Exception ex){
            System.out.println(ex.getMessage());
            tearDown();
        }
    }

    //This test will run with three languages and language support can be extended further without changing the test
    //This test will run al the necessary automation aspects of the given appplication
    //each property is accessed by the element name declared in the page object and each object follows naming convention
    //Language strings are maintained in seperate property files for scalability and maintainability
    //Hard coding is totally avoided. All the application specific or test specific constants made available globally
    //Environment / configuration related settings to be maintained in the global.properties file
    //Seperate suits can be created based on test priority (p0,P1,P2 ..) and can be configured in the testNG file
    @Test(dataProvider = "Languages", dataProviderClass = TestData.class)
    public void TakeNewSampleWithNoPriorActivity(String lang){
        try{
            lang = lang.toLowerCase();
            Properties prop = new Properties();
            FileInputStream file = new FileInputStream(Constants.REF_STR_LANG_ROOT_PATH+lang+"_strings.properties");
            prop.load(file);
            //Set Language and add new crop and verify some text (to check for language support)
            lib.waitForVisibilityAndClick(driver.findElementByAccessibilityId(settings.strLangBtnCommon+lang.substring(0,2)));
            lib.waitForVisibilityAndClick(welcome.btnContinue);
            lib.waitForVisibilityAndClick(ts_NH.btnAddCrop);
            wait.until(ExpectedConditions.visibilityOf(addCrop.editTextFarmName));
            Assert.assertTrue(addCrop.textPlaceHolderForFormName.getText().equals(prop.getProperty("textPlaceHolderForFormName")));

            //Enter crop details and verify some text messages (to check for language support)
            wait.until(ExpectedConditions.visibilityOf(addCrop.editTextFarmName)).sendKeys("MyFarm");
            Assert.assertTrue(addCrop.textBelowFormName.getText().equals(prop.getProperty("textBelowFormName")));
            lib.waitForVisibilityAndClick(addCrop.btnDirectSeededRiceVariety());
            Assert.assertTrue(addCrop.textDirectSeededRiceVariety().getText().equals(prop.getProperty("textDirectSeededRiceVariety")));
            lib.waitForVisibilityAndClick(addCrop.imgSowingDate);
            lib.waitForVisibilityAndClick(addCrop.textSaveCalendarPopup);
            wait.until(ExpectedConditions.visibilityOf(addCrop.imgSowingDate));
            lib.scrollToText(prop.getProperty("textMoreThanFiveAcresFarmSize")); //Scroll down
            lib.waitForVisibilityAndClick(addCrop.btnMediumGrowingPeriod());
            lib.waitForVisibilityAndClick(addCrop.btnFiveAcresFarmSize());
            lib.scrollToText(prop.getProperty("textSave"));
            lib.waitForVisibilityAndClick(addCrop.btnSave);

            //Go through instructions - text Verification here (for language support)
            lib.waitForVisibilityAndClick(instructions.btnNext);
            Assert.assertTrue(instructions.textContentStep1.getText().equals(prop.getProperty("textContentStep1")));
            lib.waitForVisibilityAndClick(instructions.btnNext);
            Assert.assertTrue(instructions.textContentStep2.getText().equals(prop.getProperty("textContentStep2")));
            lib.waitForVisibilityAndClick(instructions.btnStartSample);
            Assert.assertTrue(instructions.textContentStep3.getText().equals(prop.getProperty("textContentStep3")));

            //Take leaf samples and verify leaf selection flow - check small leaf image before selection, after selection
            // and check for the presence of circle within leaf color selection panel.
            //It may be good to have either source image name or style property available for the testers
            //In the absence of both the above, reference images are generated
            // (as a sample illustration for the small leaf image for each of the three states to be selected, unselected and selected with the right color)
            //Direct Base64 string comparison was performed for verification but generated errors, open CV based appium image score match is also checked
            testLib.takeSomeLeafSamplesAndVerifySelection(leafs, 1);

            //******Alert handling very flaky - need to check with two more ways (co-ordinate based pressing, image based recognition)
            // not working with context switching, frame switching, window switching Needs further investigation
            ////Verify alert popup
            lib.handleAlert("Yes");
            //driver.switchTo().window("android:id/content");
            driver.findElementByAccessibilityId("btnAllow_alert_cancel_getResults").click();

            //Experimented code
            //wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(done.frameForAlert));
            //lib.waitForNativeALertAndClick(done.btnYesAlert);
            //driver.switchTo().frame(driver.findElementById("android:id/content"));
            //lib.waitForVisibilityAndClick(done.btnYesAlert);
            //driver.switchTo().defaultContent();

            //Post leaf selection flow - additional checks to verify to verify crop selection is reflected properly
            lib.waitForVisibilityAndClick(activity.btnNewSample);
            lib.waitForVisibilityAndClick(ts_NH.btnAddCrop);
            lib.waitForVisibilityAndClick(ts_WH.listItem_1_SavedCrops);

        //Exception handling and screencaptures for any failure
        }catch(Exception ex){
            Reporter.log(BaseClass.messageString(ex.getMessage()), true);
            try{
                getScreenshot(Constants.SCREENSHOTS_DIR + "Error_" + getClass().getName() + "_" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString());
            }catch(Exception e){
                Reporter.log(BaseClass.messageString(e.getMessage()), true);
            }
            new SoftAssert().assertTrue(false);
        }


    }

    @AfterTest
    public void tearDown() {
        try{
            PrintWriter writer = new PrintWriter(new File(Constants.REPORTS_DIR + "/ServerLogs.txt"));
            LogEntries driverLogs = driver.manage().logs().get("server");
            for (LogEntry entry : driverLogs) {
                Reporter.log(entry.getMessage());
            }
            driver.quit();
        } catch (FileNotFoundException e) {
            Reporter.log(BaseClass.messageString(e.getMessage()), true);
        }
    }
}

