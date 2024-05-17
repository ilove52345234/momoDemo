package com.momo.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
        users.createUser(User.withUsername("romin").password("{noop}momo").roles("admin").build());
        users.createUser(User.withUsername("user").password("{noop}pass").roles("admin").build());
        return users;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests ->
                        requests.anyRequest().authenticated() // 所有请求需要身份验证
                ).formLogin(withDefaults()).csrf(AbstractHttpConfigurer::disable);
//        http.sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .csrf().disable()
//                .formLogin().disable()
//                .authorizeRequests()
//                .antMatchers(HEALTH_PATTERN).permitAll()
//                .antMatchers(ROOT_PATTERN)
//                .hasAnyAuthority(JasmineUserDetails.ALLOW_S);
        return http.build();
    }



}
