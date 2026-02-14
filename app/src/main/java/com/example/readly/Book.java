package com.example.readly;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.auth.User;

public class Book implements Parcelable {
    private String id;
    private String authur;
    private  String price;
    private  String title;
    private String category;
    private String year;
   private String photo;
    public Book() {
    }

    public Book(String id, String title, String authur, String category,
                    String price, String photo,String year) {
        this.id = id;
        this.authur= authur;
        this.category= category;
        this.photo=photo;
        this.year=year;
        this.price=price;
        this.title=title;
    }

    protected Book(Parcel in) {
        this.id = in.readString();
        this.authur= in.readString();
        this.category= in.readString();
        this.photo=in.readString();
        this.year=in.readString();
        this.price=in.readString();
        this.title=in.readString();

    }

    @SuppressLint("RestrictedApi")
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @SuppressLint("RestrictedApi")
        @Override
        public User createFromParcel(Parcel in) {
            User user = new User(in);
            return user;
        }

        @SuppressLint("RestrictedApi")
        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.year);
        dest.writeString(this.authur);
        dest.writeString(this.title);
        dest.writeString(this.category);
        dest.writeString(this.price);
        dest.writeString(this.photo);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getAuthur() {
        return authur;
    }

    public void setAuthur(String authur) {
        this.authur = authur;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                "nameCar='" + title + '\'' +
                ", horse_power='" + category + '\'' +
                ", owners='" + authur + '\'' +
                ", year='" + year + '\'' +
                ", price='" + price + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }


    public int describeContents() {
        return 0;
    }

    public String getCar_model() {
        return null;
    }
}



