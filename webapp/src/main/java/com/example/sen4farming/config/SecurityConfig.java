package com.example.sen4farming.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.core.GrantedAuthorityDefaults;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@Configuration
public class SecurityConfig {

    /**
     * The User details service.
     */
    @Autowired
    public UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(encoder);
        return authenticationProvider;
    }

    @Autowired
    private BCryptPasswordEncoder encoder;

    /*

    https://stackoverflow.com/questions/75080739/spring-security-6-post-requests-are-unauthorised-with-permitall
https://stackoverflow.com/questions/28907030/spring-security-authorize-request-for-certain-url-http-method-using-httpsecu
https://www.baeldung.com/spring-security-csrf
     */



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin(form -> form
                        .loginPage("/usuarios/login")
                        .failureUrl("/login-error")
                        .defaultSuccessUrl("/",true)
                        .permitAll()
                );
        http.logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/logout/msg")
                        .invalidateHttpSession(true)

                        /*.logoutSuccessHandler(logoutSuccessHandler)
                        .deleteCookies(cookieNamesToClear)
                        .addLogoutHandler(logoutHandler)
                        */
                );
        http.authorizeHttpRequests()
                .requestMatchers("/js/**").permitAll()
                .requestMatchers("/userguide/**").permitAll()
                .requestMatchers("/openlayer/**").permitAll()
                .requestMatchers("/node_modules/**").permitAll()
                .requestMatchers("/data/**").permitAll()
                .requestMatchers("/img/**").permitAll()
                .requestMatchers("/files/**").permitAll()
                .requestMatchers("/userfiles/**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/fonts/**").permitAll()
                .requestMatchers("/lib/**").permitAll()
                //Aqui se meten las direcciones del controlador que no requieren logi.
                .requestMatchers("/","","/usuarios/registro","/usuarios/login",
                        "/usuarios/hasOlvidadoTuPassword","/usuarios/resetpass/**",
                        "/project","/privacy","/termsandconditions","/logout/msg").permitAll()
                .requestMatchers("/demogeneral/**").permitAll()
                .requestMatchers("/userguide/ctr/**").permitAll()
                //Aqui se meten las direcciones del controlador que  requieren ser admin.
                //.requestMatchers("/galeria/{id}","/galeria/embed/{id}").hasAuthority("ROLE_ADMIN")
                .requestMatchers( HttpMethod.POST,"/**").permitAll()
                .anyRequest().authenticated()


                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied")

                .and()
                .csrf().disable()
                .cors().disable()
                .authenticationProvider(authenticationProvider());

        return http.build();

    }


    @Bean
    static GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("ROLE_");
    }

    /*
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    */



}