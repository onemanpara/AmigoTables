package ru.amigo.shop;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Scanner;

public class Data {

    protected static String login;
    protected static String password;
    protected static String url_iblockElement;
    protected static Integer numberOfProp;
    protected static Integer numberOfRows;
    protected static Integer numberOfCellWithValue;
    protected static String filePath = "src/main/resources/table.xlsx";

    Scanner scanner = new Scanner(System.in);

    public void setLogin() {
        System.out.println("Введите логин: ");
        login = scanner.nextLine();
    }

    public void setPassword() {
        System.out.println("Введите пароль: ");
        password = scanner.nextLine();
    }

    public void setUrl_iblockElement() {
        System.out.println("Введите урл раздела, в котором нужно создать элементы: ");
        url_iblockElement = scanner.nextLine();
    }


    public void setNumberOfProp() {
        System.out.println("Введите числовое значение атрибута, находящееся в input[name=PROP[?]n[0]]: ");
        numberOfProp = scanner.nextInt();
    }

    public void setNumberOfRows() throws Exception {
        try (FileInputStream file = new FileInputStream(filePath)) {
            XSSFWorkbook table = new XSSFWorkbook(file);
            numberOfRows = (table.getSheetAt(0).getLastRowNum()) + 1;
        }
    }

    public void setNumberOfCellWithValue() throws Exception {
        try (FileInputStream file = new FileInputStream(filePath)) {
            XSSFWorkbook table = new XSSFWorkbook(file);
            numberOfCellWithValue = (table.getSheetAt(0).getRow(0).getLastCellNum()) - 1;
        }
    }

}