package io.github.azagniotov.example.service;

import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import io.github.azagniotov.example.config.AccountServiceConfig;
import io.github.azagniotov.example.config.JacksonConfig;
import io.github.azagniotov.example.controller.WebServiceException;
import io.github.azagniotov.example.io.HttpUtils;
import io.github.azagniotov.example.model.Account;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AccountServiceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceService.class);

    private final AccountServiceConfig accountServiceConfig;

    public AccountServiceService(final AccountServiceConfig accountServiceConfig) {
        this.accountServiceConfig = accountServiceConfig;
    }

    Account get(final Long id) throws IOException {

        final String requestUrl = String.format("%s:%s/%s/%s",
                accountServiceConfig.getAccountServiceHost(),
                accountServiceConfig.getAccountServicePort(),
                accountServiceConfig.getAccountResource(),
                id);

        LOGGER.info("Hitting Account on {}", requestUrl);

        final HttpRequest request = HttpUtils.constructHttpRequest(HttpMethods.GET, requestUrl);
        final HttpResponse response = request.execute();

        if (response.getStatusCode() == HttpStatus.SC_OK) {
            return JacksonConfig.OBJECT_MAPPER.readValue(response.parseAsString().trim(), Account.class);
        } else {
            throw new WebServiceException(response.parseAsString().trim());
        }
    }
}
