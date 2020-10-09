/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import Main.Entities.Author;
import Main.Entities.Book;
import Main.Entities.Publisher;
import Main.Search;
import Main.Services.AuthorService;
import Main.Services.BookService;
import Main.Services.PublisherService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author ferhat
 */
@Controller
public class HomeController {
    
    @Autowired
    private BookService bookService;
    
    @Autowired
    private AuthorService authorService;
    
    @Autowired
    private PublisherService publisherService;

    @GetMapping("/")
    public String homePage(Model model) {

        List<Book> books = bookService.getAllBook();
        List<Author> authors =authorService.getAllAuthor();
        List<Publisher> publishers = publisherService.getAllPublisher();
        
        model.addAttribute("books", books);
        model.addAttribute("authors", authors);
        model.addAttribute("publishers", publishers);
        
        model.addAttribute("search", new Search());
        
        return "home";
    }

}
