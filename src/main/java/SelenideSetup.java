import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;

public class SelenideSetup {
    @BeforeClass
    public static void setup() {
        Configuration.browser = Browsers.CHROME;
        Configuration.startMaximized = true;
        Configuration.pageLoadTimeout = 10000;
    }
}
