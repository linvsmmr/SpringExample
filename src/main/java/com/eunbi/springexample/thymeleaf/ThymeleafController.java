package com.eunbi.springexample.thymeleaf;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@RequestMapping("/thymeleaf")
@Controller
public class ThymeleafController {

    @GetMapping("/ex01")
    public String ex01() {
        return "thymeleaf/ex01";
    }

    @GetMapping("/ex02")
    public String ex02(Model model) {

        // 과일 이름 리스트
        List<String> fruitList = new ArrayList<>();
        fruitList.add("사과");
        fruitList.add("자두");
        fruitList.add("복숭아");

        model.addAttribute("fruitList",fruitList);

        // 사용자 정보 리스트, 이름/취미/나이

        Map<String, Object> userMap = new HashMap<>();
        List<Map> userList = new ArrayList<>();


        userMap.put("name","김인규");
        userMap.put("age",28);
        userMap.put("hobby","독서");


        userList.add(userMap);


        userMap.put("name","바다");
        userMap.put("age",7);
        userMap.put("hobby","사냥");


        userList.add(userMap);

        model.addAttribute("userList",userList);

        return "thymeleaf/ex02";
    }


}