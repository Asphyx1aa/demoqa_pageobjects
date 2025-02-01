package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class TextBoxPage {
    private final SelenideElement userNameInput = $("#userName"),
            userMailInput = $("#userEmail"),
            userCurrentAddressInput = $("#currentAddress"),
            userPermamentAddressInput = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputWrapper = $("#output");


    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    public TextBoxPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public TextBoxPage setUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserMail(String value) {
        userMailInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserCurrentAddress(String value) {
        userCurrentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage setUserPermamentAddress(String value) {
        userPermamentAddressInput.setValue(value);

        return this;
    }

    public TextBoxPage submitForm() {
        submitButton.click();

        return this;
    }

    public TextBoxPage checkResult(String key, String value) {
        outputWrapper.$(byText(key)).parent().shouldHave(text(value));

        return this;
    }
}
