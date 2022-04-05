package com.smithbhavsar.bookyourcoupon;

public class categorycard {

        private int id;
        private String title;
        private int image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public categorycard(int id, String title, int image) {
            this.id = id;
            this.title = title;
            this.image = image;
        }

}
