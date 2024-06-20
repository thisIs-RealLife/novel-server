package com.soa.novelcreatorcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:application-production.yml")
})
public class NovelCreatorCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelCreatorCoreApplication.class, args);
    }

}
