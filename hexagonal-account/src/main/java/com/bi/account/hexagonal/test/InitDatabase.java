package com.bi.account.hexagonal.test;

import com.bi.account.hexagonal.infrastructure.repositories.JpaAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitDatabase {

    @Autowired
    private JpaAccountRepository jpaAccountRepository;

   /* @Bean
    public CommandLineRunner testAccountMapperCommand(){
        return args -> {
            List<AccountEntity> accountList = jpaAccountRepository.findAll();
            System.out.println("Accounts-->" + accountList.size());

            accountList.forEach(System.out::println);
        };
    }*/
}
