package com.api.mykoipond.dao;

import com.api.mykoipond.domain.PondEntity;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(
        path="ponds",
        collectionResourceRel ="ponds"
)
public interface PondRepository extends CrudRepository<PondEntity, Long>{
}
