package com.forwardery.domain.base.service;

import com.forwardery.domain.base.model.CostType;
import com.forwardery.domain.base.repository.CostTypeRepository;
import com.forwardery.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CostTypeService extends BaseService<CostType, Long, CostTypeRepository> {
    protected CostTypeService(CostTypeRepository repository) {
        super(repository, CostType.class);
    }
}
