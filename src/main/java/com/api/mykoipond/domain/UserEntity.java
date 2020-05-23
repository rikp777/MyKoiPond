package com.api.mykoipond.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.*;

@Entity
@Table(name="users")

//LOMBOK
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends BaseEntity{

    @NotBlank(message = "First name is mandatory")
    @Column(nullable=false, length=50)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Column(nullable=false, length=50)
    private String lastName;

    @Column(unique = true, nullable = false)
    @NotBlank(message = "Username is mandatory")
    private String username;

    @Column(unique = true, nullable = false)
    @NotEmpty
    @Email(message = "Invalid email.")
    private String email;

    @Column(nullable=false)
    @NotEmpty
    @Size(min = 4)
    private String password;

    private boolean active = true;

    @CreationTimestamp
    private Timestamp created_at;

    //RELATIONS
        //Has many Ponds
        @ManyToMany(
                fetch = FetchType.LAZY
        )
        @JoinTable(
                name = "pond_user",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "pond_id", referencedColumnName = "id")
        )
        private Set<PondEntity> ponds = new HashSet<>();


        @ManyToMany(
                fetch = FetchType.LAZY
        )
        @JoinTable(
                name = "user_role",
                joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
                inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
        )
        private Set<RoleEntity> roles = new HashSet<>();

        @ManyToMany()
        private Set<PermissionEntity> permissions = new HashSet<>();
}
