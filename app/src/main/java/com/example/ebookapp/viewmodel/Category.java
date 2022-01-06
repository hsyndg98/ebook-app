package com.example.ebookapp.viewmodel;

import java.util.List;

public class Category {
    private String categoryName;
    private List<Book> bookList;

    public Category(String categoryName, List<Book> bookList) {
        this.categoryName = categoryName;
        this.bookList = bookList;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
