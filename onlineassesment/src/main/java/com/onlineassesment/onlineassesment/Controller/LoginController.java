package com.onlineassesment.onlineassesment.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlineassesment.onlineassesment.Model.Candidate;
import com.onlineassesment.onlineassesment.Repository.CandidateRepository;

@Controller
public class LoginController {
    // auto inject the repository
    @Autowired
    CandidateRepository repo;
 
    // just a normal login page
    @GetMapping("/login")
    public String loginuser(){
      return "login";
    }
    // login page to post the value in the url ,query params
 
    @PostMapping("/login")
    public String loginuser(@RequestParam String email,@RequestParam String password,Model model){
       Optional<Candidate> existsemail =repo.findByEmail(email);

        if(existsemail.isEmpty()){
        model.addAttribute("noemail","Email not found!.Please register");
        // register page
        model.addAttribute("candidate",new Candidate());
        return "login";
        }
       
    //    next we have to check password same with the email so extract optional table to get password using object
       Candidate object=existsemail.get();

    //    now this object to get password to check this repo password = user entered password
        String existspassword = object.getPassword();

      if(existspassword !=null && existspassword.equals(password)){

          model.addAttribute("login", "Login successfully!");
          model.addAttribute("getname", object.getName());
          model.addAttribute("getgender",object.getGender());
          model.addAttribute("getemail",object.getEmail());
          model.addAttribute("getphone",object.getPhone());
          return "main";
      }
      else{
        model.addAttribute("getpassword","Wrong password!.Enter correct password");   
    //    pass prefilled email
        model.addAttribute("email",email);
       }
      return "login"; 
    
    }
  }