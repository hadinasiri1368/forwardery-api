package com.forwardery.domain.base.controller;

import com.forwardery.constants.Consts;
import com.forwardery.controller.BaseController;
import com.forwardery.domain.base.dto.UnitDto;
import com.forwardery.domain.base.mapper.UnitMapper;
import com.forwardery.domain.base.model.Unit;
import com.forwardery.domain.base.repository.UnitRepository;
import com.forwardery.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(Consts.DEFAULT_PREFIX_API_URL + Consts.DEFAULT_VERSION_API_URL + "/base/unit")
public class UnitController extends BaseController<Unit, Long, UnitDto, UnitRepository> {

    public UnitController(BaseService<Unit,Long,UnitRepository> service, UnitMapper mapper) {
        super(service, mapper);
    }
}
