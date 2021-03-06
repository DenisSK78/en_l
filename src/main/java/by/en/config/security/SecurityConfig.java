package by.en.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                .antMatchers("/model").authenticated()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .and()
                    .formLogin()
                        .loginProcessingUrl("/loginUrl")
                        .loginPage("/login")
                        .defaultSuccessUrl("/model")
                .and()
//                .csrf().disable()//don't use get
                .logout()
                    .logoutUrl("demo")
                .and()
                    .userDetailsService(userDetailsService);


    }
}
