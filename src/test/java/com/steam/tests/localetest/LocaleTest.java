package com.steam.tests.localetest;

import com.steam.pages.MainPage;
import com.steam.tests.TestBase;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static io.qameta.allure.Allure.step;

public class LocaleTest extends TestBase {
    MainPage mainPage = new MainPage();

    static Stream<Arguments> mainPageButtons() {
        return Stream.of(
                Arguments.of(Locale.EN, List.of("STORE", "COMMUNITY", "ABOUT", "SUPPORT")),
                Arguments.of(Locale.RU, List.of("МАГАЗИН", "СООБЩЕСТВО", "О STEAM", "ПОДДЕРЖКА"))
        );
    }

    @Test
    @Owner("MalomozhnovaE")
    @Tags({
            @Tag("BLOCKER"),
            @Tag("WEB")
    })
    @MethodSource()
    @ParameterizedTest(name = "Для локали {0} на сайте https://store.steampowered.com/ должен отображаться список кнопок {1}")
    void mainPageButtons(
            Locale locale,
            List<String> buttons
    ) {
        step("В правом вернем углу нажать на кнопку смены языка", () ->
                mainPage.languageButton());
        step("В выпадающем списке выбрать" + locale, () ->
                mainPage.choiceLanguage(locale));
        step("Проверить язык отображения кнопок: " + buttons, () ->
                mainPage.checkButtons(buttons));

    }
}
