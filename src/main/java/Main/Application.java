package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author ferhat
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"Main"})
@EnableJpaRepositories(basePackages="Main.Repositories")
@EnableTransactionManagement
@EntityScan(basePackages="Main.Entities")
public class Application {
    
    public static void main(String[] args){
    
        SpringApplication.run(Application.class, args);
        
    }
    
}
