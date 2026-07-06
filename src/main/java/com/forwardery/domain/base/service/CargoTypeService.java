package com.forwardery.domain.base.service;

import com.forwardery.domain.base.model.CargoType;
import com.forwardery.domain.base.repository.CargoTypeRepository;
import com.forwardery.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CargoTypeService extends BaseService<CargoType, Long, CargoTypeRepository> {

    protected CargoTypeService(CargoTypeRepository repository) {
        super(repository, CargoType.class);
    }
}
