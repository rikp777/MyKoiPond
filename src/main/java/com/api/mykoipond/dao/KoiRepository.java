package com.api.mykoipond.dao;

import com.api.mykoipond.domain.BreedEntity;
import com.api.mykoipond.domain.KoiEntity;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(
        path="kois",
        collectionResourceRel ="kois"
)
public interface KoiRepository extends CrudRepository<KoiEntity, Long>{
}
