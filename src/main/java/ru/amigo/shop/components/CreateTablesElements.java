package ru.amigo.shop.components;

import com.codeborne.selenide.SelenideElement;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.amigo.shop.Data;

import java.io.FileInputStream;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CreateTablesElements extends Data {

    SelenideElement addElement = $(".adm-toolbar-panel-align-right").find(byText("Добавить элемент"));
    SelenideElement elementName = $("input[name=NAME]");
    SelenideElement saveButton = $("input[value=Сохранить]");

    public void createTablesElements(Integer numberOfRows, Integer numberOfCellWithValue) throws Exception {

        for (int i = 0; i < numberOfRows; i++) {
            try (FileInputStream file = new FileInputStream(filePath)) {
                XSSFWorkbook table = new XSSFWorkbook(file);
                addElement.click();
                double sourceName = table.getSheetAt(0).getRow(i).getCell(0).getNumericCellValue();
                String name = String.valueOf(sourceName);
                String nameLastSymbol = String.valueOf(name.charAt(name.length() - 1));
                if (nameLastSymbol.equals("0")) {
                    elementName.setValue(String.valueOf(name.charAt(0)));
                } else {
                    elementName.setValue(name.replace(".", ","));
                }

                int j = 0;
                while (j < numberOfCellWithValue) {
                    double sourceValue = table.getSheetAt(0).getRow(i).getCell(j + 1).getNumericCellValue();
                    String value = String.valueOf(sourceValue);
                    $("input[name=\"PROP[" + (numberOfProp + j) + "][n0]\"]").setValue((value.replace(".", ",")));
                    j++;
                }
                saveButton.click();
            }
        }
    }
}