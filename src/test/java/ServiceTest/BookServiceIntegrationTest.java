/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceTest;

import Main.Application;
import Main.Entities.Author;
import Main.Entities.Book;
import Main.Entities.Publisher;
import Main.Services.BookService;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author ferhat
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes = {Application.class, BookService.class})
public class BookServiceIntegrationTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    
    @Autowired
    private BookService bookService;
    
    @Before
    public void setUp(){

        Book book =new Book();
     
        book.setName("ferhat");
        
        Author author =new Author();
        author.setName("author");
        
        Publisher publisher = new Publisher();
        publisher.setName("publisher");
        
        book.setAuthor(author);
        book.setPublisher(publisher);
        
        entityManager.persistAndFlush(author);
        entityManager.persistAndFlush(publisher);
        entityManager.persistAndFlush(book);
        
    }
    
    @Test
    public void findByNameTest(){
    
        String name ="ferhat";
        
        List<Book> books = bookService.getBookByName(name);
        
        assertThat(books.size()).isGreaterThan(0);
        assertThat(books.get(0).getName()).isEqualTo(name);
    }
    
}
