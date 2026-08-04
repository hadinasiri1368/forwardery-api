package com.forwardery.domain.base.service;

import com.forwardery.domain.base.model.Station;
import com.forwardery.domain.base.repository.StationRepository;
import com.forwardery.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class StationService extends BaseService<Station, Long, StationRepository> {

    protected StationService(StationRepository repository) {
        super(repository, Station.class);
    }
}
