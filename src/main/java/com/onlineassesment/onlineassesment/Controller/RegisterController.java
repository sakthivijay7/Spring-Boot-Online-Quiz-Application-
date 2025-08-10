package com.onlineassesment.onlineassesment.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlineassesment.onlineassesment.Model.Candidate;
import com.onlineassesment.onlineassesment.Repository.CandidateRepository;

@Controller
public class RegisterController{

    // auto inject repository
    @Autowired
    CandidateRepository repo;
    
    // This is  customized root to deploy the Railway hosting
    @GetMapping("/")
    public String homeRedirect() {
       return "redirect:/register";
}
    // Register empty form to use Get method
    @GetMapping("/register")
    public String registerform(Model model){
        model.addAttribute("candidate",new Candidate());  // html content to get full object
        return "register";
    }
   
    // filled form to pass the data in the same url by used post method (the candidate in the html object)
    @PostMapping("/register")
    public String registered(@ModelAttribute Candidate candidate,Model model){
     
        //  check if email exist db == user entered email 
        Optional<Candidate> exitsemail=repo.findByEmail(candidate.getEmail());
        // strictly check the Optional return values or null if email present then login page
        if(exitsemail.isPresent()){
            model.addAttribute("exists", "Email Id already registered.Please login");
            return "register";    
        }
        // save user registered details
        model.addAttribute("registered","Registered successfully");
        repo.save(candidate);
        return "register";
    }
    
}

