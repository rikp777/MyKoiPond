package com.api.mykoipond.dao;


import com.api.mykoipond.domain.BreedEntity;
import com.api.mykoipond.domain.KoiParasiteEntity;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(
        path="KoiParasites",
        collectionResourceRel ="KoiParasites"
)
public interface KoiParasiteRepository extends CrudRepository<KoiParasiteEntity, Long>{
}
