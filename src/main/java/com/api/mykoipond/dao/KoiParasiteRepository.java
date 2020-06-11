package com.api.mykoipond.dao;


import com.api.mykoipond.domain.BreedEntity;
import com.api.mykoipond.domain.KoiParasiteEntity;
import com.api.mykoipond.projections.KoiParasiteProjection;
import com.api.mykoipond.projections.PondProjection;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(
        path="KoiParasites",
        collectionResourceRel ="KoiParasites",
        excerptProjection = KoiParasiteProjection.class
)
public interface KoiParasiteRepository extends CrudRepository<KoiParasiteEntity, Long>{
}
