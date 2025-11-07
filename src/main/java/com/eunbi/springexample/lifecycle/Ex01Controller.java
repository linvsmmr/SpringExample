package com.eunbi.springexample.lifecycle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Ex01Controller {
    // 간단한 html 을 담은 페이지
    @ResponseBody
    @RequestMapping("/lifecycle/ex01/1")
    public String htmlResponse() {
        return "<html>\n" +
                "   <head><title>Spring</title></head>\n" +
                "   <body>\n" +
                "       <h2>Spring HTML Response</h2>" +
                "   </body>\n" +
                "</html>";
    }

    // Map을 response에 담는 페이지
    @ResponseBody
    @RequestMapping("/lifecycle/ex01/2")
    public Map<String, Integer> mapResponse() {
        Map<String, Integer> fruitMap = new HashMap<>();

        fruitMap.put("apple",1500);
        fruitMap.put("banana",2500);
        fruitMap.put("orange",1300);

        return fruitMap;

    }
}
