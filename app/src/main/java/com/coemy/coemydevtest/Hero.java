package com.coemy.coemydevtest;

import java.io.Serializable;

/**
 * Created by ASUS on 03/07/2016.
 */

public class Hero implements Serializable {

    private String title;
    private String into;
    private String year;
    private String text;
    private String color;
    private int image;

    public Hero() {
    }

    public Hero(String title, String into, String text) {
        this.title = title;
        this.into = into;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInto() {
        return into;
    }

    public void setInto(String into) {
        this.into = into;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
