package za.co.tut4life.rest;


import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import za.co.tut4life.dao.Book;
import za.co.tut4life.session.BookService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author stephanos
 */
@Path("/book")
public class BookResource {
    private BookService service;
    
    public BookResource() throws NamingException {
        InitialContext ic = new InitialContext();
        service = (BookService) ic.lookup("za.co.tut4life.session.BookService");
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/hello/{name}/{surname}")
    public String sayHello(@PathParam("name") String inputName, @PathParam("surname") String inputSurname) {
       return "Hello " + inputName + " " + inputSurname; 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public String saveXmlBook(Book book) {
        return service.addBook(book);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/add")
    public String saveJsonBook(Book book) {
        return service.addBook(book);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public String updateXmlBook(Book book) {
        return service.updateBook(book);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/update")
    public String updateJsonBook(Book book) {
        return service.updateBook(book);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/getXml/{bookId}")
    public Book getXmlBook(@PathParam("bookId") int inputId) {
        return service.getBook(inputId);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getJson/{bookId}")
    public Book getJsonBook(@PathParam("bookId") int inputId) {
        return service.getBook(inputId);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/getAllXml")
    public List<Book> getXmlBook() {
        return service.getAllBooks();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllJson")
    public List<Book> getJsonBook() {
        return service.getAllBooks();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/deleteXml/{bookId}")
    public String deleteXmlBook(@PathParam("bookId") int inputId) {
        return service.deleteBook(inputId);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deleteJson/{bookId}")
    public String deleteJsonBook(@PathParam("bookId") int inputId) {
        return service.deleteBook(inputId);
    }
}
