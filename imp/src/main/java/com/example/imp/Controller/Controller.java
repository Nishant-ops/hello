package com.example.imp.Controller;

import com.example.imp.Model.Student;
import com.example.imp.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class Controller {

    @Autowired
    StudentRepo studentRepo;
    @PostMapping(path="/uploadFile",produces = MediaType.APPLICATION_JSON_VALUE)

    public void upload(@RequestPart("student") Student student,@RequestPart("file") MultipartFile file) throws IOException {
       Student student1=new Student();
       // Boolean ans=file.isEmpty();
       byte[] image=file.getBytes();
       student1.setImage(image);
       student1.setFirstName(student.getFirstName());
       student1.setLastName(student.getLastName());
       /*System.out.println(student);
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
       System.out.println(ans);
        System.out.println("Found out");*/
        studentRepo.save(student1);
    }


}
