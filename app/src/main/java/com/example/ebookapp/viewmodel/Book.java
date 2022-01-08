package com.example.ebookapp.viewmodel;

public class Book {
    private int id;
    private String bookName;
    private String author;
    Integer imageUrl;

    public Book(int id, Integer imageUrl, String bookName, String author) {
        this.id = id;
        this.bookName = bookName;
        this.imageUrl = imageUrl;
        this.author = author;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
