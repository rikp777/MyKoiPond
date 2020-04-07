package com.api.mykoipond.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="subbreeds")

//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubBreedEntity extends BaseEntity{

    @NotNull(message = "name is mandatory")
    @Size(min = 3, max = 25, message = "Name must be between 3 and 25 characters")
    private String name;

    @NotNull(message = "description is mandatory")
    @Size(min = 5, max = 250)
    private String description;

    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;

    //RELATIONS
        //Many subbreeds have one breed
        @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinColumn(nullable = false)
        private BreedEntity breed;

        //One subbreed has many kois
        @OneToMany(mappedBy = "subBreed")
        private List<KoiEntity> kois;
}
