package com.forwardery.controller;

import com.forwardery.exceptions.BaseException;
import com.forwardery.exceptions.GeneralExceptionType;
import com.forwardery.mapper.BaseMapper;
import com.forwardery.model.BaseEntity;
import com.forwardery.service.BaseService;
import com.forwardery.validator.NotEmpty;
import org.springframework.web.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

public abstract class BaseController<E, ID extends Serializable, D> {
    protected final BaseService<E, ID> service;
    protected final BaseMapper<E, D> mapper;

    public BaseController(BaseService<E, ID> service, BaseMapper<E, D> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping(path = "/add")
    public void insert(@RequestBody D dto) throws Exception {
        E e = mapper.toEntity(dto);
        ((BaseEntity) e).setId(null);
        service.save(e);
    }

    @PutMapping(path =  "/edit")
    public void edit(@RequestBody D dto) throws Exception {
        E e = mapper.toEntity(dto);
        if (((BaseEntity) e).getId() == null)
            throw new BaseException(GeneralExceptionType.FIELD_NOT_VALID, new Object[]{"id"});
        service.save(e);
    }

    @DeleteMapping(path = "/remove/{id}")
    public void remove(@PathVariable @NotEmpty(fieldName = "id") ID id) throws Exception {
        service.deleteById(id);
    }

    @GetMapping(path = "/{id}")
    public D find(@PathVariable("id") ID id) {
        E e = service.findById(id);
        return mapper.toDto(e);
    }

    @GetMapping
    public List<D> findAll() {
        List<E> list = service.findAll();
        return mapper.toDtoList(list);
    }
}