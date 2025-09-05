package com.springboot.project.cruddemo.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );


        return jdbcUserDetailsManager;
    }


    // removing hard coded data

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails jhon = User.builder()
                .username("jhon")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("MANAGER","EMPLOYEE")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(jhon, mary, susan);
    }

    */

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configure ->
            configure.requestMatchers(HttpMethod.GET, "/api/members").hasRole("EMPLOYEE")
                     .requestMatchers(HttpMethod.GET, "/api/members/**").hasRole("EMPLOYEE")
                     .requestMatchers(HttpMethod.POST, "/api/members").hasRole("MANAGER")
                     .requestMatchers(HttpMethod.PUT, "/api/members").hasRole("MANAGER")
                     .requestMatchers(HttpMethod.DELETE, "/api/members").hasRole("ADMIN")
                     .requestMatchers(HttpMethod.DELETE, "/api/members/**").hasRole("ADMIN"));

        http.httpBasic();
        // http.httpBasic();  // depricated

        // CSRF is not required for REST API
         http.csrf().disable(); // depricated

        return http.build();

    }



}
