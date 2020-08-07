package com.example.demo.Controller;

import com.example.demo.jpaRepository.PhotoRepository;
import com.example.demo.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/photos")
public class PhotoController {
    PhotoRepository photoRepository;
    @Autowired
    public PhotoController(PhotoRepository photoRepository){
        this.photoRepository = photoRepository;
    }
    @GetMapping
    public ModelAndView photoHome(){
        ModelAndView modelAndView = new ModelAndView("/photos/photoHome");
        List<Photo> photos = photoRepository.findAll(PageRequest.of(100 , 10)).getContent();
        modelAndView.addObject("photos" , photos);
        return modelAndView;
    }

}
