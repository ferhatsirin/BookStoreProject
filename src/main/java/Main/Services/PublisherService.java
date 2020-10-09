/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Services;

import Main.Entities.Publisher;
import Main.Repositories.PublisherRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author ferhat
 */
@Service
public class PublisherService {
    
    @Autowired
    private PublisherRepository repository;
    
    public Publisher getPublisherById(int id){
    
        Publisher publisher = repository.getOne(id);
        
        return publisher;
    }
    
    
    public List<Publisher> getAllPublisher(){
    
        List<Publisher> publishers = repository.findAll();
        
        return publishers;
    }
    
    public void savePublisher(Publisher publisher){
    
        repository.saveAndFlush(publisher);
    }
    
    public void deletePublisherById(int id){
    
        repository.deleteById(id);
    }
    
    public void updatePublisher(Publisher publisher){
    
        repository.saveAndFlush(publisher);
    }
    
}
