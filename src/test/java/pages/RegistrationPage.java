package pages;

import com.codeborne.selenide.SelenideElement;
import components.CalendarComponent;
import components.UserTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameUnput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            userSubjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            userAddressInput = $("#currentAddress"),
            userStateSelect = $("#state"),
            userCitySelect = $("#city"),
            submitButton = $("#submit");

    private SelenideElement CalendarInput = $("#dateOfBirthInput");

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage removeBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameUnput.setValue(value);

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserBirthday(String day, String month, String year) {
        CalendarInput.click();
        CalendarComponent.setDay(day, month, year);

        return this;
    }

    public RegistrationPage setUserSubjects(String value) {
        userSubjectInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setUserHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadUserPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setUserAddress(String value) {
        userAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserState(String value) {
        userStateSelect.click();
        userStateSelect.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserCity(String value) {
        userCitySelect.click();
        userCitySelect.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submitRegistrationForm() {
        submitButton.click();

        return this;
    }

    public RegistrationPage checkUserData(String key, String value) {
        UserTableComponent.checkResult(key, value);

        return this;
    }

    public RegistrationPage checkTableExist() {
        UserTableComponent.checkExist();

        return this;
    }
}
