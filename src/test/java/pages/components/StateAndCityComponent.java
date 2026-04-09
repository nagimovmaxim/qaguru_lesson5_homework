package pages.components;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCityComponent {
    private final SelenideElement stateInput = $(byId("react-select-3-input"));
    private final SelenideElement cityInput = $(byId("react-select-4-input"));

    public void set(String state, String city) {
        stateInput.setValue(state).sendKeys(Keys.ENTER);
        cityInput.setValue(city).sendKeys(Keys.ENTER);
    }
}
