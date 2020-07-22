import PageObjects.LeafSamples;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class TestHelperFunctions {

    AndroidDriver<AndroidElement> driver;
    WebDriverWait wait;
    FrameworkHelperFunctions lib;

    public TestHelperFunctions(AndroidDriver<AndroidElement> driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Constants.LONG_WAIT);
        this.lib = new FrameworkHelperFunctions(driver);
    }

    public leafColor chooseLeafColorRandomly(){
        switch(new Random().nextInt(4)){
            case 0: { return leafColor.VeryLightGreen; }
            case 1: { return leafColor.NormalLightGreen; }
            case 2: { return leafColor.NormalDarkGreen; }
            default: { return leafColor.VeryDarkGreen; }
        }
    }

    public WebElement getLeafColorElement(leafColor color, LeafSamples leafs){
        switch (color) {
            case VeryLightGreen: { return leafs.imgSelectLeafColorVeryLightGreen; }
            case NormalLightGreen: { return leafs.imgSelectLeafColorNormalLightGreen; }
            case NormalDarkGreen: { return leafs.imgSelectLeafColorNormalDarkGreen; }
            case VeryDarkGreen: { return leafs.imgSelectLeafColorVeryDarkGreen; }
            default: { return null; }
        }
    }

    public String getSmallLeafReferenceImageForColor(leafColor color) {
        switch (color) {
            case VeryLightGreen: { return Constants.REFIMAGES_DIR + "SmallLeaf_Sampled_VeryLightGreen.png"; }
            case NormalLightGreen: { return Constants.REFIMAGES_DIR + "SmallLeaf_Sampled_NormalLightGreen.png"; }
            case NormalDarkGreen: { return Constants.REFIMAGES_DIR + "SmallLeaf_Sampled_NormalDarkGreen.png"; }
            case VeryDarkGreen: { return Constants.REFIMAGES_DIR + "SmallLeaf_Sampled_VeryDarkGreen.png"; }
            case ToBeSampled:{ return Constants.REFIMAGES_DIR + "SmallLeaf_ToBeSampled.png"; }
            default: { return ""; }
        }
    }

    public void verifySmallLeafImageColor(leafColor color, WebElement smlLeafImg, int leafNum){

        FrameworkHelperFunctions lib = new FrameworkHelperFunctions(this.driver);
        String refImgPath = getSmallLeafReferenceImageForColor(color);
        String testImgPath = Constants.SCREENSHOTS_DIR+"smallLeafImg_"+leafNum+"_"+color.toString();
        BaseClass.getElementcreenshot(testImgPath, smlLeafImg);
        boolean result = lib.compareImages(refImgPath, testImgPath+".png");
        //SoftAssert soft = new SoftAssert();
        Assert.assertTrue(result);
    }

    public void verifyCheckedCirclePresence(WebElement leafColorElement, WebElement checkedCircle){
        try{

            //Verify that the circle checked image is displayed
            Assert.assertTrue(checkedCircle.isDisplayed());

            //Verify that checked circle image bounds are within the bounds of selected leaf color element
            org.openqa.selenium.Rectangle colorRect = leafColorElement.getRect();
            org.openqa.selenium.Rectangle circleRect = checkedCircle.getRect();
            Assert.assertTrue((circleRect.getX() > colorRect.getX()));
            Assert.assertTrue((circleRect.getY() > colorRect.getX()));
            Assert.assertTrue((circleRect.getWidth() < colorRect.getWidth()));
            Assert.assertTrue((circleRect.getHeight() < colorRect.getHeight()));
        }
        catch(Exception ex){
            if(leafColorElement == null)
                Assert.assertTrue(true); //Since checked circle should not be displayed when no color is selected yet
            else
                Reporter.log(BaseClass.messageString(ex.getMessage()), true);
        }
    }

    public void verifyLeafSelection(leafColor color, int leafNum, LeafSamples leafs) {

        verifyCheckedCirclePresence(getLeafColorElement(color, leafs), leafs.imgCheckedCircle);
        verifySmallLeafImageColor(color, driver.findElementByAccessibilityId(leafs.imgLeafAccessIDCommonString+leafNum), leafNum);
    }

    public void selectLeafColorAndVerify(int leafNum, LeafSamples leafs){
        verifyLeafSelection(leafColor.ToBeSampled, leafNum, leafs); //Verify to be sampled state for small leaf image
        leafColor color = chooseLeafColorRandomly();
        getLeafColorElement(color, leafs).click();
        verifyLeafSelection(color, leafNum, leafs);
    }

    public void takeSomeLeafSamplesAndVerifySelection(LeafSamples leafs, int num){
        leafColor color;
        for(int i=0; i<num; i++) {
            Reporter.log(BaseClass.messageString("Started verification of leaf selection flow for leaf " + (i+1)), true);
            selectLeafColorAndVerify(i, leafs);
            lib.waitForVisibilityAndClick(leafs.btnNextLeaf);
            Reporter.log(BaseClass.messageString("Completed verification of leaf selection flow for leaf " + (i+1)), true);
        }
        if(num==Constants.NUMBER_OF_LEAVES){
            Reporter.log(BaseClass.messageString("Started verification of leaf selection flow for leaf 10"), true);
            selectLeafColorAndVerify(9, leafs);
            Reporter.log(BaseClass.messageString("Completed verification of leaf selection flow for leaf 10"), true);
            lib.waitForVisibilityAndClick(leafs.btnDone);
        }else{
            lib.waitForVisibilityAndClick(leafs.btnClose);
        }
    }
}