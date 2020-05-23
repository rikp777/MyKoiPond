package com.api.mykoipond.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="subbreeds")

//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubBreedEntity extends BaseEntity{

    @NotNull(message = "name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 3 and 25 characters")
    private String name;

    @NotNull(message = "description is mandatory")
    @Size(min = 3, max = 750)
    private String description;

    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;

    //RELATIONS
        //Many subbreeds have one breed
        @ManyToOne(
                fetch = FetchType.EAGER,
                optional = false
        )
        @JoinColumn(name = "breed_id", nullable = false)
        private BreedEntity breed;

        //One subbreed has many kois
        @OneToMany(mappedBy = "subBreed")
        private Set<KoiEntity> kois = new HashSet<>();
}
