package tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

import static testData.PracticeFormTestData.*;

public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @Description("Негативная проверка на неправильное заполенние телефона")
    void negativePhoneErrorPracticeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .clickGender(gender)
                .setUserNumber(userNumberIncorrect)
                .clickSubmit()
                .checkUserNumberOnIncorrectData();
    }

    @Test
    @Description("Негативная проверка на неправильное заполнение почты")
    void negativeMailErrorPracticeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .clickGender(gender)
                .setUserNumber(userNumber)
                .setUserEmail(userEmailIncorrect)
                .clickSubmit()
                .checkUserEmailOnIncorrectData();
    }

    @Test
    @Description("Негативная проверка на незаполнение всех обязательных полей")
    void negativeShortSubmitPracticeFormTest() {
        practiceFormPage.openPage()
                .clickSubmit()
                .checkRequiredElementsOnEmptyData();
    }

    @Test
    @Description("Позитивно проверяются только обязательные поля формы")
    void positiveShortSubmitPracticeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .clickGender(gender)
                .setUserNumber(userNumber)
                .clickSubmit()
                .checkResponseTableOnAppearance()
                .checkResponseTableOnCorrectData(firstName, lastName, gender, userNumber);

    }

    @Test
    @Description("Позитивно проверяются все поля формы, а не только обязательные")
    void positiveFullSubmitPracticeFormTest() {
        practiceFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .clickGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(birthYear, birthMonth, birthDay)
                .setSubjects(subjects)
                .clickHobbies(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(address)
                .setStateAndCity(state, city)
                .clickSubmit()
                .checkResponseTableOnAppearance()
                .checkResponseTableOnCorrectData(firstName, lastName, userEmail, gender, userNumber, birthYear, birthMonth
                        , birthDay, subjects, hobbies, picture, address, state, city);
    }
}