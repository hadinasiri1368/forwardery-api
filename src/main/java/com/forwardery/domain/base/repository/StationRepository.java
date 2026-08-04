package com.forwardery.domain.base.repository;

import com.forwardery.domain.base.model.Station;
import com.forwardery.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends BaseRepository<Station, Long> {
}
