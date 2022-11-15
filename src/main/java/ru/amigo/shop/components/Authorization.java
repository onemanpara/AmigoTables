package ru.amigo.shop.components;

import com.codeborne.selenide.SelenideElement;
import ru.amigo.shop.Data;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Authorization extends Data {

    SelenideElement fieldLogin = $("[name=USER_LOGIN]");
    SelenideElement fieldPassword = $("[name=USER_PASSWORD]");
    SelenideElement buttonLogIn = $("input[type=submit]");

    public void logIn(String login, String password) {

        open("https://shop.amigo.ru/bitrix/admin/#authorize");
        fieldLogin.setValue(login);
        fieldPassword.setValue(password);
        buttonLogIn.click();
    }
}