package com.pb.dev.obfuscation.Controller;

import com.pb.dev.obfuscation.Protection.Filter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ObfuscationExample {

    @RequestMapping("/greeting")
    @Filter(keys = {"Name"})
    public Map<String,Object> greeting() {
        Map<String,Object> response = new HashMap<>();
        response.put("Name","Justine");
        return response;
    }

}
