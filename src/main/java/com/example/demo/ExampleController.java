package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @GetMapping("{name}")
    public String demo(@PathVariable String name) {
        return "HELLO " + name.toUpperCase();
    }

    @GetMapping("bye")
    public String demo2() {
        return "OK BYE!!!";
    }
}
