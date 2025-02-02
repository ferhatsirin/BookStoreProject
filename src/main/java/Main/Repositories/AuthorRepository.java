/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Repositories;

import Main.Entities.Author;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ferhat
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>{
    
    List<Author> findByName(String name);
    List<Author> findByNameIgnoreCase(String name);
}
