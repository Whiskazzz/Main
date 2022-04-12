package com.daniil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator{

    static String a;
    static String b;
    static String operation;


    public static void main(String[] args) throws IncorrectInputException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String inline = bufferedReader.readLine();
            setParam(inline);
        } catch (IOException e) {
            e.printStackTrace();
        }


        switch (operation) {
            case "-" -> {
                if (RomanNum.isRoman(a) && RomanNum.isRoman(b)) {
                    System.out.println(new RomanNum(a).minus(new RomanNum(b)).number);
                } else if (ArabicNum.isArabic(a) && ArabicNum.isArabic(b)) {
                    System.out.println((int) new ArabicNum(a).minus(new ArabicNum(b)).number);
                } else throw new IncorrectInputException("IncorectInput");

            }
            case "+" -> {
                if (RomanNum.isRoman(a) && RomanNum.isRoman(b)) {
                    System.out.println(new RomanNum(a).plus(new RomanNum(b)).number);
                } else if (ArabicNum.isArabic(a) && ArabicNum.isArabic(b)) {
                    System.out.println((int) new ArabicNum(a).plus(new ArabicNum(b)).number);
                } else throw new IncorrectInputException("IncorectInput");
            }
            case "/" -> {
                if (RomanNum.isRoman(a) && RomanNum.isRoman(b)) {
                    System.out.println(new RomanNum(a).divide(new RomanNum(b)).number);
                } else if (ArabicNum.isArabic(a) && ArabicNum.isArabic(b)) {
                    double d = new ArabicNum(a).divide(new ArabicNum(b)).number;
                    if (d % 1 == 0) System.out.println((int) d);
                    else System.out.println(d);
                } else throw new IncorrectInputException("IncorectInput");

            }
            case "*" -> {
                if (RomanNum.isRoman(a) && RomanNum.isRoman(b)) {
                    System.out.println(new RomanNum(a).multiply(new RomanNum(b)).number);
                } else if (ArabicNum.isArabic(a) && ArabicNum.isArabic(b)) {
                    System.out.println((int) new ArabicNum(a).multiply(new ArabicNum(b)).number);
                } else throw new IncorrectInputException("IncorectInput");
            }
        }


    }

    public static void setParam(String s) throws IncorrectInputException {

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
