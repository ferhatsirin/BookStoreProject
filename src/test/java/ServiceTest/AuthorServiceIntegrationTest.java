/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceTest;

import Main.Application;
import Main.Entities.Author;
import Main.Services.AuthorService;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
@ContextConfiguration(classes={Application.class, AuthorService.class})
public class AuthorServiceIntegrationTest {

    
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AuthorService authorService;

    private int id;
    
    @Before
    public void setUp() {

        Author author = new Author();
        author.setName("ferhat");
        
        id = entityManager.persistAndGetId(author, Integer.class);
    }
    
    @Test
    public void findByNameTest(){
    
        String name ="ferhat";
        
        List<Author> authors =authorService.getAuthorByName(name);
     
        assertThat(authors.size()).isGreaterThan(0);
        assertThat(authors.get(0).getName()).isEqualTo(name);

    }
    
    @Test
    public void findByIdTest(){
    
        Author author = authorService.getAuthorById(id);
        
        assertThat(author.getId()).isEqualTo(id);
    }

}
