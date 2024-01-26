package com.ohgiraffers.hamburgerManage.Dto;

public class memberDTO implements java.io.Serializable{

    private String name;             // 회원 이름
    private String phone;            // 휴대폰 번호

    private int code;

    private int price;

    private int coupon;

    private int finalPrice;

    private String hamburgerName;

    private String drinkName;
    private String sideName;

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getSideName() {
        return sideName;
    }

    public void setSideName(String sideName) {
        this.sideName = sideName;
    }

    public memberDTO() {}

    public memberDTO(String name) {
        this.name = name;

    }



    public memberDTO(String name, String phone) {
        this.name = name;
        this.phone = phone;

    }

    public memberDTO(String name, String phone, int code, int price, int coupon, int finalPrice, String hamburgerName) {
        this.name = name;
        this.phone = phone;
        this.code = code;
        this.price = price;
        this.coupon = coupon;
        this.finalPrice = finalPrice;
        this.hamburgerName = hamburgerName;
    }

    public memberDTO(String name, String phone, int code, int price, int coupon, int finalPrice, String hamburgerName, String drinkName, String sideName) {
        this.name = name;
        this.phone = phone;
        this.code = code;
        this.price = price;
        this.coupon = coupon;
        this.finalPrice = finalPrice;
        this.hamburgerName = hamburgerName;
        this.drinkName = drinkName;
        this.sideName = sideName;
    }

    public String getHamburgerName() {
        return hamburgerName;
    }

    public void setHamburgerName(String hamburgerName) {
        this.hamburgerName = hamburgerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(int finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Override
    public String toString() {
        return "memberDTO{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", code=" + code +
                ", price=" + price +
                ", coupon=" + coupon +
                ", finalPrice=" + finalPrice +
                ", hamburgerName='" + hamburgerName + '\'' +
                ", drinkName='" + drinkName + '\'' +
                ", sideName='" + sideName + '\'' +
                '}';
    }
}
