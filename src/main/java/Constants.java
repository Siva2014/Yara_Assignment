import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

enum language { English, Hindi, Tamil };
enum leafColor { VeryLightGreen, NormalLightGreen, NormalDarkGreen, VeryDarkGreen, ToBeSampled };

public final class Constants {

    //Test Execution Specific
    public static final String REF_STR_LANG_ROOT_PATH = System.getProperty("user.dir")+"/src/main/java/";
    public static final String REPORTS_DIR = System.getProperty("user.dir")+"/target/generated-test-sources/test_output/reports/";
    public static final String SCREENSHOTS_DIR = System.getProperty("user.dir")+"/target/generated-test-sources/test_output/screenshots/";
    public static final String REFIMAGES_DIR = System.getProperty("user.dir")+"/target/classes/ReferenceImages/";
    public static final TimeUnit DEFAULT_TIMEUNIT = TimeUnit.SECONDS;
    public static final List<String> startAndroidEmulatorCommandList(){
        List<String> cmdList = new ArrayList<String>();
        cmdList.add("cd $ANDROID_HOME/emulator");
        cmdList.add("emulator -avd emulator-5554");
        return cmdList;
    }

    //Wait times
    public static final int APPLOADING_WAIT = 60;
    public static final int LONG_WAIT = 10;
    public static final int MEDIUM_WAIT = 5;
    public static final int SHORT_WAIT = 2;

    //Application specific
    public static final int NUMBER_OF_LEAVES = 10;

}
