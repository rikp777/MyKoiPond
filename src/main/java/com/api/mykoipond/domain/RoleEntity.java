package com.api.mykoipond.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="roles")

//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleEntity extends BaseEntity{

    @Column(nullable=false, unique=true)
    @NotEmpty
    private String name;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "roles_users",
//            joinColumns = @JoinColumn(name= "roles_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id")
//    )
    @ManyToMany(
            fetch = FetchType.EAGER,
            mappedBy = "roles"
    )
    private Set<UserEntity> users = new HashSet<>();
}
