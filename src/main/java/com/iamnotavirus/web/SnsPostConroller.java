package com.iamnotavirus.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class SnsPostConroller {
    @RequestMapping("/post/sns/kakao")
    public String kakao(){
        String response = "";
        //친구 목록 먼저 확인
        //형식맞춰 api post
        return response;
    }
}
