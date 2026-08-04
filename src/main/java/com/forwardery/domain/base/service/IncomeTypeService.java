package com.forwardery.domain.base.service;

import com.forwardery.domain.base.model.IncomeType;
import com.forwardery.domain.base.repository.IncomeTypeRepository;
import com.forwardery.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class IncomeTypeService extends BaseService<IncomeType, Long, IncomeTypeRepository> {

    protected IncomeTypeService(IncomeTypeRepository repository) {
        super(repository, IncomeType.class);
    }
}
