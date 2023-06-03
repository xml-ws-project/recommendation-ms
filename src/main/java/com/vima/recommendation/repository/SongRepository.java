package com.vima.recommendation.repository;

import com.vima.recommendation.model.Song;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SongRepository extends Neo4jRepository<Song, Long> {
}
