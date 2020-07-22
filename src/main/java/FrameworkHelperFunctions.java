import com.sun.org.apache.xerces.internal.dom.PSVIDOMImplementationImpl;
import com.sun.xml.internal.rngom.parse.host.Base;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class FrameworkHelperFunctions {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;

    public FrameworkHelperFunctions(AndroidDriver<AndroidElement> driver)
    {
        this.driver=driver;
        wait = new WebDriverWait(driver, Constants.LONG_WAIT);
    }

    public void scrollToText(String text){
        Reporter.log(BaseClass.messageString("Scrolling till the text: '" + text + "' is visible"), true);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
    }

    public void waitForVisibilityAndClick(MobileElement elem){
        try{
            Reporter.log(BaseClass.messageString("waiting and clicking  element with locator: " + elem.toString()), true);
            wait.until(ExpectedConditions.visibilityOf(elem));
            elem.click();
        }catch(Exception ex){
            Reporter.log(BaseClass.messageString(ex.getMessage()), true);
        }
    }

    public WebElement findElement(By by){
        Reporter.log(BaseClass.messageString("Identifying element with locator: " + by.toString()), true);
        return driver.findElement(by);
    }
    //yet to be completely tested for alert handling
    public void handleAlert(String btnToClick){
        //driver.context(driver.getContextHandles().toArray()[1].toString()); //Change the context
        String title = driver.getTitle();
        String[] windows = (String[]) driver.getWindowHandles().toArray();
        driver.findElementById("btnAllow_alert_cancel_getResults").click();
//        if(btnToClick.toLowerCase().equals("yes"))
//            driver.switchTo().alert().accept();
//        else
//            driver.switchTo().alert().dismiss();
        //driver.findElementById("btnAllow_alert_cancel_getResults").click(); //Click yes button
        driver.switchTo().defaultContent();
    }
//Unsuccessful experimentation with alert handling
    public void waitForNativeALertAndClick(MobileElement YesOrCancelButton){
        //driver.context(driver.getContextHandles().toArray()[1].toString());
//        driver.switchTo().defaultContent();
        //driver.getClass().
//        String webContext = driver.getContext();
//        Set<String> contexts = driver.getContextHandles();
//        Reporter.log(BaseClass.messageString("driver available contexts: "+contexts.toString()), true);
//        for (String context: contexts){
//            System.out.println(context);
//            Reporter.log(BaseClass.messageString("driver context: "+context.toString()), true);
//            //Set<String> windows = driver.getWindowHandles();
//            //System.out.println(windows);
//            //driver.switchTo
//            if (context.contains("NATIVE_APP")){
//                driver.context(context);
//                break;
//            }
//        }
//        //waitForVisibilityAndClick(YesOrCancelButton);
//        Reporter.log(BaseClass.messageString("Trying to switch to frame"), true);
//        driver.getScreenshotAs(new OutputType)
//        //driver.switchTo().frame(driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup"));
//                //0);//driver.findElementById("android:id/content"));//"android:id/content");
//        Reporter.log(BaseClass.messageString("Trying to press Yes button on alert"), true);
//        driver.findElementById("btnAllow_alert_cancel_getResults").click();
//        //YesOrCancelButton.click();
//        Reporter.log(BaseClass.messageString("Trying to revert driver to default content"), true);
//        driver.switchTo().defaultContent();
    }

    public static String convertImgToBase64(String imgPath) {
        try{
            byte[]fileContent = FileUtils.readFileToByteArray(new File(imgPath));
            return Base64.getEncoder().encodeToString(fileContent);
        }catch(Exception ex){
            Reporter.log(BaseClass.messageString(ex.getMessage()), true);
            return null;
        }
    }

    public boolean compareImages_Base64String(String refImgPath, String testImgPath){
        Reporter.log(BaseClass.messageString("Comparing Reference Image: '" + refImgPath + "' with test image: '" + testImgPath), true);
         String b64Ref = convertImgToBase64(refImgPath);
         String b64Test = convertImgToBase64(testImgPath);
         return b64Ref.equals(b64Test);
    }

    public boolean compareImages(String refImgPath, String testImgPath){
        Reporter.log(BaseClass.messageString("Comparing Reference Image: '" + refImgPath + "' with test image: '" + testImgPath), true);
        float similarity = -1.0f;
        try {
            similarity = (float) driver.getImagesSimilarity(FileUtils.readFileToByteArray(new File(refImgPath)), FileUtils.readFileToByteArray(new File(testImgPath))).getScore();
            Reporter.log(BaseClass.messageString("Similarity score of '" + similarity + "' found between the images."), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (0.0f <= similarity && similarity <= 1.0f);
    }

}