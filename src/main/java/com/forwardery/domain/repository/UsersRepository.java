package com.forwardery.domain.repository;


import com.forwardery.model.Users;
import com.forwardery.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends BaseRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
