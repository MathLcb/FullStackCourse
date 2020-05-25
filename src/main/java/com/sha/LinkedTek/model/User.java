package com.sha.LinkedTek.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data //Getter,Setter, ToString, Equals...
@NoArgsConstructor
@NodeEntity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Properties
    private String name;
    private String firstname;
    private String email;
    private String password;
    private LocalDateTime birthdate;

    @Relationship(type = "HAS_FRIENDS")
    private List<User> friends;

    @Relationship(type = WorksInRelation.TYPE)
    private WorksInRelation worksInRelation;
}
