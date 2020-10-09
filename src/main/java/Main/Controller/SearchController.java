/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import Main.Entities.Author;
import Main.Entities.Book;
import Main.Search;
import Main.Services.AuthorService;
import Main.Services.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author ferhat
 */
@Controller
public class SearchController {
    
    
    @Autowired
    private BookService bookService;
    
    @Autowired
    private AuthorService authorService;
    
    
    @PostMapping("search")
    public String searchReq(@ModelAttribute Search search, Model model){
    
        if(search.getType().equals("1")){ // book search

            List<Book> books = bookService.getBookByNameIgnoreCase(search.getText());
            
            model.addAttribute("books", books);
                    
            return "searchBook";
        }else{ // author search
        
            List<Author> authors = authorService.getAuthorByNameIgnoreCase(search.getText());
            
            model.addAttribute("authors", authors);
            
            return "searchAuthor";
        }
    }
}
