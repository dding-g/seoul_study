package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.domain.posts.TemporageData;
import com.jojoldu.book.springboot.domain.posts.TemporageDataRepository;
import com.jojoldu.book.springboot.domain.posts.TemporageUserData;
import com.jojoldu.book.springboot.domain.posts.TemporageUserDataRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemporageController {

    @Autowired
    TemporageDataRepository appDataRepository;

    @Autowired
    TemporageUserDataRepository userDataRepository;

    @PostMapping("/save")
    public String dataSave(@RequestParam("key") String key, @RequestParam("value") String value){
        TemporageData data = new TemporageData();

        try{
            if(key != null && value != null){
                data.setKey(key);
                data.setValue(value);
                appDataRepository.save(data);

                return "success";
            }else{
                return "fail : key or value is empty";
            }
        }catch (Exception e){
            return e.toString();
        }
    }

    @GetMapping("/getData")
    public List<TemporageData> dataResponse(@RequestParam("key") String key){
        return appDataRepository.findByKey(key);
    }

    @PostMapping("/sign-up")
    public String user_sign_up(@RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("name") String name){
        TemporageUserData user_data = new TemporageUserData();

        try{
            if(email != null && password != null && name != null){
                user_data.setEmail(email);
                user_data.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
                user_data.setName(name);

                userDataRepository.save(user_data);
                return "success";
            }else{
                return "fail : some value has NULL";
            }
        }catch (Exception e){
            return e.toString();
        }
    }

    @PostMapping("/sign-in")
    public String user_sign_in(@RequestParam("email") String email, @RequestParam("password") String password){
        TemporageUserData user_data = (TemporageUserData) userDataRepository.findByEmail(email); //이렇게 List로 받아야 하는지 그냥 cast로 해서 받아도 되는지
        if(user_data == null){
            return "email is not corret";
        }

        if(BCrypt.checkpw(password, user_data.getPassword())){
            return "login success";
        }else{
            return "not corret password or email";
        }
    }
}
