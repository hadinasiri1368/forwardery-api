package com.forwardery.domain.base.service;

import com.forwardery.domain.base.model.Unit;
import com.forwardery.domain.base.repository.UnitRepository;
import com.forwardery.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class UnitService extends BaseService<Unit, Long, UnitRepository> {

    protected UnitService(UnitRepository repository) {
        super(repository, Unit.class);
    }
}
