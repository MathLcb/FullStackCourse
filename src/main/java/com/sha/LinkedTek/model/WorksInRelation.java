package com.sha.LinkedTek.model;

import org.neo4j.ogm.annotation.*;

import java.time.LocalDateTime;

@RelationshipEntity(type = WorksInRelation.TYPE)
public class WorksInRelation {
    public static final String TYPE = "WORKS_IN";

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private LocalDateTime since;

    @StartNode
    private User user;
}
