import org.testng.annotations.DataProvider;


public class TestData {
    @DataProvider(name="Languages")
    public Object[][] chooseLanguage(){
        return new Object[][] {{"English"}, {"Hindi"}, {"Tamil"}};
    }
}
