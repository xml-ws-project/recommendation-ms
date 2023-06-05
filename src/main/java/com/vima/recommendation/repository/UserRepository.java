package com.vima.recommendation.repository;

import com.vima.recommendation.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (n:User {userId: $0}) RETURN n")
    Optional<User> findByUserId(String userId);
}
