package com.api.mykoipond.projections;

import com.api.mykoipond.domain.KoiEntity;
import com.api.mykoipond.domain.PondEntity;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name = "inlineKois", types = { PondEntity.class })
public interface PondProjection {
    String getName();
    String getDescription();
    Set<KoiEntity> getKois();
}
