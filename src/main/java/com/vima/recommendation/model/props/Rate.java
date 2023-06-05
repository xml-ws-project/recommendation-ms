package com.vima.recommendation.model.props;

import com.vima.recommendation.model.Accommodation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RelationshipProperties
public class Rate {

    @Id @GeneratedValue
    private Long id;

    @TargetNode
    private Accommodation accommodation;

    private int value;
}
