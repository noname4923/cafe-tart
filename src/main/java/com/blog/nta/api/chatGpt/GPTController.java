package com.blog.nta.api.chatGpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gpt")
public class GPTController {

    @Autowired
    private GPTSvc gptSvc;

    @GetMapping("/ask")
    public String ask(@RequestParam String keyword) {
        return gptSvc.getResponse(keyword);
    }
}