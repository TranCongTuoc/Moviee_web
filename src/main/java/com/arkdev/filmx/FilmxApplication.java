package com.arkdev.filmx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.arkdev.filmx.model.User;
import com.arkdev.filmx.repository.UserRepository;
import com.arkdev.filmx.util.Type;

@SpringBootApplication
public class FilmxApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(FilmxApplication.class, args);
    }
    @Autowired
    UserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception{
    	User user = userRepository.findByUsername("admin").orElse(null);
    	if(user == null) {
    		user = User.builder().username("admin").password(new BCryptPasswordEncoder().encode("admin")).role(Type.ADMIN).build();
    		userRepository.save(user);
    	}
    }
}
