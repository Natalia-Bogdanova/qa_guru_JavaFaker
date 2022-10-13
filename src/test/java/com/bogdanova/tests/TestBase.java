package com.bogdanova.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
      String firstName = "Vadim",
            lastName = "Pirogkov",
            email = "Pirogkov@gmail.com",
            phone = "9051112233",
            day = "16",
            month = "June",
            year = "1951";

    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
}
