package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By userName = By.id("user-name");
    private final By password = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By productText = By.xpath("//span[@data-test='title']");

    public void enterUserName(String user){
        type(userName, user);
    }

    public void enterPassword(String pwd){
        type(password, pwd);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

    public boolean isUserLandedOnLoginPage(){
        return displayed(loginButton);
    }

    public boolean isUserLoggedIn(){
        return displayed(productText);
    }

}
