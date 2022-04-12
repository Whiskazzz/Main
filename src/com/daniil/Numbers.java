package com.daniil;

public enum Numbers {

    C("C",100),
    XC("XC",90),
    L("L",50),
    XL("XL",40),
    X("X",10),
    IX("IX",9),
    V("V",5),
    IV("IV",4),
    I("I",1);

    private final String roman;
    private final int arabic;

    Numbers(String roman, int arabic) {
        this.roman = roman;
        this.arabic = arabic;
    }

    public String getRoman() {
        return roman;
    }

    public int getArabic() {
        return arabic;
    }
}
