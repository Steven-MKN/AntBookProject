/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.tut4life.dao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stephanos
 */
@XmlRootElement
@XmlAccessorType
@Entity
@Table(name="tblBook")
public class Book implements Serializable {
    @Id
    @GeneratedValue
    private int bookId;
    
    private String title;
    
    private String author;
    
    private String type;

    public Book() {
    }

    public Book(int bookId, String title, String author, String type) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.type = type;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
