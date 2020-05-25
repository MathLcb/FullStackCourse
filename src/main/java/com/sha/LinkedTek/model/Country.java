package com.sha.LinkedTek.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

import java.util.List;

@Getter
@NoArgsConstructor
@NodeEntity
public class Country {
    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String countryCode;

    @Relationship(type = LivesInRelation.TYPE,direction = Relationship.INCOMING)
    private List<LivesInRelation> liveFrom;

    public Country(String countryCode){
        this.countryCode = countryCode;
    }

}
