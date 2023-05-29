/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import dao.AuthorDAO;
import dao.CategoryDAO;
import dao.PublisherDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author emsin
 */
public class Book {
    private String name, img, language;
    private int id, author_id, publisher_id, amount, sold, ratingnums;
    private float star, price;
    private Publisher publisher;
    private Author author;
    private List<Category> categories;
    public Book(int id, String name, String img, String language, int author_id, int publisher_id, float price, int amount, int sold, float star, int ratingnums ) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.language = language;
        
        this.author_id = author_id;
        this.publisher_id = publisher_id;
        this.price = price;
        this.amount = amount;
        this.sold = sold;
        this.star = star;
        this.ratingnums = ratingnums;
        
        this.author = new AuthorDAO().getAuthorById(author_id);
        this.publisher = new PublisherDAO().getPublisherById(publisher_id);
        this.categories = new CategoryDAO().getAllCategoriesOfBookId(id);
    }

    public Book(int id, String name, String img, int amount, float price) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public int getRatingnums() {
        return ratingnums;
    }

    public void setRatingnums(int ratingnums) {
        this.ratingnums = ratingnums;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Category> getCategories() {
        return categories;
    }
    public Set<String> getCategoryIds(){
        int n = categories.size();
        Set<String> list = new HashSet<>();
        for(int i=0;i<n;i++) list.add(categories.get(i).getId()+"");
        return list;
    }
    @Override
    public String toString() {
        return "Book{" + "name=" + name + ", img=" + img + ", language=" + language + ", id=" + id + ", author_id=" + author_id + ", publisher_id=" + publisher_id + ", amount=" + amount + ", sold=" + sold + ", star=" + star + ", ratingnums=" + ratingnums + ", price=" + price + '}';
    }
    
    
}
