package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import testData.TextBoxTestData;


public class TextBoxTests extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    TextBoxTestData textBoxTestData;

    @BeforeEach
    @Description("Параметризация тестовых данных")
    void parametrizationTestData() throws Exception {
        textBoxTestData = new TextBoxTestData();
    }

    @Test
    @Description("Негативная проверка на неправильнео заполнение почты")
    void negativeMailErrorTextBoxTest() {
        textBoxPage.openPage()
                .setUserEmail(textBoxTestData.getUserEmailIncorrect())
                .submitFormClick()
                .checkEmailOnError();
    }

    @Test
    @Description("ПОзитивная проверка заполнения всех полей")
    void successfulFullSubmitTextBoxTest() {
        textBoxPage.openPage()
                .setUserName(textBoxTestData.getName())
                .setUserEmail(textBoxTestData.getEmail())
                .setCurrentAddress(textBoxTestData.getCurrentAddress())
                .setPermanentAddress(textBoxTestData.getPermanentAddress())
                .submitFormClick()
                .checkOutputOnCorrectData(textBoxTestData.getCorrectFormData());
    }
}