package com.api.mykoipond.dao;

import com.api.mykoipond.domain.ParasiteEntity;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(
        path="parasites",
        collectionResourceRel ="parasites"
)
public interface ParasiteRepository extends CrudRepository<ParasiteEntity, Long> {
}
