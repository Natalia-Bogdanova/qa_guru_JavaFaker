package com.bogdanova.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstBaseTest extends TestBase{

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        Selenide.zoom(0.9);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$'#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(email);
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--selected").click();
        $("#subjectsInput").setValue("Maths").pressEnter();
        $("#hobbies-checkbox-2").parent().click();
        $("#uploadPicture").uploadFromClasspath("3.jpg");
        $("#currentAddress").setValue("red light, Geeta Colony");
        $(byText("Select State")).click();
        $(byText("Haryana")).click();
        $(byText("Select City")).click();
        $(byText("Panipat")).click();

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").shouldHave(text(firstName), text(lastName),
                text(email), text(day + " " + month + "," + year),
//                text("Pirogkov@gmail.com"),
                text("Male"),
                text(phone),
//                text("16 June,1951"),
                text("Maths"),
                text("Reading"),
                text("3.jpg"),
                text("red light, Geeta Colony"),
                text("Haryana Panipat"));
        $("#closeLargeModal").click();
    }
}