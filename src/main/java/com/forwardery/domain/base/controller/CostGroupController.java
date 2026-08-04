package com.forwardery.domain.base.controller;

import com.forwardery.constants.Consts;
import com.forwardery.controller.BaseController;
import com.forwardery.domain.base.dto.CostGroupDto;
import com.forwardery.domain.base.mapper.CostGroupMapper;
import com.forwardery.domain.base.model.CostGroup;
import com.forwardery.domain.base.repository.CostGroupRepository;
import com.forwardery.service.BaseService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(Consts.DEFAULT_PREFIX_API_URL + Consts.DEFAULT_VERSION_API_URL + "/base/costGroup")
public class CostGroupController extends BaseController<CostGroup, Long, CostGroupDto, CostGroupRepository> {

    public CostGroupController(BaseService<CostGroup,Long,CostGroupRepository> service, CostGroupMapper mapper) {
        super(service, mapper);
    }
}
