package com.api.mykoipond.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="breeds")

//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BreedEntity extends BaseEntity{

    @Column(unique = true)
    @NotNull(message = "name is mandatory")
    @Size(min = 2, max = 50, message = "Name must be between 3 and 25 characters")
    private String name;

    @NotNull(message = "description is mandatory")
    @Size(min = 3, max = 500)
    private String description;


    //RELATIONS
        // A Breed has many SubBreeds (OneToMany)
        @OneToMany(
                mappedBy = "breed",
                fetch = FetchType.LAZY,
                cascade = CascadeType.ALL
        )
        private Set<SubBreedEntity> subBreeds = new HashSet<>();

}
