package com.forwardery.domain.base.repository;

import com.forwardery.domain.base.model.ServiceType;
import com.forwardery.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends BaseRepository<ServiceType, Long> {
}
