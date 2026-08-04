package com.forwardery.domain.base.repository;

import com.forwardery.domain.base.model.CostGroup;
import com.forwardery.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostGroupRepository extends BaseRepository<CostGroup, Long> {
}
