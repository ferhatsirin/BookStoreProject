/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Services;

import Main.Entities.Book;
import Main.Repositories.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferhat
 */
@Service
public class BookService {
    
    @Autowired
    private BookRepository repository;
    
    public Book getBookById(int id){
    
        Book book =repository.getOne(id);
        
        return book;
    }
    
    public List<Book> getBookByName(String name){
    
        List<Book> books =repository.findByName(name);
        
        return books;
    }
    
    public List<Book> getBookByNameIgnoreCase(String name){
    
        List<Book> books = repository.findByNameIgnoreCase(name);
        
        return books;
    }
    
    public List<Book> getAllBook(){
    
        List<Book> books = repository.findAll();
        
        return books;
    }
    
    public void saveBook(Book book){
    
        repository.saveAndFlush(book);
    }
    
    public void deleteBookById(int id){
    
        repository.deleteById(id);
    }
    
    public void updateBook(Book book){
    
        repository.saveAndFlush(book);
    }
    
}
