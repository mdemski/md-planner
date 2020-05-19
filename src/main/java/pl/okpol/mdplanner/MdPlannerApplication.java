package pl.okpol.mdplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class MdPlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MdPlannerApplication.class, args);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    public static final DateTimeFormatter FORMATTER = ofPattern("MM/dd/yyyy");
//
//    @Bean
//    @Primary
//    public ObjectMapper serializingObjectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        JavaTimeModule javaTimeModule = new JavaTimeModule();
//        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer());
//        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer());
//        objectMapper.registerModule(javaTimeModule);
//        return objectMapper;
//    }
}
