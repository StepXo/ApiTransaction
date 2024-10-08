package com.emazon.ApiTransaction.Infrastructure.Configuration;

import com.emazon.ApiTransaction.Infrastructure.Adapters.Utils.UserExtractor;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class FeignConfiguration {
    private final UserExtractor userExtractor;
    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                String token = "Bearer " + userExtractor.getTokenFromRequest();
                template.header("Authorization", token);
            }
        };
    }
}
