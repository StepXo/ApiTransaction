package com.emazon.ApiTransaction.Infrastructure.Adapters.Utils;

import com.emazon.ApiTransaction.Domain.Spi.UserJwtPort;
import com.emazon.ApiTransaction.Infrastructure.Adapters.SecurityConfig.JwtSecurity.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@AllArgsConstructor
public class UserExtractor implements UserJwtPort {
    private final JwtService jwtService;
    @Override
    public String extractUserId() {
        String token = getTokenFromRequest();
        return token != null ? jwtService.extractUserId(token) : null;
    }

    public String getTokenFromRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            String authHeader = request.getHeader("Authorization");
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                return authHeader.substring(7);
            }
        }
        return null;
    }
}
