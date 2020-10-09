/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import Main.Entities.Author;
import Main.Services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

/**
 *
 * @author ferhat
 */
@Controller
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;
    
    @GetMapping("/addAuthor")
    public String addAuthorReq(Model model){
        
        model.addAttribute("author", new Author());
        
        return "addAuthor";
    }
    
    @PostMapping("saveAuthor")
    public String saveAuthorReq(@ModelAttribute Author author){
        
        authorService.saveAuthor(author);
        
        return "redirect:/";
    }
    
    @PostMapping("deleteAuthor")
    public String deleteAuthorReq(@ModelAttribute Author author){
    
        authorService.deleteAuthorById(author.getId());
        return "redirect:/";
    }
    
    @PostMapping("editAuthor")
    public String editAuthorReq(@ModelAttribute Author author, Model model){
    
        
        Author editAuthor = authorService.getAuthorById(author.getId());
        
        model.addAttribute("author", editAuthor);
        
        return "editAuthor";
    }
    
    
    @PostMapping("updateAuthor")
    public String updateAuthorReq(@ModelAttribute Author author){
        
        authorService.updateAuthor(author);
        
        return "redirect:/";
    }
    
}
