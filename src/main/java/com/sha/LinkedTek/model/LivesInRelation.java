package com.sha.LinkedTek.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
@RelationshipEntity(type = LivesInRelation.TYPE)
public class LivesInRelation {
    public static final String TYPE = "LIVES_IN";

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private LocalDateTime since;

    @StartNode
    private User user;

    @EndNode
    private Country country;

    public LivesInRelation(User user, Country country,LocalDateTime since){
        this.user = user;
        this.country = country;
        this.since = since;
    }
}
