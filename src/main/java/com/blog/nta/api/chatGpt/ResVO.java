package com.blog.nta.api.chatGpt;

import java.util.List;

import lombok.Data;

@Data
public class ResVO {
    private List<Choice> choices;

    @Data
    public static class Choice {
        private String text;
    }
}