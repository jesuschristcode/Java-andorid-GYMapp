package com.msku.example.finalproject;

import com.google.firebase.firestore.PropertyName;

public class UserInfo {
    private int height;
    private int weight;
    private int age;
    private float waist;
    private float chest;
    private float arm;
    private String sex;
    private String fatrate;

    // Firestore'dan çekilen verileri doğru bir şekilde eşleştirebilmek için boş bir constructor ekleyin
    public UserInfo() {
    }

    public UserInfo(int height, int weight, int age, float waist, float chest, float arm, String sex, String fatrate) {
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.waist = waist;
        this.chest = chest;
        this.arm= arm;
        this.sex = sex;
        this.fatrate = fatrate;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWaist() {
        return waist;
    }

    public void setWaist(float waist) {
        this.waist = waist;
    }

    public float getChest() {
        return chest;
    }

    public void setChest(float chest) {
        this.chest = chest;
    }

    public float getArm() {
        return arm;
    }

    public void setArm(float arm) {
        this.arm = arm;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFatRate() {
        return fatrate;
    }

    public void setFatRate(String fatRate) {
        this.fatrate = fatRate;
    }
    public String toString() {
        return "UserInfo{" +
                "height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                ", waist=" + waist +
                ", chest=" + chest +
                ", arm=" + arm +
                ", sex='" + sex + '\'' +
                ", fatRate='" + fatrate + '\'' +
                '}';
    }

}

