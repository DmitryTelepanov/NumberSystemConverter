package com.example.demo;

import javafx.scene.control.Alert;

import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class operationsNumber {
    private HashMap <String,Integer> conformityNumbers = new HashMap<String,Integer>(); {
        //Соответсвия цифрам
        conformityNumbers.put("0",0);
        conformityNumbers.put("1",1);
        conformityNumbers.put("2",2);
        conformityNumbers.put("3",3);
        conformityNumbers.put("4",4);
        conformityNumbers.put("5",5);
        conformityNumbers.put("6",6);
        conformityNumbers.put("7",7);
        conformityNumbers.put("8",8);
        conformityNumbers.put("9",9);
        conformityNumbers.put("A",10);
        conformityNumbers.put("B",11);
        conformityNumbers.put("C",12);
        conformityNumbers.put("D",13);
        conformityNumbers.put("E",14);
        conformityNumbers.put("F",15);
    }
    private HashMap <Integer,String> conformityNumbersReverse = new HashMap<Integer,String>(); {
        //Соответсвия цифрам
        conformityNumbersReverse.put(0,"0");
        conformityNumbersReverse.put(1,"1");
        conformityNumbersReverse.put(2,"2");
        conformityNumbersReverse.put(3,"3");
        conformityNumbersReverse.put(4,"4");
        conformityNumbersReverse.put(5,"5");
        conformityNumbersReverse.put(6,"6");
        conformityNumbersReverse.put(7,"7");
        conformityNumbersReverse.put(8,"8");
        conformityNumbersReverse.put(9,"9");
        conformityNumbersReverse.put(10,"A");
        conformityNumbersReverse.put(11,"B");
        conformityNumbersReverse.put(12,"C");
        conformityNumbersReverse.put(13,"D");
        conformityNumbersReverse.put(14,"E");
        conformityNumbersReverse.put(15,"F");
    }
    private HashMap <String,Integer> baseNumbers = new HashMap<String,Integer>(); {
        //Основания системы счисления
        baseNumbers.put("Двоичная",2);
        baseNumbers.put("Восьмеричная",8);
        baseNumbers.put("Десятичная",10);
        baseNumbers.put("Шестнадцатеричная",16);
    }

    public void workToNumbers (HashMap <String,String> Map) {
        Alert Message = new Alert(Alert.AlertType.INFORMATION);
        if (CheckNumber(Map)) {
            if (Map.get("ToSystem").equals("Десятичная")) {
                Message.setHeaderText("Искомое число: " + conversionToEndSystem(Integer.parseInt(Map.get("numbers")), Map.get("EndSystem")));
            }
            else {
                Message.setHeaderText("Искомое число: " + conversionToEndSystem(conversionToDec(Map),Map.get("EndSystem")));
            }
            Message.show();
        }
    }

    public boolean CheckNumber (HashMap <String,String> Map) {
        ArrayList<String> listStringSystemNumbers = getSystemNumbers(Map);
        //Циклом проходимся по массиву и проверяем каждый символ на принадлежность к системе счисления
        for (int i = 0; i < Map.get("numbers").length(); i++) {
            if (! listStringSystemNumbers.contains(Map.get("numbers").replace(" ","").toUpperCase(Locale.ROOT).substring(i,i+1))) {
                Alert Message = new Alert(Alert.AlertType.INFORMATION);
                Message.setHeaderText("Вводите символы только " + Map.get("ToSystem").substring(0,Map.get("ToSystem").length() - 2) + "ой" + " системы!");
                Message.show();
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> getSystemNumbers (HashMap <String,String> Map) {
        //Собираем массив возможных цифр в переданной системе счисления для возможных проверок
        String [] arrayStringSystemNumbers = new String[] {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        HashMap <String,Integer> numbersSystem = new HashMap<String,Integer>(); {
            numbersSystem.put("Двоичная",1);
            numbersSystem.put("Восьмеричная",7);
            numbersSystem.put("Десятичная",9);
            numbersSystem.put("Шестнадцатеричная",15);
        }
        ArrayList <String> listStringSystemNumbers = new ArrayList<String>();

        for (int i = 0; i <= numbersSystem.get(Map.get("ToSystem")); i++) {
            listStringSystemNumbers.add(arrayStringSystemNumbers[i]);
        }

        return listStringSystemNumbers;
    }

    public Integer conversionToDec (HashMap <String,String> Map) {
        //Переводим переданное число в десятичную систему счисления
        Integer volume = 0;
        for (int i = 0; i < Map.get("numbers").length(); i++) {
            Integer volumeBuffer = conformityNumbers.get(new StringBuffer(Map.get("numbers").replace(" ","").toUpperCase(Locale.ROOT)).reverse().substring(i,i+1));
            volume = volume + (int)(Math.pow(baseNumbers.get(Map.get("ToSystem")), i) * volumeBuffer);
        }
        return volume;
    }

    private String conversionToEndSystem (Integer number, String EndSystem) {
        //Переводим переданное число в необходимую систему счисления
        String result = "";
        for (int i = 0; number != 0; i++) {
            result = result + (conformityNumbersReverse.get(number - (baseNumbers.get(EndSystem) * (number / baseNumbers.get(EndSystem)))));
            number = number / baseNumbers.get(EndSystem);
        }
        return String.valueOf(new StringBuffer(result).reverse());
    }
}
