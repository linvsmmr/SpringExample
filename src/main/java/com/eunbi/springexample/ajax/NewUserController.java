package com.eunbi.springexample.ajax;

import com.eunbi.springexample.mvc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/ajax/user")
@Controller
public class NewUserController {
    // 사용자 정보를 전달받고 저장하는 API

    @Autowired
    private UserService userService;

    @ResponseBody
    @PostMapping("/add")
    public Map<String, String> addUser(@RequestParam("name") String name
    , @RequestParam("birthday") String birthday
    , @RequestParam("email") String email
    , @RequestParam("introduce") String introduce) {

        int count = userService.createUser(name, birthday, email, introduce);

        Map<String, String> resultMap = new HashMap<>();

        if (count == 1) {
            resultMap.put("result", "success");
        } else {
            resultMap.put("result", "fail");
        }

        return resultMap;
    }


    @GetMapping("/form")
    public String userForm() {
        return "ajax/userForm";
    }


    // 전달받은 이메일 중복확인 API
    @ResponseBody
    @GetMapping("/duplicate-email")
    public Map<String,Boolean> isDuplicateEmail(@RequestParam("email") String email) {

        Map<String,Boolean> resultMap = new HashMap<>();


        if (userService.isDuplicateEmail(email)) {
            resultMap.put("isDuplicate", true);
        } else {
            resultMap.put("isDuplicate", false);
        }
        return resultMap;
    }





}
