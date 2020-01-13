package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.domain.posts.AppData;
import com.jojoldu.book.springboot.domain.posts.AppDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TemporageController {

    @Autowired
    AppDataRepository appDataRepository;

    @PostMapping("/save")
    public AppData dataSave(@RequestParam("key") String key, @RequestParam("value") String value){
        AppData data = new AppData();

        data.setKey(key);
        data.setValue(value);

        AppData newData = appDataRepository.save(data);

        String result_data = "{\"result\" : \"Success\"}";

        return appDataRepository.findByKey("key");
    }
}
