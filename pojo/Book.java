package com.bookStore.pojo;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Book  {
    private Integer id;
    private String name;
    private double price;
    private String author;
    private Integer sales;
    private Integer stock;
    private String imgPath = "img/1.png";

    public Book() {
    }

    ;

    public Book(Integer id, String name, double price, String author, Integer sales, Integer stock, String imgPath) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
        //要求给定的图书封面不能为空
        if (imgPath != null && !"".equals(imgPath))
            this.imgPath = imgPath;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setImgPath(String imgPath) {
        //要求给定的图书封面不能为空
        if (imgPath != null && !"".equals(imgPath))
            this.imgPath = imgPath;
        this.imgPath = imgPath;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getSales() {
        return sales;
    }

    public Integer getStock() {
        return stock;
    }

    public String getImgPath() {
        return imgPath;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}

