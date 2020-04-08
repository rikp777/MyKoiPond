package com.api.mykoipond.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name="permissions")

//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissionEntity extends BaseEntity{

    @Column(nullable=false, unique=true)
    @NotEmpty
    private String name;

    @ManyToMany(mappedBy="permissions")
    private List<UserEntity> users;
}

