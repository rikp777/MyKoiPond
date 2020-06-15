package com.api.mykoipond.dao;

import com.api.mykoipond.domain.BreedEntity;
import com.api.mykoipond.projections.BreedProjection;
import com.api.mykoipond.projections.PondProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;


@RepositoryRestResource(
        path="breeds",
        collectionResourceRel ="breeds",
        excerptProjection = BreedProjection.class
)
public interface BreedRepository extends CrudRepository<BreedEntity, Long>{
    Optional<BreedEntity> findByName(String name);

    @Query(
            value =     "select * \n" +
                            "from breeds b\n" +
                            "inner join subbreeds s on b.id = s.breed_id\n" +
                            "group by b.name\n" +
                            "having count(s.breed_id) > 5",
            nativeQuery = true
    )
    Set<BreedEntity> breedsWithCount();
}
