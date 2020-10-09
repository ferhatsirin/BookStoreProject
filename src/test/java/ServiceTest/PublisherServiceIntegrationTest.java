/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceTest;

import Main.Application;
import Main.Entities.Publisher;
import Main.Services.PublisherService;
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
@ContextConfiguration(classes={Application.class, PublisherService.class})
public class PublisherServiceIntegrationTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private PublisherService publisherService;
    
    
    @Before
    public void setUp(){
    
        Publisher publisher = new Publisher();
        publisher.setName("ferhat");
        
        entityManager.persistAndFlush(publisher);
        
    }
    
    @Test
    public void findByIdTest(){
    
        int id = 1;
        
        Publisher publisher = publisherService.getPublisherById(id);
        
        assertThat(publisher.getId()).isEqualTo(id);
    }
    
    
    
    
}
