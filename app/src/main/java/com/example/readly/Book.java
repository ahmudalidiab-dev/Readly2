package com.example.readly;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.auth.User;

public class Book {
    private String id;
    private String authur;
    private String price;
    private String title;
    private String category;
    private String year;
    private String photo;

    public Book() {
    }

    public Book(String id, String authur, String price, String title, String category, String year, String photo) {
        this.id = id;
        this.authur = authur;
        this.price = price;
        this.title = title;
        this.category = category;
        this.year = year;
        this.photo = photo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthur() {
        return authur;
    }

    public void setAuthur(String authur) {
        this.authur = authur;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", authur='" + authur + '\'' +
                ", price='" + price + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", year='" + year + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}



