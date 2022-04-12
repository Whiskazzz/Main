package com.daniil;

public class RomanNum{
    String number;

    public RomanNum(String number) {
        this.number = number;
    }

    public ArabicNum toArabic(){
        int result = 0;
        String temp = this.number;
        Numbers[] numbers = Numbers.values();

        while (!temp.isEmpty()){
            int i = 0;
            while (i<numbers.length+1){
                i++;
                if (i<numbers.length && temp.contains(numbers[i].getRoman())
                        && temp.indexOf(numbers[i].getRoman()) < temp.indexOf(numbers[i-1].getRoman())){
                    temp = temp.substring(numbers[i].getRoman().length());
                    result += numbers[i].getArabic();
                    break;
                }
                i--;
                if (i<numbers.length && temp.contains(numbers[i].getRoman())){
                    temp = temp.substring(numbers[i].getRoman().length());
                    result += numbers[i].getArabic();
                    break;
                }
                i+=2;
            }
        }
        return new ArabicNum(result);

    }

    public static boolean isRoman(String s){
        return s.matches("^(M{0,3})(D?C{0,3}|C[DM])(L?X{0,3}|X[LC])(V?I{0,3}|I[VX])$");
    }


    public RomanNum plus(RomanNum a) {

        return new ArabicNum(a.toArabic().number+this.toArabic().number).toRoman();
    }

    public RomanNum minus(RomanNum a) {
        return new ArabicNum(a.toArabic().number-this.toArabic().number).toRoman();
    }

    public RomanNum multiply(RomanNum a) {
        return new ArabicNum(a.toArabic().number*this.toArabic().number).toRoman();
    }

    public RomanNum divide(RomanNum a) {
        double d = this.toArabic().number/a.toArabic().number;
        ArabicNum arabicNum = new ArabicNum(d);
        return arabicNum.toRoman();
    }
}