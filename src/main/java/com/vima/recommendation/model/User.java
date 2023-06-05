package com.vima.recommendation.model;

import com.vima.recommendation.model.props.Rate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id @GeneratedValue
    private Long id;
    private String userId;

    @Relationship(type = "STAYED_IN")
    private List<Accommodation> accomodations;

    @Relationship(type = "RATED")
    private List<Rate> rates;
}
