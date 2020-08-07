package com.example.demo.jpaRepository;
import com.example.demo.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo , Integer> {

    List<Photo> findByPrivacy(String privacy);

    @Transactional
    @Modifying
    @Query("update Photo set Title = ?1 , description = ?2 , privacy = ?3 , view = ?4 where  id = ?5")
    void updatePhotoByTitleDescriptionPrivacyView_(String title , String description , String privacy ,Integer view_  , Integer id);
}
