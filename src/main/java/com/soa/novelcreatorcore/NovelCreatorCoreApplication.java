package com.soa.novelcreatorcore;

import com.soa.novelcreatorcore.repository.model.Role;
import com.soa.novelcreatorcore.repository.model.RoleName;
import com.soa.novelcreatorcore.repository.service.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:application-production.yml")
})
public class NovelCreatorCoreApplication implements CommandLineRunner {
    @Autowired
    private RoleRepository roleRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(NovelCreatorCoreApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (RoleName value : RoleName.values()) {
            roleRepository.insert(Role.builder().roleName(value).build());
        }
    }
}
