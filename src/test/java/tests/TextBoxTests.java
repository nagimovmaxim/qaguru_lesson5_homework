package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static testData.TextBoxTestData.*;


public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    @Description("Негативная проверка на неправильнео заполнение почты")
    void negativeMailErrorTextBoxTest() {
        textBoxPage.openPage()
                .setUserEmail(userEmailIncorrect)
                .submitFormClick()
                .checkEmailOnError();
    }

    @Test
    @Description("ПОзитивная проверка заполнения всех полей")
    void successfulFullSubmitTextBoxTest() {
        textBoxPage.openPage()
                .setUserName(name)
                .setUserEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitFormClick()
                .checkOutputOnCorrectData(name, email, currentAddress, permanentAddress);
    }
}