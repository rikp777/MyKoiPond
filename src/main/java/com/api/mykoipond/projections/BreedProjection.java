package com.api.mykoipond.projections;

import com.api.mykoipond.domain.BreedEntity;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "withbreed", types = { BreedEntity.class

})
public interface BreedProjection {
    String getName();
}
