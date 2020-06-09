package com.api.mykoipond.projections;

import com.api.mykoipond.domain.BreedEntity;
import com.api.mykoipond.domain.SubBreedEntity;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

//https://stackoverflow.com/questions/46977974/how-can-i-return-multi-level-json-using-hibernate-jpa-in-spring-boot
@Projection(name = "inlineSubBreeds", types = { SubBreedEntity.class })
public interface SubBreedProjection {
    String getName();
    String getDescription();
}
