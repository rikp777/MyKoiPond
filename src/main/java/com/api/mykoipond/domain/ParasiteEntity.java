package com.api.mykoipond.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="parasites")

//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParasiteEntity extends BaseEntity{
    @NotNull(message = "name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @NotNull(message = "description is mandatory")
    @Size(min = 5, max = 3000)
    private String description;

    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;

    //RELATIONS
        //A parasite has many koiParasite registers
        @OneToMany(mappedBy = "parasite")
        private Set<KoiParasiteEntity> koiParasite = new HashSet<>();
}
