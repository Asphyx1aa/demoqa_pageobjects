package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends BaseTest {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void successfulFillingFormTest() {
        textBoxPage.openPage()
                .removeBanner()
                .setUserName("Timur Vlasov")
                .setUserMail("test@gmail.com")
                .setUserCurrentAddress("г. Барнаул, ул. Гоголя, д. 38")
                .setUserPermamentAddress("Amsterdam, Kleine-Gartmanplantsoen 25")
                .submitForm()
                .checkResult("Name:", "Timur Vlasov")
                .checkResult("Email:", "test@gmail.com")
                .checkResult("Current Address :", "г. Барнаул, ул. Гоголя, д. 38")
                .checkResult("Permananet Address :", "Amsterdam, Kleine-Gartmanplantsoen 25");
    }
}
