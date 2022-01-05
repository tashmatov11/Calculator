package com.company;

import java.util.*;

public class Main {
    static Scanner console = new Scanner(System.in);
    static int numeric1, numeric2;
    static char operation;
    static int otvet;

    public static void main(String[] args) {
        System.out.println("Введите цифры (арабские или римские) в виде 1+2: ");
        String userInput = console.nextLine();
        char[] underchar = new char[10];
        for (int i = 0; i < userInput.length(); i++) {
            underchar[i] = userInput.charAt(i);
            if (underchar[i] == '+') {
                operation = '+';
            } else if (underchar[i] == '-') {
                operation = '-';
            } else if (underchar[i] == '*') {
                operation = '*';
            } else if (underchar[i] == '/') {
                operation = '/';
            }
        }
        try{

        }catch (NumberFormatException e) {
            System.out.println(" ");
        }

        String undercharString = String.valueOf(underchar);
        String[] blacks = undercharString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();

        numeric1 = romanToNumber(stable00);
        numeric2 = romanToNumber(string03);
        if (numeric1 < 0 && numeric2 < 0) {

            otvet = 0;

        } else {
            otvet = calculated(numeric1, numeric2, operation);
            System.out.println("Ответ:");
            String resultRoman = convertNumToRoman(otvet);
            System.out.println(stable00 + " " + operation + " " + string03 + " = " + resultRoman);
        }
        try {
            numeric1 = Integer.parseInt(stable00);
            numeric2 = Integer.parseInt(string03);
        }catch (NumberFormatException e){
            System.out.println(" ");
        }

        otvet = calculated(numeric1, numeric2, operation);
        System.out.println("Ответ: ");
        System.out.println(numeric1 + " " + operation + " " + numeric2 + " = " + otvet);
    }
    static String convertNumToRoman ( int numRim){
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
                "XII", "XIII", "XIV", "XV", "XVI", "XVII"};
        final String s = roman[numRim];
        return s;
    }


    static int romanToNumber (String roman){

        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        }
        return -1;
    }
    public static int calculated ( int num1, int num2, char op){
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Error!!!");
        }

        return result;
    }
}