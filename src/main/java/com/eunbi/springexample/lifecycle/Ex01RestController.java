package com.eunbi.springexample.lifecycle;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lifecycle/ex01")
// restcontroller가 일반 컨트롤러와 다른 점 : responsebody 어노테이션까지 가지고 있는 컨트롤러로, responsebody 기반으로만 작성되는
// 클래스의 경우에 사용함. 그럼 response body 어노테이션을 따로 안 붙여줘도 됨
public class Ex01RestController {
    // 직접 만든 Class 객체 response 에 담는 페이지
    @RequestMapping("/3")
    public Person personResponse() {
        Person me = new Person("이은비", 23);

        return me;
    }

    // Status code 를 수정한 response 만들기
    // Status code 란 서버에서 미리 정해진 코드를 통해 요청이 어떻게 수리되는지 보여주는 것.
    // HTTP Status code라고 서치하면 종류를 확인 가능함
    // error 에 대한 스테이터스 코드를 보고 문제상황에서 트러블슈팅이 가능함


    @RequestMapping("/4")
    public ResponseEntity<Person> statusResponse() {
        Person me = new Person("이은비", 23);
        ResponseEntity<Person> entity = new ResponseEntity<>(me, HttpStatus.INTERNAL_SERVER_ERROR);

        return entity;
    }

}
