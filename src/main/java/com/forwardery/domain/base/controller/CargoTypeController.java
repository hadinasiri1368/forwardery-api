package com.forwardery.domain.base.controller;

import com.forwardery.constants.Consts;
import com.forwardery.controller.BaseController;
import com.forwardery.domain.base.dto.CargoTypeDto;
import com.forwardery.domain.base.mapper.CargoTypeMapper;
import com.forwardery.domain.base.model.CargoType;
import com.forwardery.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(Consts.DEFAULT_PREFIX_API_URL + Consts.DEFAULT_VERSION_API_URL + "/base/cargoType")
public class CargoTypeController extends BaseController<CargoType, Long, CargoTypeDto> {

    public CargoTypeController(BaseService<CargoType, Long> service, CargoTypeMapper mapper) {
        super(service, mapper);
    }
}
