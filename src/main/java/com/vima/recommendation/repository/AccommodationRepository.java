package com.vima.recommendation.repository;

import com.vima.recommendation.model.Accommodation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccommodationRepository extends Neo4jRepository<Accommodation, Long>{

    @Query("MATCH (n:Accommodation {accomId: $0}) RETURN n")
    Optional<Accommodation> findByAccomId(String accomId);

    @Query("MATCH (u:User)-[:STAYED_IN]->(a:Accommodation)<-[r:RATED]-(u) WHERE u.userId IN $0 AND r.value IN [4, 5] RETURN a")
    public List<Accommodation> getHighlyRatedAccommodations(List<String> userIds);

    @Query("MATCH (u:User)-[:STAYED_IN]->(a:Accommodation)<-[r:RATED]-(u) " +
            "WHERE a.accommodationId IN $0" +
            "WITH a, collect(r.value) AS grades " +
            "WHERE size([grade IN grades WHERE grade < 3]) < 5 " +
            "RETURN a")
    public List<Accommodation> filterOutPoorlyRated(List<String> accommodationIds);

    @Query("MATCH (a:Accommodation)<-[r:RATED]-(:User) " +
            "WHERE a.accommodationId IN $0 " +
            "WITH a, avg(r.value) AS averageGrade " +
            "RETURN a " +
            "ORDER BY averageGrade DESC")
    List<Accommodation> sortAccommodationsByAverageGrade(List<String> accommodationIds);
}
