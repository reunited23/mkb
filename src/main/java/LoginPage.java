import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private String userField = "#txtLogin";
    private String passwordField = "#txtPassword";

    public void onMainPage() {
        open(Constants.MAIN_URL);
    }

    public void inputLogin(String user) {
        $(userField).setValue(user);
    }

    public void inputPassword(String password) {
        $(passwordField).setValue(password);
    }

    public void clickOnButton() {
        $("#btnLoginStandard").click();
    }

    public void login(String user, String password) {
        inputData(user, password);
        clickOnButton();
    }

    public void inputData(String user, String password) {
        inputLogin(user);
        inputPassword(password);
    }

    public String getErrorMessage() {
        return $("#errMessage").getText();
    }
}
