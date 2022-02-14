package com.example.hellospring.controllers;

import com.example.hellospring.services.ShowDay;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    private final ShowDay showDay;

    public IndexController(ShowDay showDay) {
        this.showDay = showDay;
    }

    @GetMapping("isitfriday")
    public String isItFriday(@RequestParam(value = "date", required = false) String date){

        return this.showDay.calculateToday(date);

    }

    @GetMapping("/hello")
    public String helloEverybody(){
        return "Hello everybody";
    }

    @GetMapping("greet")
    public String greetUser(@RequestParam String name){
        return "Hello " + name + " , Welcome to my web world!";

    }

    @GetMapping("echo")
    public String displayMessage(@RequestParam String message){
        return message;
    }


}
