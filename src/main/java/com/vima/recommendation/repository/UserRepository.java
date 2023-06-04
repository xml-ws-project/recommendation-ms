package com.vima.recommendation.repository;

import com.vima.recommendation.model.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.UUID;

public interface UserRepository extends Neo4jRepository<User, Long> {
}
