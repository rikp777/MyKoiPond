package com.api.mykoipond.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface CrudRepository<T, ID> extends JpaRepository<T, ID> {
    Optional<T> findByUid(UUID uid);
}
