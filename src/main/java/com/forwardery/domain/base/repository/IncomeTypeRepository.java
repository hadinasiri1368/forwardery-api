package com.forwardery.domain.base.repository;

import com.forwardery.domain.base.model.IncomeType;
import com.forwardery.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeTypeRepository extends BaseRepository<IncomeType, Long> {
}
