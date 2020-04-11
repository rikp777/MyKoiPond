package com.api.mykoipond.dao;


import com.api.mykoipond.domain.SubBreedEntity;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RepositoryRestResource(
        path="subbreeds"
//        collectionResourceRel = "subbreeds"
)
public interface SubBreedRepository extends CrudRepository<SubBreedEntity, Long>{
    Optional<SubBreedEntity> findByName(String name);
}
