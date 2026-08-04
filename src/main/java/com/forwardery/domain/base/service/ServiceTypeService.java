package com.forwardery.domain.base.service;

import com.forwardery.domain.base.model.ServiceType;
import com.forwardery.domain.base.repository.ServiceTypeRepository;
import com.forwardery.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeService extends BaseService<ServiceType, Long, ServiceTypeRepository> {

    protected ServiceTypeService(ServiceTypeRepository repository) {
        super(repository, ServiceType.class);
    }
}
