package com.api.mykoipond.projections;

import com.api.mykoipond.domain.KoiParasiteEntity;
import com.api.mykoipond.domain.ParasiteEntity;
import com.api.mykoipond.domain.PondEntity;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "inlineKoiParasites", types = { KoiParasiteEntity.class })
public interface KoiParasiteProjection {
    String getComment();
    Date getDate();
    ParasiteEntity getParasite();
}
