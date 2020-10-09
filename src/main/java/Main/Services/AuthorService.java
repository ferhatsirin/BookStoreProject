/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Services;

import Main.Entities.Author;
import Main.Repositories.AuthorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ferhat
 */
@Service
public class AuthorService {
    
    @Autowired
    private AuthorRepository repository;
    
    public Author getAuthorById(int id){
    
        Author author = repository.getOne(id);
        
        return author;
    }
    
    public List<Author> getAuthorByName(String name){
    
        List<Author> authors = repository.findByName(name);
        
        return authors;
    }
    
    public List<Author> getAuthorByNameIgnoreCase(String name){
    
        List<Author> authors = repository.findByNameIgnoreCase(name);
        
        return authors;
    }
    
    public List<Author> getAllAuthor(){
    
        List<Author> authors = repository.findAll();
        
        return authors;
    }
    
    public void saveAuthor(Author author){
    
        repository.saveAndFlush(author);
    }
    
    public void deleteAuthorById(int id){
    
        repository.deleteById(id);
    }
    
    public void updateAuthor(Author author){
    
        repository.saveAndFlush(author);
    }
    
}
