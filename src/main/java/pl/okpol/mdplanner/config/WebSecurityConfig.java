package pl.okpol.mdplanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//dodane do konfiguracji spring boota
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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
