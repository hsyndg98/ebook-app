package com.example.ebookapp.viewmodel;

public class Book {
    private int id;
    private String bookName;
    Integer imageUrl;

    public Book(int id, Integer imageUrl, String bookName) {
        this.id = id;
        this.bookName = bookName;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
