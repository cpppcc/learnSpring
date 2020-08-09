package com.example.demo.Controller;

import com.example.demo.ExceptionsAndError.Exception.ServiceException;
import com.example.demo.jpaRepository.PhotoRepository;
import com.example.demo.model.Photo;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/detail")
@SessionAttributes("photo")
public class Controller1 {
    PhotoRepository photoRepository;
    @Autowired
    public Controller1(PhotoRepository photoRepository){
        this.photoRepository = photoRepository;
    }


    @GetMapping
    public String photoHome(Model model){
        List<Photo> photos = photoRepository.findAll(PageRequest.of(100 , 10)).getContent();
        model.addAttribute("photos" , photos);
        return "/1/photoHome";
    }
    //1111111111111111111111111111111111111111111111111111111111111111111111111111

    @GetMapping("/{id}")
    public String showPhoto(@PathVariable Integer id , Model model ,@ModelAttribute("message") String message) throws ServiceException{
        Photo photo = photoRepository.findById(id).orElseThrow(ServiceException::new);
        model.addAttribute("shPhoto" , photo);
        model.addAttribute("message" , message);
        return "/1/showPhoto";
    }

    @PostMapping("/update")
    public String updatePhoto(Photo photo , RedirectAttributes redirectAttributes){
        photoRepository.updatePhotoByTitleDescriptionPrivacyView_UploadDate(photo.getTitle() , photo.getDescription() , photo.getPrivacy()  , photo.getView() ,photo.getUploadDate() ,  photo.getId());
        redirectAttributes.addAttribute("message" , "operation done successfully");
        return "redirect:/detail/" + photo.getId();
    }

    //22222222222222222222222222222222222222222222222222222222222222222222222222
    @GetMapping("step1")
    public String step1(ModelMap modelMap){
        modelMap.addAttribute("photo" , new Photo());
        return "1/step1";
    }


    @PostMapping("step2")
    public String step2(Photo photo , ModelMap modelMap , SessionStatus sessionStatus){
        photoRepository.updatePhotoByTitleDescriptionPrivacyView_UploadDate(photo.getTitle(),photo.getDescription(),photo.getPrivacy(),photo.getView(),photo.getUploadDate() , photo.getId());
        modelMap.addAttribute("photo" ,  photo);
        sessionStatus.isComplete(); //
        return "1/step2";
    }


}
