package com.example.demo;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class operationsNumber {
    private HashMap <String,Integer> conformityNumbers = new HashMap<String,Integer>(); {
        conformityNumbers.put("0",0);
        conformityNumbers.put("1",1);
        conformityNumbers.put("2",2);
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
    public void CheckNumber (HashMap <String,String> Map) {
        ArrayList<String> listStringSystemNumbers = getSystemNumbers(Map);
        for (int i = 0; i < Map.get("numbers").length(); i++) {
            if (! listStringSystemNumbers.contains(Map.get("numbers").replace(" ","").toUpperCase(Locale.ROOT).substring(i,i+1))) {
                Alert Message = new Alert(Alert.AlertType.INFORMATION);
                Message.setHeaderText("Вводите символы только " + Map.get("ToSystem").substring(0,Map.get("ToSystem").length() - 2) + "ой" + " системы!");
                Message.show();
                break;
            }
        }

    }

    public ArrayList<String> getSystemNumbers (HashMap <String,String> Map) {
        String [] arrayStringSystemNumbers = new String[] {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
        HashMap <String,Integer> numbersSystem = new HashMap<String,Integer>();
        numbersSystem.put("Двоичная",1);
        numbersSystem.put("Восьмеричная",7);
        numbersSystem.put("Десятичная",9);
        numbersSystem.put("Шестнадцатеричная",15);
        ArrayList <String> listStringSystemNumbers = new ArrayList<String>();

        for (int i = 0; i <= numbersSystem.get(Map.get("ToSystem")); i++) {
            listStringSystemNumbers.add(arrayStringSystemNumbers[i]);
        }

        return listStringSystemNumbers;
    }

    public String conversionToDec () {
        return "";
    }

    public String conversionToEndSystem () {
        return "";
    }
}
