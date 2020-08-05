package com.example.demo;

import com.example.demo.jpaRepository.PhotoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	PhotoRepository jpaRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void test(){
//		for (int i = 0 ; i < 4622 ; i ++){
//			Photo photo = new Photo();
//			photo.setUploadDate(new Date());
//			photo.setTitle(RandomString.make().toString());
//			photo.setPrivacy(RandomString.make().toUpperCase().toString());
//			photo.setDescription(RandomString.make().toUpperCase().toString());
//			photo.setView(new Random().nextInt());
//			jpaRepository.save(photo);
//		}
//		List<Photo> photoList = jpaRepository.findAll();
//		photoList.forEach(System.out::println);
		jpaRepository.findByPrivacy("home").forEach(System.out::println);
	}
}
