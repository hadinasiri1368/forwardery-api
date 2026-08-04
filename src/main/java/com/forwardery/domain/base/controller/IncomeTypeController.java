package com.forwardery.domain.base.controller;

import com.forwardery.constants.Consts;
import com.forwardery.controller.BaseController;
import com.forwardery.domain.base.dto.IncomeTypeDto;
import com.forwardery.domain.base.mapper.IncomeTypeMapper;
import com.forwardery.domain.base.model.IncomeType;
import com.forwardery.domain.base.repository.IncomeTypeRepository;
import com.forwardery.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(Consts.DEFAULT_PREFIX_API_URL + Consts.DEFAULT_VERSION_API_URL + "/base/incomeType")
public class IncomeTypeController extends BaseController<IncomeType, Long, IncomeTypeDto, IncomeTypeRepository> {

    public IncomeTypeController(BaseService<IncomeType,Long,IncomeTypeRepository> service, IncomeTypeMapper mapper) {
        super(service, mapper);
    }
}
