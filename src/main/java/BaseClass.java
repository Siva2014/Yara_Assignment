//Java packages
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

//Appium and Selenium Packages
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

//Other Maven Packages
import org.apache.commons.io.FileUtils;
import org.testng.Reporter;

public class BaseClass {

    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement>  driver;
    private AppiumServiceBuilder builder;

    public AppiumDriverLocalService startServer(String port)
    {
        if(port == "" || port == null)
            port = "4723";

        boolean flag=	checkIfServerIsRunnning(port);
        if(!flag)
        {
            //Build the Appium service
            builder = new AppiumServiceBuilder();
            //For getting server logs in case needed
            class arg implements ServerArgument{
                @Override
                public String getArgument() {
                    return "--allow-insecure";
                }
            }
            builder.withArgument(new arg(), "get_server_logs");
            builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            builder.withArgument(GeneralServerFlag.LOG_LEVEL,"info");

            //Start the server with the builder
            service = AppiumDriverLocalService.buildService(builder);
            service.start();
        }
        return service;

    }

    public static boolean checkIfServerIsRunnning(String port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(Integer.parseInt(port));

            serverSocket.close();
        } catch (IOException e) {
            //If port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static void startEmulator() throws IOException, InterruptedException
    {
        ProcessBuilder pBuild = new ProcessBuilder();
        pBuild.command(Constants.startAndroidEmulatorCommandList());
        Process p = pBuild.start();
        Thread.sleep(Constants.APPLOADING_WAIT);
    }

    public static Properties getGlobalProperties() {
        try{
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/global.properties");
            Properties prop = new Properties();
            prop.load(fis);
            return prop;
        }catch(IOException ex){
            Reporter.log(messageString("Global properties file not found: " + ex.getMessage()));
            return null;
        }
    }

    public static AndroidDriver<AndroidElement> setDriverWithCapabilities(String appName, String port)
    {

        try {
            Properties prop = getGlobalProperties();
            File appDir = new File("src");
            File app = new File(appDir, (String) prop.get(appName));
            DesiredCapabilities capabilities = new DesiredCapabilities();
            String device = prop.getProperty("deviceName");
            if (device.contains("emulator")) {
                startEmulator();
            }
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, device);
            capabilities.setCapability(MobileCapabilityType.UDID, prop.getProperty("androidDeviceID"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("androidVersion"));
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            capabilities.setCapability("chromedriverExecutableDir","/usr/local/lib/node_modules/appium-chromedriver/chromedriver/mac");
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());


            //capabilities.setCapability("app-package", "com.yara.lcc.qa");
            //set the Launcher activity name of the app
            //capabilities.setCapability("app-activity", "com.yara.lcc.MainActivity");

            if(port == "" || port == null)
                port = prop.getProperty("defaultPort");
            driver = new AndroidDriver<AndroidElement>(new URL("http://"+ prop.getProperty("defaultIP") +":" + port + "/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }catch(Exception e){
            Reporter.log(messageString((e.getMessage())));
            System.out.println(e.getMessage());
        }
        return driver;
    }


    public void killAllNodes() throws IOException, InterruptedException
    {
        Runtime.getRuntime().exec("killall node");
        Thread.sleep(3000);

    }

    public static void getScreenshot(String pathToFile)
    {
        try{
            Reporter.log(messageString("taking screenshot of full screen"));
            File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrfile, new File(pathToFile + ".png"));
        }catch(Exception ex){
            Reporter.log(messageString(ex.getMessage()));
        }

    }

    public static void getElementcreenshot(String pathToFile, WebElement elem) {
        try{
            Reporter.log(messageString("taking screenshot for element"));
            File scrfile = elem.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrfile, new File(pathToFile + ".png"));
            Thread.sleep(5000);
        }catch(Exception ex){
            Reporter.log(messageString(ex.getMessage()));
        }
    }

    public static String messageString(String message){
        return LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME).toString() + "============>" + message;
    }
}


