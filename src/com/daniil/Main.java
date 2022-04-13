package com.daniil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    private static String a;
    private static String b;
    private static String operation;


    public static void main(String[] args) throws IncorrectInputException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String inline = bufferedReader.readLine();
            System.out.println(calc(inline));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static String calc(String input) throws IncorrectInputException {
        setParam(input);
        String result = null;
        switch (operation) {
            case "-" -> {
                if (RomanNum.isRoman(a) && RomanNum.isRoman(b)) {
                    result = new RomanNum(a).minus(new RomanNum(b)).getNumber();
                } else if (ArabicNum.isArabic(a) && ArabicNum.isArabic(b)) {
                    result = String.valueOf(new ArabicNum(a).minus(new ArabicNum(b)).getNumber());
                } else throw new IncorrectInputException("IncorectInput");

            }
            case "+" -> {
                if (RomanNum.isRoman(a) && RomanNum.isRoman(b)) {
                    result = new RomanNum(a).plus(new RomanNum(b)).getNumber();
                } else if (ArabicNum.isArabic(a) && ArabicNum.isArabic(b)) {
                    result = String.valueOf(new ArabicNum(a).plus(new ArabicNum(b)).getNumber());
                } else throw new IncorrectInputException("IncorectInput");
            }
            case "/" -> {
                if (RomanNum.isRoman(a) && RomanNum.isRoman(b)) {
                    result = new RomanNum(a).divide(new RomanNum(b)).getNumber();
                } else if (ArabicNum.isArabic(a) && ArabicNum.isArabic(b)) {
                    result = String.valueOf(new ArabicNum(a).divide(new ArabicNum(b)).getNumber());
                } else throw new IncorrectInputException("IncorectInput");

            }
            case "*" -> {
                if (RomanNum.isRoman(a) && RomanNum.isRoman(b)) {
                    result = new RomanNum(a).multiply(new RomanNum(b)).getNumber();
                } else if (ArabicNum.isArabic(a) && ArabicNum.isArabic(b)) {
                    result = String.valueOf(new ArabicNum(a).multiply(new ArabicNum(b)).getNumber());
                } else throw new IncorrectInputException("IncorectInput");
            }
        }
        return result;
    }

    private static void setParam(String s) throws IncorrectInputException {

        if (s.length()<3 || !(s.contains("/") || s.contains("-") || s.contains("+") || s.contains("*"))) throw new IncorrectInputException("IncorectInput");

        else if (s.contains("/")){
            String[] in = s.split("/");
            if (in.length!=2) throw new IncorrectInputException("IncorectInput");
            else {
                a = in[0].trim();
                b = in[1].trim();
                operation = "/";
            }
        }
        else if (s.contains("-")){
            String[] in = s.split("-");
            if (in.length!=2) throw new IncorrectInputException("IncorectInput");
            else {
                a = in[0].trim();
                b = in[1].trim();
                operation = "-";
            }
        }
        else if (s.contains("+")){
            String[] in = s.split("\\+");
            if (in.length!=2) throw new IncorrectInputException("IncorectInput");
            else {
                a = in[0].trim();
                b = in[1].trim();
                operation = "+";
            }
        }
        else if (s.contains("*")){
            String[] in = s.split("\\*");
            if (in.length!=2) throw new IncorrectInputException("IncorectInput");
            else {
                a = in[0].trim();
                b = in[1].trim();
                operation = "*";
            }
        }
    }


}
