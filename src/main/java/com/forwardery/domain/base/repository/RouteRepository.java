package com.forwardery.domain.base.repository;

import com.forwardery.domain.base.model.Route;
import com.forwardery.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends BaseRepository<Route, Long> {
}
