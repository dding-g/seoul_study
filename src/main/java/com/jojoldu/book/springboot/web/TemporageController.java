package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.domain.posts.TemporageData;
import com.jojoldu.book.springboot.domain.posts.TemporageDataRepository;
import org.h2.util.json.JSONArray;
import org.h2.util.json.JSONObject;
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
        List<TemporageData> resultData = appDataRepository.findByKey(key);
        return resultData;
    }
}
