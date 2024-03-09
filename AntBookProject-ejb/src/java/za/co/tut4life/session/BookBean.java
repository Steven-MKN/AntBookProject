/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.co.tut4life.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import za.co.tut4life.dao.Book;

/**
 *
 * @author stephanos
 */
@Stateless
public class BookBean implements BookService {

    @PersistenceContext(unitName="uniBook")
    private EntityManager manager;
    
    @Override
    public String addBook(Book book) {
        manager.persist(book);
        return "Book is added";
    }

    @Override
    public String updateBook(Book book) {
        Book bookExists = getBook(book.getBookId());
        
        if (book != null) {
            manager.merge(book);
            return "Book updated!!!";
        }
        
        return "Book not updated because it does not exist";
    }

    @Override
    public String deleteBook(int bookId) {
        Book bookExist = getBook(bookId);
        
        if (bookExist != null) {
            manager.remove(bookExist);
            return "Book is deleted";
        }
        
        return "Book is not deleted because it does not exist";
    }

    @Override
    public Book getBook(int bookId) {
        return manager.find(Book.class, bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        String sql = "select * from book";
        List<Book>list = (List<Book>) manager.createQuery(sql).getResultList();
        return list;
    }
    
}
