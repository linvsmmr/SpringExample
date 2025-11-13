package com.eunbi.springexample.mvc;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/mvc/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // 가장 최근 등록된 사용자 정보를 html로 구성해서 보여주기

    @GetMapping("info")
    public String userInfo(Model model) {
//        return "mvc/userInfo";


        User user = userService.getLastUser();

        model.addAttribute("title", "최근 등록 사용자");
        model.addAttribute("result", user);

        return "mvc/userInfo";

    }

    @ResponseBody
    @PostMapping("add")
    public String addUser(
            @RequestParam("name") String name,
            @RequestParam("birthday") String birthday,
            @RequestParam("email") String email,
            @RequestParam(value = "introduce", required = false) String introduce) {

        int count = userService.createUser(name,birthday,email,introduce);

        return "추가 완료 : " + count;
    }

    @GetMapping("/form")
    public String userForm() {
        return "mvc/userForm";
    }




}
