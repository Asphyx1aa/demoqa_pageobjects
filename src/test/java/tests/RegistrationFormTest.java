package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulFillingFormTest() {

        registrationPage.openPage()
                .removeBanner()
                .setName("Timur")
                .setLastName("Vlasov")
                .setUserEmail("test@email.com")
                .setUserGender("Male")
                .setUserNumber("7941643176")
                .setUserBirthday("03", "October", "1996")
                .setUserSubjects("English").setUserHobbies("Music")
                .uploadUserPicture("sample-pic.jpg")
                .setUserAddress("г. Барнаул, ул. Гоголя, д. 38")
                .setUserState("Haryana")
                .setUserCity("Karnal")
                .submitRegistrationForm()
                .checkUserData("Student Name", "Timur Vlasov")
                .checkUserData("Student Email", "test@email.com")
                .checkUserData("Gender", "Male")
                .checkUserData("Mobile", "7941643176")
                .checkUserData("Date of Birth", "03 October,1996")
                .checkUserData("Subjects", "English")
                .checkUserData("Hobbies", "Music")
                .checkUserData("Picture", "sample-pic.jpg")
                .checkUserData("Address", "г. Барнаул, ул. Гоголя, д. 38")
                .checkUserData("State and City", "Haryana Karnal");
    }

    @Test
    void fillFormWithNecessaryFieldsTest() {

        registrationPage.openPage()
                .setName("Timur")
                .setLastName("Vlasov")
                .setUserGender("Male")
                .setUserNumber("7941643176")
                .submitRegistrationForm()
                .checkUserData("Student Name", "Timur Vlasov")
                .checkUserData("Gender", "Male")
                .checkUserData("Mobile", "7941643176");

    }

    @Test
    void fillFormWithoutNecessaryFieldsTest() {

        registrationPage.openPage()
                .setUserEmail("test@email.com")
                .setUserBirthday("03", "October", "1996")
                .setUserSubjects("English").setUserHobbies("Music")
                .uploadUserPicture("sample-pic.jpg")
                .setUserAddress("г. Барнаул, ул. Гоголя, д. 38")
                .setUserState("Haryana")
                .setUserCity("Karnal")
                .submitRegistrationForm()
                .checkTableExist();
    }
    
}
