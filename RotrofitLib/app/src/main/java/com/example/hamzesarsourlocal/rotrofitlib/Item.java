package com.example.hamzesarsourlocal.rotrofitlib;

/**
 * Created by hamze sarsour local on 9/1/2016.
 */
public class Item {
    //Variables that are in our json
    private int Id;
    private String name;
    private String publisher;
    private String image;

    //Getters and setters
    public int getBookId() {
        return Id;
    }

    public void setBookId(int bookId) {
        this.Id = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
