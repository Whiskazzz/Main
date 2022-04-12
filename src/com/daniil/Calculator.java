package com.daniil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator{


    public static void main(String[] args) throws IncorrectInputException {
        String inline = "";
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            inline = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (inline.contains("+")){
            String[] num = inline.split("\\+");
            if (RomanNum.isRoman(num[0]) && RomanNum.isRoman(num[1])){
                System.out.println(new RomanNum(num[0]).plus(new RomanNum(num[1])).number);
            }

            else if (ArabicNum.isArabic(num[0]) && ArabicNum.isArabic(num[0])){
                System.out.println(new ArabicNum(num[0]).plus(new ArabicNum(num[1])).number);
            }
            else throw new IncorrectInputException("IncorectInput");
        }
        else if (inline.contains("-")){
            String[] num = inline.split("-");

            if (RomanNum.isRoman(num[0]) && RomanNum.isRoman(num[1])){
                System.out.println(new RomanNum(num[0]).minus(new RomanNum(num[1])).number);
            }

            else if (ArabicNum.isArabic(num[0]) && ArabicNum.isArabic(num[0])){
                System.out.println(new ArabicNum(num[0]).minus(new ArabicNum(num[1])).number);
            }
            else throw new IncorrectInputException("IncorectInput");

        }
        else if (inline.contains("*")){
            String[] num = inline.split("\\*");

            if (RomanNum.isRoman(num[0]) && RomanNum.isRoman(num[1])){
                System.out.println(new RomanNum(num[0]).multiply(new RomanNum(num[1])).number);
            }

            else if (ArabicNum.isArabic(num[0]) && ArabicNum.isArabic(num[0])){
                System.out.println(new ArabicNum(num[0]).multiply(new ArabicNum(num[1])).number);
            }
            else throw new IncorrectInputException("IncorectInput");


        }
        else if (inline.contains("/")){
            String[] num = inline.split("/");

            if (RomanNum.isRoman(num[0]) && RomanNum.isRoman(num[1])){
                System.out.println(new RomanNum(num[0]).divide(new RomanNum(num[1])).number);
            }

            else if (ArabicNum.isArabic(num[0]) && ArabicNum.isArabic(num[0])){
                System.out.println(new ArabicNum(num[0]).divide(new ArabicNum(num[1])).number);
            }
            else throw new IncorrectInputException("IncorectInput");

        }


    }


}
