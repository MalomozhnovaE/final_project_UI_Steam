package com.steam.tests.cart;

import com.steam.pages.CartPage;
import com.steam.pages.GamePage;
import com.steam.pages.MainPage;
import com.steam.tests.TestBase;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AddDeleteGameTest extends TestBase {

    MainPage mainPage = new MainPage();
    GamePage gamePage = new GamePage();
    CartPage cartPage = new CartPage();

    String gameName = "Syberia 3";

    @Test
    @Owner("MalomozhnovaE")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    @DisplayName("Добавление игры в корзину")
    void addGameToCartTest() {

        step("Открыть главную страницу в Steam", () -> {
            mainPage.openMainPage();
        });
        step("Ввести название игры в поле поиска", () -> {
            mainPage.searchInput(gameName);
        });
        step("Кликнуть по названию игры " + gameName, () -> {
            gamePage.clickOnGame(gameName);
        });
        step("Кликнуть по кнопке В корзину ", () -> {
            gamePage.addToCart();
        });
        step("Проверить, что игра " + gameName + " была добавлена в корзину", () -> {
            cartPage.checkGameInCart(gameName);
        });
    }

    @Test
    @Owner("MalomozhnovaE")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    @DisplayName("Удаление игры из корзины")
    void deleteFromCartTest() {
        step("Открыть главную страницу в Steam", () -> {
            mainPage.openMainPage();
        });
        step("Ввести название игры в поле поиска", () -> {
            mainPage.searchInput(gameName);
        });
        step("Кликнуть по названию игры " + gameName, () -> {
            gamePage.clickOnGame(gameName);
        });
        step("Кликнуть по кнопке В корзину", () -> {
            gamePage.addToCart();
        });
        step("Проверить, что игра " + gameName + " была добавлена в корзину", () -> {
            cartPage.checkGameInCart(gameName);
        });
        step("Кликнуть на Удалить", () -> {
            cartPage.deleteGameFromCart();
        });
        step("Проверить, что игра удалена", () -> {
            cartPage.checkDeletedGameMessage();
        });
    }
}


