package com.employeemanagement.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
//@ToString(exclude = "user")
//@EqualsAndHashCode(exclude = "user")
@SequenceGenerator(name="Role_SEQ", sequenceName="role_sequence",allocationSize = 1)
public class Role {
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="Role_SEQ")
    private Long id;
    private String role;

//    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST , CascadeType.REFRESH , CascadeType.DETACH} , fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id")
//    )
//    @JsonIgnore
//    private List<User> users;
//    public List<User> getUsers(){
//        return this.users;
//    }
//    @ManyToOne
//    @JoinColumn(name = "user_id",nullable = false)
//    private User user;
}
