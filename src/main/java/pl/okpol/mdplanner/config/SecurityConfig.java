package pl.okpol.mdplanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import pl.okpol.mdplanner.repositories.IAuthenticationFacade;
import pl.okpol.mdplanner.repositories.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final IAuthenticationFacade authenticationFacade;
    private final UserRepository userRepository;

    public SecurityConfig(DataSource dataSource, IAuthenticationFacade authenticationFacade, UserRepository userRepository) {
        this.dataSource = dataSource;
        this.authenticationFacade = authenticationFacade;
        this.userRepository = userRepository;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT email, password, true FROM users WHERE email = ?")
                .authoritiesByUsernameQuery("SELECT email, role FROM users WHERE email = ?")
                .rolePrefix("");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/logowanie").permitAll()
                .antMatchers("/rejestracja").permitAll()
                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/logowanie")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override

                    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, httpServletRequest.getRequestURI());

//                        if (!(authentication instanceof AnonymousAuthenticationToken)) {
//                            Long userId = userRepository.getUserByEmail(authentication.getName()).getId();
//                            String userRole = userRepository.getUserByEmail(authentication.getName()).getRole();
//                            if (userRole.equals("admin")) {
//                                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/admin/" + userId);
//                            } else {
//                                redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/moje-konto/" + userId);
//                            }
//                            //dostęp do użytkownika lub admina
//                        } else {
//                            redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/login");
//                        }
                    }

                    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
                })
                .and().logout()
                .and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
