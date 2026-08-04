package com.forwardery.domain.base.controller;

import com.forwardery.constants.Consts;
import com.forwardery.controller.BaseController;
import com.forwardery.domain.base.dto.ServiceTypeDto;
import com.forwardery.domain.base.mapper.ServiceTypeMapper;
import com.forwardery.domain.base.model.ServiceType;
import com.forwardery.domain.base.repository.ServiceTypeRepository;
import com.forwardery.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(Consts.DEFAULT_PREFIX_API_URL + Consts.DEFAULT_VERSION_API_URL + "/base/serviceType")
public class ServiceTypeController extends BaseController<ServiceType, Long, ServiceTypeDto, ServiceTypeRepository> {

    public ServiceTypeController(BaseService<ServiceType,Long, ServiceTypeRepository> service, ServiceTypeMapper mapper) {
        super(service, mapper);
    }
}
