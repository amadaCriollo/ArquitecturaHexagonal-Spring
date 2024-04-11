package com.bi.account.hexagonal.infrastructure.config;

import com.bi.account.hexagonal.application.services.AccountMovementeService;
import com.bi.account.hexagonal.application.services.AccountService;
import com.bi.account.hexagonal.application.services.CustomerService;
import com.bi.account.hexagonal.domain.port.AccountMovementPort;
import com.bi.account.hexagonal.domain.port.AccountPort;
import com.bi.account.hexagonal.domain.port.CustomerPort;
import com.bi.account.hexagonal.infrastructure.adapters.security.InfoAdditionalToken;
import com.bi.account.hexagonal.infrastructure.adapters.service.IuserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public AccountService accountService(AccountPort accountPort) {
        return new AccountService(accountPort);
    }

    @Bean
    public CustomerService customerService(CustomerPort customerPort) {
        return new CustomerService(customerPort);
    }

   @Bean
    public AccountMovementeService accountMovementeService(AccountMovementPort accountMovementPort){
        return new AccountMovementeService(accountMovementPort);
    }

    @Bean
    public InfoAdditionalToken iuserService(IuserService iuserService){
        return new InfoAdditionalToken(iuserService);
    }
}
