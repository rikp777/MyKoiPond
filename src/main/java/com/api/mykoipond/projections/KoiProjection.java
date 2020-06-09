package com.api.mykoipond.projections;

import com.api.mykoipond.domain.KoiEntity;
import com.api.mykoipond.domain.SubBreedEntity;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "inlineKois", types = { KoiEntity.class })
public interface KoiProjection {
    String getName();
    String getDescription();
    Date getBirth();
    String getSex();
}
