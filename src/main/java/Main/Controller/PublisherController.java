/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Controller;

import Main.Entities.Publisher;
import Main.Services.PublisherService;
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
public class PublisherController {
    
    @Autowired
    private PublisherService publisherService;
    
    @GetMapping("addPublisher")
    public String addPublisherReq(Model model){
        
        model.addAttribute("publisher", new Publisher());
    
        return "addPublisher";
    }
    
    @PostMapping("savePublisher")
    public String savePublisherReq(@ModelAttribute Publisher publisher){
        
        publisherService.savePublisher(publisher);
    
        return "redirect:/";
    }
    
    @PostMapping("deletePublisher")
    public String deletePublisherReq(@ModelAttribute Publisher publisher){
    
        publisherService.deletePublisherById(publisher.getId());
        
        return "redirect:/";
    }
    
    @PostMapping("editPublisher")
    public String editPublisherReq(@ModelAttribute Publisher publisher, Model model){
    
        Publisher editPublisher = publisherService.getPublisherById(publisher.getId());
        
        model.addAttribute("publisher", editPublisher);
        
        return "editPublisher";
    }
    
    @PostMapping("updatePublisher")
    public String updatePublisherReq(@ModelAttribute Publisher publisher){
    
        publisherService.updatePublisher(publisher);
        
        return "redirect:/";
    }
}
