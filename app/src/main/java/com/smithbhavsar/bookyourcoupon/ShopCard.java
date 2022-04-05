package com.smithbhavsar.bookyourcoupon;

public class ShopCard {

        private int id , price;
        private String shopname,category,offer_detail,rating;
        private int shopimg;

    public ShopCard(int id, String shopname, String category, String offer_detail, int price, String rating, int shopimg) {
        this.id = id;
        this.shopname = shopname;
        this.category = category;
        this.offer_detail = offer_detail;
        this.price = price;
        this.rating = rating;
        this.shopimg = shopimg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOffer_detail() {
        return offer_detail;
    }

    public void setOffer_detail(String offer_detail) {
        this.offer_detail = offer_detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getShopimg() {
        return shopimg;
    }

    public void setShopimg(int shopimg) {
        this.shopimg = shopimg;
    }
}
