package com.forwardery.domain.base.repository;

import com.forwardery.domain.base.model.Unit;
import com.forwardery.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends BaseRepository<Unit, Long> {
}
