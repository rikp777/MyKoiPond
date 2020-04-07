package com.api.mykoipond.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name="sizes")

//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SizeEntity extends BaseEntity {

    @NumberFormat
    private Integer size;

    @DateTimeFormat
    private Date date;

    @Size(min = 5, max = 250)
    private String comment;


    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;

    //RELATIONS
        //Has Size one koi
        @OneToOne
        private KoiEntity koi;

}
