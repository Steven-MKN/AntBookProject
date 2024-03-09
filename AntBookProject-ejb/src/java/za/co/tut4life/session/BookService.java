/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.tut4life.session;

import java.util.List;
import javax.ejb.Remote;
import za.co.tut4life.dao.Book;

/**
 *
 * @author stephanos
 */
@Remote
public interface BookService {
    public String addBook(Book book);
    
    public String updateBook(Book book);
    
    public String deleteBook(int bookId);
    
    public Book getBook(int bookId);
    
    public List<Book> getAllBooks();
}
