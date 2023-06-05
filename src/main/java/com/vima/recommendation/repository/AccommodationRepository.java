package com.vima.recommendation.repository;

import com.vima.recommendation.model.Accommodation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends Neo4jRepository<Accommodation, Long>{

}
