package com.forwardery.domain.base.service;

import com.forwardery.domain.base.model.CostGroup;
import com.forwardery.domain.base.repository.CostGroupRepository;
import com.forwardery.service.BaseService;
import org.springframework.stereotype.Service;

@Service
public class CostGroupService extends BaseService<CostGroup, Long, CostGroupRepository> {

    protected CostGroupService(CostGroupRepository repository) {
        super(repository, CostGroup.class);
    }
}
