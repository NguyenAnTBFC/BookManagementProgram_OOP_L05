/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author NguyenAn;
 */
public class Book implements Serializable, Comparable<Book>{
    private String bookId;
    private String authors;
    private String title;
    private String dateOfPublication;
    private String categories;
    
    public Book(){
        
    }
    public Book(String bookId, String authors, String title, String dateOfPublication, String categories) {
        this.bookId = bookId;
        this.authors = authors;
        this.title = title;
        this.dateOfPublication = dateOfPublication;
        this.categories = categories;
    }

    

    public String getBookId() {
        return bookId;
    }

    public String getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public String getCategories() {
        return categories;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", authors=" + authors + ", title=" + title + ", dateOfPublication=" + dateOfPublication + ", categories=" + categories + '}';
    }

    @Override
    public int compareTo(Book o) {
        return this.bookId.compareTo(o.bookId);
    }
  
    
}
