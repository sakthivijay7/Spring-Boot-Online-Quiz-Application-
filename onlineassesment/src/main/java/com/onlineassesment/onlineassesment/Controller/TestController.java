package com.onlineassesment.onlineassesment.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.onlineassesment.onlineassesment.Model.Candidate;
import com.onlineassesment.onlineassesment.Repository.CandidateRepository;

@Controller
public class TestController{
    // auto inject repository
    @Autowired
    CandidateRepository repo;

    // mapping to the questions page
    @GetMapping("/python")
    public String pythonpage() {
        return "python";
    }

    @GetMapping("/java")
    public String javapage() {
        return "java";
    }
    
    //  post the value and js to get email,score
    @PostMapping("/test")
    @ResponseBody
    public ResponseEntity<String> savescore(@RequestBody Map<String ,String> testpage){
        String email=testpage.get("email");
        int score =Integer.parseInt(testpage.get("score"));

        // check the email in repo
        Optional<Candidate> existsemail=repo.findByEmail(email);
        
        if(existsemail.isPresent()){
            // repo table to extract candidate object
            Candidate user = existsemail.get();
            user.setScore(score);
            repo.save(user);
            //score saved in database
            return ResponseEntity.ok(user.getName() + " score: "+ user.getScore());
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }  
    } 
    @GetMapping("/test")
    public String retake(){
        return "main";
    }

 }

