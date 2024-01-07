package com.msku.example.finalproject;

public class Product {
    private String name;
    private String value;

    // Boş constructor ekleyin (Firestore'dan veri almak için gereklidir)
    public Product() {
    }

    // Parametreli constructor ekleyin
    public Product(String name, String value) {
        this.name = name;
        this.value = value;
    }

    // Getter ve setter metotları
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}

