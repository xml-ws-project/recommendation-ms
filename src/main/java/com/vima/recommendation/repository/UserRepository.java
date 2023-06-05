package com.vima.recommendation.repository;

import com.vima.recommendation.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (n:User {userId: $0}) RETURN n")
    Optional<User> findByUserId(String userId);

    @Query("MATCH (a:Accommodation)<-[:STAYED_IN]-(u:User {userId: $0})-[r1:RATED]->(a)<-[r2:RATED]-(otherUser:User) WHERE r1.value = r2.value OR r1.value - 1 = r2.value OR r1.value + 1 = r2.value RETURN otherUser")
    List<User> getSimilarUsers(String userId);
}
