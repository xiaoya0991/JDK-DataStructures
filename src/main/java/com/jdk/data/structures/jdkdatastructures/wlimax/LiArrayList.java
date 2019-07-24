package com.jdk.data.structures.jdkdatastructures.wlimax;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LiArrayList {

    @GetMapping("/index")
    private void index(){
        System.out.println(111);
    }
}
