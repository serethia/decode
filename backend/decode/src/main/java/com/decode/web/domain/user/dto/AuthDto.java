package com.decode.web.domain.user.dto;

import lombok.*;


public class AuthDto {
    @Getter
    @NoArgsConstructor

    public static class LoginDto{
        private String email;
        private String password;
        @Builder
        public LoginDto(String email, String password){
            this.email = email;
            this.password = password;
        }
    }

    @Getter
    @NoArgsConstructor
    public static class TokenDto{
        private String accessToken;
        private String refreshToken;
        @Builder
        public TokenDto(String accessToken, String refreshToken){
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }
    }

}
