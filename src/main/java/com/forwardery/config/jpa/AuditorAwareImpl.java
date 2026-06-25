package com.forwardery.config.jpa;

import com.forwardery.config.security.RequestContext;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditorProvider")
public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {

        return Optional.of(RequestContext.getUserId());
    }
}

