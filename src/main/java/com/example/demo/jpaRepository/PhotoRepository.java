package com.example.demo.jpaRepository;
import com.example.demo.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface PhotoRepository extends JpaRepository<Photo , Integer> {

}
