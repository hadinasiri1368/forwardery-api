package com.forwardery.domain.base.controller;

import com.forwardery.constants.Consts;
import com.forwardery.controller.BaseController;
import com.forwardery.domain.base.dto.CostTypeDto;
import com.forwardery.domain.base.mapper.CostTypeMapper;
import com.forwardery.domain.base.model.CostType;
import com.forwardery.domain.base.repository.CostTypeRepository;
import com.forwardery.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(Consts.DEFAULT_PREFIX_API_URL + Consts.DEFAULT_VERSION_API_URL + "/base/costType")
public class CostTypeController extends BaseController<CostType, Long, CostTypeDto, CostTypeRepository> {

    public CostTypeController(BaseService<CostType,Long,CostTypeRepository> service, CostTypeMapper mapper) {
        super(service, mapper);
    }
}
