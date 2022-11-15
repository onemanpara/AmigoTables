package ru.amigo.shop;

import com.codeborne.selenide.Configuration;
import ru.amigo.shop.components.Authorization;
import ru.amigo.shop.components.CreateTablesElements;

import static com.codeborne.selenide.Selenide.open;

public class Main extends Data {


    public static void main(String[] args) throws Exception {

        Data data = new Data();
        Configuration.browserSize = "1920x1080";
        Authorization authorization = new Authorization();
        CreateTablesElements createTablesElements = new CreateTablesElements();

        data.setLogin();
        data.setPassword();
        data.setUrl_iblockElement();
        data.setNumberOfProp();
        data.setNumberOfRows();
        data.setNumberOfCellWithValue();
        authorization.logIn(login, password);
        open(url_iblockElement);
        createTablesElements.createTablesElements(numberOfRows, numberOfCellWithValue);
    }
}