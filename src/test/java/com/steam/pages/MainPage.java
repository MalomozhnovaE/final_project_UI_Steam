package com.steam.pages;

import com.codeborne.selenide.SelenideElement;
import com.steam.tests.localetest.Locale;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final SelenideElement language = $("#language_pulldown");
    private final SelenideElement languageChoice = $("#language_dropdown");
    private final SelenideElement searchInputField = $("#store_nav_search_term");

    public MainPage openMainPage() {
        open("https://store.steampowered.com/");
        return this;
    }

    public MainPage languageButton(){
        language.click();
        return this;
    }

    public MainPage choiceLanguage(Locale locale){
        languageChoice.$(byText((locale.getDesc()))).click();
        return this;
    }

    public MainPage checkButtons(List<String> buttons){
       $$(".supernav_container a").filter(visible).shouldHave(texts(buttons));
        return this;
    }

    public MainPage searchInput(String input) {
        searchInputField.setValue(input).pressEnter();
        return this;
    }

}
