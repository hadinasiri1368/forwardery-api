package com.forwardery.domain.base.controller;

import com.forwardery.constants.Consts;
import com.forwardery.controller.BaseController;
import com.forwardery.domain.base.dto.RouteDto;
import com.forwardery.domain.base.mapper.RouteMapper;
import com.forwardery.domain.base.model.Route;
import com.forwardery.domain.base.repository.RouteRepository;
import com.forwardery.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(Consts.DEFAULT_PREFIX_API_URL + Consts.DEFAULT_VERSION_API_URL + "/base/route")
public class RouteController extends BaseController<Route, Long, RouteDto, RouteRepository> {

    public RouteController(BaseService<Route,Long,RouteRepository> service, RouteMapper mapper) {
        super(service, mapper);
    }
}
