package com.forwardery.domain.base.service;

import com.forwardery.domain.base.model.CurrencyType;
import com.forwardery.domain.base.repository.CurrencyTypeRepository;
import com.forwardery.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyTypeService extends BaseService<CurrencyType, Long, CurrencyTypeRepository> {
    protected CurrencyTypeService(CurrencyTypeRepository repository) {
        super(repository,CurrencyType.class);
    }
}
