package com.steam.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    private static final String CART_PAGE_TITLE = "ВАША КОРЗИНА";
    private static final String ADD_MESSAGE = "Ваш товар был добавлен!";
    private static final String DELETE_MESSAGE = "Ваш товар был удалён!";

    private final SelenideElement cartPageHeader = $(".pageheader"),
            statusMessage = $(".cart_status_message"),
            cartItem = $(".cart_item"),
            removeCartButton = $(".remove_link");

    public CartPage checkGameInCart(String gameName) {
        cartPageHeader.shouldHave(text(CART_PAGE_TITLE));
        statusMessage.shouldHave(text(ADD_MESSAGE));
        cartItem.shouldHave(text(gameName));
        return this;
    }

    public CartPage deleteGameFromCart() {
        removeCartButton.click();
        return this;
    }

    public CartPage checkDeletedGameMessage() {
        statusMessage.shouldHave(text(DELETE_MESSAGE));
        return this;
    }
}
