package com.forwardery.domain.base.controller;

import com.forwardery.constants.Consts;
import com.forwardery.controller.BaseController;
import com.forwardery.domain.base.dto.StationDto;
import com.forwardery.domain.base.mapper.StationMapper;
import com.forwardery.domain.base.model.Station;
import com.forwardery.domain.base.repository.StationRepository;
import com.forwardery.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(Consts.DEFAULT_PREFIX_API_URL + Consts.DEFAULT_VERSION_API_URL + "/base/station")
public class StationController extends BaseController<Station, Long, StationDto, StationRepository> {

    public StationController(BaseService<Station,Long,StationRepository> service, StationMapper mapper) {
        super(service, mapper);
    }
}
