package com.example.demo.jpaRepository;
import com.example.demo.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo , Integer> {

    public List<Photo> findByPrivacy(String privacy);
}
