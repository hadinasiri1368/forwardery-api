package com.forwardery.domain.base.service;

import com.forwardery.domain.base.model.Route;
import com.forwardery.domain.base.repository.RouteRepository;
import com.forwardery.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class RouteService extends BaseService<Route, Long, RouteRepository> {
    protected RouteService(RouteRepository repository) {
        super(repository, Route.class);
    }
}
