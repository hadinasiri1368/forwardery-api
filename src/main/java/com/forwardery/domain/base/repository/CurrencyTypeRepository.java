package com.forwardery.domain.base.repository;

import com.forwardery.domain.base.model.CurrencyType;
import com.forwardery.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyTypeRepository extends BaseRepository<CurrencyType,Long> {
}
