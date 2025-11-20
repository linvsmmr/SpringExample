package com.eunbi.springexample.ajax;

import com.eunbi.springexample.mvc.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/ajax")
@Controller
public class NewUserController {
    // 사용자 정보를 전달받고 저장하는 API

    private UserService userService;

    @PostMapping("/user/add")
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


    @GetMapping("/user/form")
    public String userForm() {
        return "ajax/userForm";
    }

}
