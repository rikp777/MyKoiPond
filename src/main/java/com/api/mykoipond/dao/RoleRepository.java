package com.api.mykoipond.dao;

import com.api.mykoipond.domain.PondEntity;
import com.api.mykoipond.domain.RoleEntity;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
        path="roles",
        collectionResourceRel ="roles"
)
public interface RoleRepository extends CrudRepository<RoleEntity, Long>{
    RoleEntity findByName(String name);
}
