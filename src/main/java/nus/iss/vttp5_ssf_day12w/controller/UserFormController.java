package nus.iss.vttp5_ssf_day12w.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import nus.iss.vttp5_ssf_day12w.model.UserForm;

@Controller
public class UserFormController {

    // handler for "/user-form" request 
    @GetMapping("user-form")
    public String userFormPage(Model model) {

        // empty UserForm model object to store form data 
        UserForm userForm = new UserForm();

        // add object to model
        model.addAttribute("userForm", userForm);

        // return "/user-form"
        return "user-form";

    }

    // handler for form submission request
    @PostMapping("user-form/success")
    public String submitForm(Model model, 
                            @ModelAttribute UserForm userForm) {

        // list to store 0 to 30
        List<Integer> numArray = new ArrayList<>();

        // fill numArray with 0 to 30
        for (int i = 1; i <= 30; i++) {
            numArray.add(i);

        }

        // shuffle numArray
        Collections.shuffle(numArray);

        // list to store selected random numbers 
        List<Integer> selectedNums = new ArrayList<>();

        // list to store selected image file paths
        List<String> selectedFilePaths = new ArrayList<>();

        // show random numbers 
        for (int i = 0; i < userForm.getUserInput(); i++) {

            // select i th number in numArray
            Integer randNum = numArray.get(i);

            // update selectedNums
            selectedNums.add(randNum);

            // update selectedFilePaths
            selectedFilePaths.add("/JanBrettsNumbers/number" + randNum.toString() + ".jpg");
            
        }

        // add selected random numbers to model 
        model.addAttribute("selectedNums", selectedNums);

        // add selected file paths to model 
        model.addAttribute("selectedFilePaths", selectedFilePaths);

        // add userForm to model
        model.addAttribute("userForm", userForm);

        // return "/user-form/success"
        return "user-form-success";

    }
    
}
