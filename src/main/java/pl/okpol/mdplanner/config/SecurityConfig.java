package pl.okpol.mdplanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.okpol.mdplanner.repositories.IAuthenticationFacade;
import pl.okpol.mdplanner.repositories.UserRepository;

import javax.sql.DataSource;

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
                .formLogin()
                .loginPage("/logowanie")
                .usernameParameter("email")
                .passwordParameter("password")
                .and().logout()
                //and wracamy do konfiguracji ogólnej
                .and().csrf().disable()
                //wyłączamy analizę csrf
                .authorizeRequests()
                //autoryzacja dostępu w tym wypadku dla wszystkich
                .antMatchers("/rejestracja").permitAll()
                .antMatchers("/logowanie").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                // wyciągamy role z bazy jeśli chcemy ograniczyć dostęp względem ról (role są najczęściej osobną tabelą ROLE_ADMIN nazwa z bazy danych
                .anyRequest().authenticated();
        //robić na końcu bo to idzie od góry (powyższe wykluczają to wymuszenie autoryzacji).
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }
}
