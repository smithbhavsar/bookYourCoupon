package com.smithbhavsar.bookyourcoupon;

public class couponcard {
    private String title , validtill , validon ;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValidtill() {
        return validtill;
    }

    public void setValidtill(String validtill) {
        this.validtill = validtill;
    }

    public String getValidon() {
        return validon;
    }

    public void setValidon(String validon) {
        this.validon = validon;
    }

    public couponcard(String title, String validtill, String validon) {
        this.title = title;
        this.validtill = validtill;
        this.validon = validon;
    }
}
