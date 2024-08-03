package com.blog.nta.api.chatGpt;

import lombok.Data;

@Data
public class ReqVO {
    private String model = "babbage-002";
    private String prompt;
    private int max_tokens = 100;
}