package com.bogdanova.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AddressComponent {

    private SelenideElement
            address = $("#currentAddress"),
            stateField = $("#state"),
            cityField = $("#city");

    public AddressComponent setAddr(String currentAddress, String state, String city) {
        address.setValue(currentAddress);
        stateField.click();
        $(byText(state)).click();
        cityField.click();
        $(byText(city)).click();
        return this;
    }
}
