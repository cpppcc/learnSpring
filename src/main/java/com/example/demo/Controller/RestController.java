package com.example.demo.Controller;

import com.example.demo.ExceptionsAndError.Exception.EntityNotExistsException;
import com.example.demo.jpaRepository.PhotoRepository;
import com.example.demo.model.Message;
import com.example.demo.model.Photo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/photo-api" , produces = MediaType.APPLICATION_JSON_VALUE)
public class RestController {

    PhotoRepository photoRepository;
    @Autowired
    public RestController(PhotoRepository photoRepository){
        this.photoRepository = photoRepository;
    }

//    @ResponseBody
    @GetMapping
    public List<Photo> findAll(){
        return photoRepository.findAll(PageRequest.of(1,10)).getContent();
    }

    @JsonView(Photo.jsonView.class)
    @GetMapping("/{id}")
    public Photo findById(@PathVariable Integer id) throws EntityNotExistsException {
        return photoRepository.findById(id).orElseThrow(EntityNotExistsException::new);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message save(@RequestBody Photo photo){
        //save
        return new Message(false , "photo save successfully");
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Message update(@RequestBody Photo photo){
        //update
        return new Message(false , "photo update successfully");
    }
    @DeleteMapping("/{id}")
    public Message delete(@PathVariable Integer id){
        //delete
        return new Message(false , "photo delete successfully");
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Message exceptionHandler(Exception e){
        return new Message(true , e.getMessage());
    }

}
