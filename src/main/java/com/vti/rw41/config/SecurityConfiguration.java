package com.vti.rw41.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration {

    @Bean
    @Primary
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() //để tách lỗi 403
                .cors().disable()  // để wep gọi được API
                .authorizeHttpRequests(auth -> auth
                        .antMatchers("/swagger-ui/**",
                                "/accounts/register",
                                "v3/api-docs",
                                "v3/api-docs/**").permitAll() // cho phép các URL có parttern như trên truy cập không cần authentication
                        .antMatchers(HttpMethod.GET, "/products", "/products/**").permitAll()
                        // cho phép các URL có methor GET truy cập vào không cần authentication
                        .anyRequest().authenticated()  // các URL còn lại phải xác thực authentication
                ).httpBasic(Customizer.withDefaults());
        return http.build();
    }


}
