package com.forwardery.domain.base.repository;

import com.forwardery.domain.base.model.CostType;
import com.forwardery.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostTypeRepository extends BaseRepository<CostType, Long> {
}
