package com.electricity.service;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class DefaultAuditorAwareService implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Spring Auditor");              //TODO Add user after Spring Security
    }
}
