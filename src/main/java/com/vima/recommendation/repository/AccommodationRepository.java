package com.vima.recommendation.repository;

import com.vima.recommendation.model.Accommodation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccommodationRepository extends Neo4jRepository<Accommodation, Long>{

    @Query("MATCH (n:Accommodation {userId: $0}) RETURN n")
    Optional<Accommodation> findByAccomId(String accomId);
}
