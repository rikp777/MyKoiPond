package com.api.mykoipond.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

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

    @ManyToMany()
    private List<UserEntity> users;
}
