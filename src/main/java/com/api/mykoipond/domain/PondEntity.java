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
@Table(name="ponds")

//LOMBOK
//https://stackoverflow.com/questions/17445657/hibernate-onetomany-java-lang-stackoverflowerror
@Getter
@Setter
//===
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PondEntity extends BaseEntity {

    @NotNull(message = "name is mandatory")
    @Size(min = 3, max = 25, message = "Name must be between 3 and 25 characters")
    private String name;

    @NotNull
    @Size(min = 5, max = 250)
    private String description;

    @CreationTimestamp
    private Timestamp created_at;
    @UpdateTimestamp
    private Timestamp updated_at;


    //RELATIONS
        //Has many Users
        @ManyToMany(
                cascade = {
                        CascadeType.PERSIST,
                        CascadeType.MERGE
                },
                fetch = FetchType.EAGER,
                mappedBy = "ponds"
        )
        private Set<UserEntity> users = new HashSet<>();

        // A Pond has many Kois (OneToMany)
        @OneToMany(
                mappedBy = "pond",
                fetch = FetchType.EAGER,
                cascade = CascadeType.ALL,
                orphanRemoval = true
        )
        private Set<KoiEntity> kois = new HashSet<>();
}
