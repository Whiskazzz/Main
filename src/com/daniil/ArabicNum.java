package com.daniil;

class ArabicNum {

    private int number;

    public ArabicNum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ArabicNum(String number) {
        this.number = Integer.parseInt(number);
    }

    public RomanNum toRoman(){
        StringBuilder result = new StringBuilder();
        int temp = number;
        Numbers[] numbers = Numbers.values();
        while (temp>0) {
            for (Numbers value : numbers) {
                if (temp / value.getArabic() > 0) {
                    result.append(value.getRoman());
                    temp = temp - value.getArabic();
                    break;
                }

            }
        }
        return new RomanNum(result.toString());
    }

    public static boolean isArabic(String s) {
        try {
            int i = Integer.parseInt(s);
            return i > 0 && i < 11;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public ArabicNum plus(ArabicNum a) {
        return new ArabicNum(number+a.number);
    }

    public ArabicNum minus(ArabicNum a) {
        return new ArabicNum(number-a.number);
    }

    public ArabicNum multiply(ArabicNum a) {
        return new ArabicNum(number*a.number);
}

    public ArabicNum divide(ArabicNum a) {
        return new ArabicNum(number/a.number);
    }
}
