package io.github.azagniotov.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountServiceConfig {

    private final String accountResource;
    private String accountServiceHost;
    private Integer accountServicePort;

    public AccountServiceConfig(@Value("${service.account.host}") final String accountServiceHost,
                                @Value("${service.account.port}") final Integer accountServicePort,
                                @Value("${service.account.resource}") final String accountResource) {
        this.accountServiceHost = accountServiceHost;
        this.accountServicePort = accountServicePort;
        this.accountResource = accountResource;
    }

    public String getAccountServiceHost() {
        return accountServiceHost;
    }

    public Integer getAccountServicePort() {
        return accountServicePort;
    }

    public String getAccountResource() {
        return accountResource;
    }
}
