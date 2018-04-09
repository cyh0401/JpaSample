package com.example.demo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	BookRepository bookRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 데이터 Insert
		bookRepository.save(new BookDomain("title1", "content1", "writer1", new Timestamp(System.currentTimeMillis()), 0));
		bookRepository.save(new BookDomain("title2", "content2", "writer2", new Timestamp(System.currentTimeMillis()), 0));
		bookRepository.save(new BookDomain("title3", "content3", "writer3", new Timestamp(System.currentTimeMillis()), 0));
		bookRepository.save(new BookDomain("title4", "content4", "writer4", new Timestamp(System.currentTimeMillis()), 0));
		
		// 데이터 Retrieve
		List<BookDomain> list1 = bookRepository.findAll();
		
		// DB에서 가져온 값 출력
		System.out.println("findAll() Method.");
		for (BookDomain bookDomain : list1) {
			System.out.println(bookDomain.toString());
		}
		
		// 데이터 Delete
		bookRepository.deleteAll();
	}
}
