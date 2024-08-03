package com.blog.nta.api.chatGpt;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class GPTSvc {

    @Value("${openai.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getResponse(String prompt) {
        String url = "https://api.openai.com/v1/chat/completions";
        
        HttpHeaders headers = new HttpHeaders();
        /*
         * Bearer 토큰은 OAuth 2.0 인증 방식 중 하나로, 서버에 접근할 수 있는 권한을 나타내는 토큰
         * OpenAI API를 사용할 때는 이 토큰을 사용해서 인증을 진행
         */
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Content-Type", "application/json");

        ReqVO request = new ReqVO();
        request.setPrompt(prompt);

        HttpEntity<ReqVO> entity = new HttpEntity<>(request, headers);

        int retryCount = 0;
        int maxRetries = 3; // 최대 재시도 횟수
        while (retryCount < maxRetries) {
            try {
                ResponseEntity<ResVO> response = restTemplate.exchange(url, HttpMethod.POST, entity, ResVO.class);
                
                System.out.println("[GPTSvc] Response : "+response);
                
                return response.getBody().getChoices().get(0).getText();
            } catch (HttpClientErrorException.TooManyRequests e) {
                retryCount++;
                try {
                	System.out.println("[GPTSvc] 3초마다 재 진입 COUNT : "+retryCount);
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    return "Error: 재시도를 기다리는 동안 중단되었습니다.";
                }
                System.out.println("[GPTSvc] Exception : "+e.getMessage());
            }
        }
       
        return "Error: 최대 재시도 횟수를 초과했습니다.";
    }
}
