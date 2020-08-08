package com.example.demo.Controller;

import com.example.demo.ExceptionsAndError.Exception.ServiceException;
import com.example.demo.jpaRepository.PhotoRepository;
import com.example.demo.model.Photo;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/detail")
public class PhotoController {
    PhotoRepository photoRepository;
    @Autowired
    public PhotoController(PhotoRepository photoRepository){
        this.photoRepository = photoRepository;
    }


    @GetMapping
    public String photoHome(Model model){
        List<Photo> photos = photoRepository.findAll(PageRequest.of(100 , 10)).getContent();
        model.addAttribute("photos" , photos);
        return "/photos/photoHome";
    }


    @GetMapping("/{id}")
    public String showPhoto(@PathVariable Integer id , Model model) throws ServiceException{
        Photo photo = photoRepository.findById(id).orElseThrow(ServiceException::new);
        model.addAttribute("shPhoto" , photo);
        return "/photos/showPhoto";
    }

    @PostMapping("/update")
    public String updatePhoto(Photo photo){
        photoRepository.updatePhotoByTitleDescriptionPrivacyView_UploadDate(photo.getTitle() , photo.getDescription() , photo.getPrivacy()  , photo.getView() ,photo.getUploadDate() ,  photo.getId());
        return "redirect:/detail/" + photo.getId();
    }

}
