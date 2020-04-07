package com.api.mykoipond.dao;


import com.api.mykoipond.domain.BreedEntity;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path="sizes")
public interface SizeRepository extends CrudRepository<BreedEntity, Long>{
}
