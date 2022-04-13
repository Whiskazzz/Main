package com.daniil;

 class RomanNum{
    private String number;



     public RomanNum(String number) {
        this.number = number;
    }
     public String getNumber() {
         return number;
     }

     public void setNumber(String number) {
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

    public static boolean isRoman(String s) {
        return s.matches("^(X?|V?I{0,3}|I[VX])$");
    }


    public RomanNum plus(RomanNum a) {

        return new ArabicNum(a.toArabic().getNumber()+this.toArabic().getNumber()).toRoman();
    }

    public RomanNum minus(RomanNum a) throws IncorrectInputException {
        int d = this.toArabic().getNumber()-a.toArabic().getNumber();
        if (d<1) {
            throw new IncorrectInputException("too low for Rome");
        }
        return new ArabicNum(d).toRoman();
    }

    public RomanNum multiply(RomanNum a) {
        return new ArabicNum(a.toArabic().getNumber()*this.toArabic().getNumber()).toRoman();
    }

    public RomanNum divide(RomanNum a) throws IncorrectInputException {
        int d = this.toArabic().getNumber()/a.toArabic().getNumber();
        if (d<1) {
            throw new IncorrectInputException("too low for Rome");
        }
        ArabicNum arabicNum = new ArabicNum(d);
        return arabicNum.toRoman();
    }


}
