/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import Main.Entities.Author;
import Main.Entities.Book;
import Main.Entities.Publisher;
import Main.Services.AuthorService;
import Main.Services.BookService;
import Main.Services.PublisherService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ferhat
 */

@Controller
public class BookController {
    
    @Autowired
    private BookService bookService;
    
    @Autowired
    private PublisherService publisherService;
    
    @Autowired
    private AuthorService authorService;
    
    
    @GetMapping("addBook")
    public String addBookReq(Model model){
        
        List<Author> authors = authorService.getAllAuthor();
        
        List<Publisher> publishers = publisherService.getAllPublisher();
        
        model.addAttribute("book", new Book());
        
        model.addAttribute("publishers", publishers);
        model.addAttribute("authors", authors);
        
        return "addBook";
    }
    
    @PostMapping("saveBook")
    public String saveBookReq(@ModelAttribute Book book){

        bookService.saveBook(book);
        
        return "redirect:/";
    }
    
    @PostMapping("deleteBook")
    public String deleteBookReq(@ModelAttribute Book book){
    
        bookService.deleteBookById(book.getId());
        
        return "redirect:/";
    }
    
    @PostMapping("editBook")
    public String editBookReq(@ModelAttribute Book book,Model model){
    
        Book editBook = bookService.getBookById(book.getId());
        
        List<Author> authors =authorService.getAllAuthor();
        List<Publisher> publishers = publisherService.getAllPublisher();
        

        model.addAttribute("authors", authors);
        model.addAttribute("publishers", publishers);
        
        model.addAttribute("book", editBook);
       
        return "editBook";
    }
    
    @PostMapping("updateBook")
    public String updateBookReq(@ModelAttribute Book book){
    
        bookService.updateBook(book);
        
        return "redirect:/";
    }
    
}
