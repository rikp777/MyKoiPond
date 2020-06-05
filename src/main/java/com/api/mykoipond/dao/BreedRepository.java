package com.api.mykoipond.dao;

import com.api.mykoipond.domain.BreedEntity;
import com.api.mykoipond.projections.BreedProjection;
import com.api.mykoipond.projections.PondProjection;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@RepositoryRestResource(
        path="breeds",
        collectionResourceRel ="breeds",
        excerptProjection = BreedProjection.class
)
public interface BreedRepository extends CrudRepository<BreedEntity, Long>{
    Optional<BreedEntity> findByName(String name);
}
