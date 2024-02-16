package com.example.RestTemp.User_Controll;

import com.example.RestTemp.User.User;
import com.example.RestTemp.UserRepo.User_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class User_Controller {
    @Autowired
    private User_repo userRepo;

    @GetMapping(value="/emp/users")

    public List<User> getuser()
    {
        return userRepo.findAll();
    }
    @PostMapping(value = "/emp/userdata")

    public String userdat(@RequestBody User user)
    {
        userRepo.save(user);
        return "sucess";
    }
    @PutMapping(value="/emp/updateuser/{id}")
    public String updateuser(@PathVariable long id,@RequestBody User user)
    {
        User u=userRepo.findById(id).get();
        u.setCvv(user.getCvv());
        u.setId(user.getId());
        u.setCard_number(user.getCard_number());
        u.setFname(user.getFname());
        u.setLname(user.getLname());
        u.setExpire_data(user.getExpire_data());
        userRepo.save(u);
        return "update sucess";
    }

    @DeleteMapping(value="/emp/deleteuser/{id}")
    public String deleteuser(@PathVariable long id)
    {
        User delet=userRepo.findById(id).get();
        userRepo.delete(delet);
        return "deletesucess";
    }
}
