package com.sha.LinkedTek.repository;

import com.sha.LinkedTek.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends Neo4jRepository<User, Long> {

    User findByName(String name);

    @Query("MATCH (u:User)-[r:LIVES_IN]->(c:Country) WHERE c.countryCode = {0} RETURN u")
    List<User> findByCountry(String country);

    @Query("CREATE (u:User {name: {1}}) WITH u MATCH (n:User) WHERE ID(n) = {0} WITH u,n CREATE (n)-[:HAS_FRIENDS]->(u) RETURN n")
    User addFriendRelation(Long userId, String friendName);

    @Query("MATCH (u:User)-[p:HAS_FRIENDS*]-(e:User) WHERE ID(u) = {user1Id} AND ID(e) = {user2Id} RETURN min(size(p))")
    Long levelBetweenFriends(@Param("userId") Long user1Id, @Param("userId") Long user2Id);
}
