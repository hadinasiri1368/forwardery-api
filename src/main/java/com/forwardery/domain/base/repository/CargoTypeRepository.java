package com.forwardery.domain.base.repository;

import com.forwardery.domain.base.model.CargoType;
import com.forwardery.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoTypeRepository extends BaseRepository<CargoType, Long> {
}
