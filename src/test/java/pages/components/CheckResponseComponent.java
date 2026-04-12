package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;

public class CheckResponseComponent {

    public static void checkResponseOnCorrectData(SelenideElement selenideElement, String... params) {
        Arrays.stream(params).forEach(x -> selenideElement.shouldHave(text(x)));
    }
}
