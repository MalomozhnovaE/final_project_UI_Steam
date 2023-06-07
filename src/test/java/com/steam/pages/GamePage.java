package com.steam.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GamePage {

    private final SelenideElement game = $(".responsive_search_name_combined"),
            addToCartBtn = $(".btn_addtocart");

    public GamePage clickOnGame(String gameName) {
        game.find(byText(gameName)).click();
        return this;
    }

    public GamePage addToCart() {
        addToCartBtn.click();
        return this;
    }
}
