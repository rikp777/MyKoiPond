package com.api.mykoipond.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="KoiParasites")

//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KoiParasiteEntity extends BaseEntity {

    @NotNull(message = "description is mandatory")
    @Size(min = 5, max = 250)
    private String comment;

    @DateTimeFormat
    private Date date;

    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;


    //RELATIONS
        //A ParasiteKoi has one Koi
        @ManyToOne
        private KoiEntity koi;

        //A ParasiteKoi has one Parasite
        @ManyToOne
        private ParasiteEntity parasite;
}
