package com.forwardery.domain.base.controller;

import com.forwardery.constants.Consts;
import com.forwardery.controller.BaseController;
import com.forwardery.domain.base.dto.CurrencyTypeDto;
import com.forwardery.domain.base.model.CurrencyType;
import com.forwardery.domain.base.repository.CurrencyTypeRepository;
import com.forwardery.mapper.BaseMapper;
import com.forwardery.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(Consts.DEFAULT_PREFIX_API_URL + Consts.DEFAULT_VERSION_API_URL + "/base/currencyType")
public class CurrencyTypeController extends BaseController<CurrencyType,Long, CurrencyTypeDto,CurrencyTypeRepository> {

    public CurrencyTypeController(BaseService<CurrencyType, Long, CurrencyTypeRepository> service, BaseMapper<CurrencyType, CurrencyTypeDto> mapper) {
        super(service, mapper);
    }
}
