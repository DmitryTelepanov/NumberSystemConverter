package com.example.demo;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ToggleGroup GroupOne;

    @FXML
    private RadioButton GroupOneBin;

    @FXML
    private RadioButton GroupOneDec;

    @FXML
    private RadioButton GroupOneHex;

    @FXML
    private RadioButton GroupOneOct;

    @FXML
    private ToggleGroup GroupTwo;

    @FXML
    private RadioButton GroupTwoBin;

    @FXML
    private RadioButton GroupTwoDec;

    @FXML
    private RadioButton GroupTwoHex;

    @FXML
    private RadioButton GroupTwoOct;

    @FXML
    private Button calculateBtn;

    @FXML
    private TextArea tablo;

    @FXML
    void initialize() {
        HashMap<String,String> parameters = new HashMap<String, String>();
        operationsNumber operations = new operationsNumber();
        calculateBtn.setOnAction(actionEvent -> {
            //Событие нажатие кнокпи
            parameters.put("numbers",tablo.getText());
            //Записываем преобразуемое число в параметры
            RadioButton selectGroupOneSystem = (RadioButton) GroupOne.getSelectedToggle();
            // Получаем значение первой группы радио кнопок для определение текущий системы счисления
            if(selectGroupOneSystem!= null){
                parameters.put("ToSystem",selectGroupOneSystem.getText());
            }
            RadioButton selectGroupTwoSystem = (RadioButton) GroupTwo.getSelectedToggle();
            // Получаем значение второй группы радио кнопок для определения необходиомй системы счисления
            if(selectGroupTwoSystem != null){
                parameters.put("EndSystem",selectGroupTwoSystem.getText());
            }
            operations.workToNumbers(parameters);
        });

    }

}















