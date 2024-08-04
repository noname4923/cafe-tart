package com.cafe.tart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class TilesConfig {

	@Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions("classpath:/tiles/tiles-defs.xml");
        tilesConfigurer.setCheckRefresh(true);
        
        System.out.println("TilesConfigurer 설정 완료");
        
        return tilesConfigurer;
    }

    @Bean
    public TilesViewResolver tilesViewResolver() {
        return new TilesViewResolver();
    }
}
