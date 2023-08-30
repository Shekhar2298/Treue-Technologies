package com.example.moviesort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.example.moviesort.Service.DataSeedingService;

@SpringBootApplication
public class MoviesortApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(MoviesortApplication.class, args);
	}



    @Autowired
    private DataSeedingService dataSeedingService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        dataSeedingService.seedData();
    }
}