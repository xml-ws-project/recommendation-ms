package com.vima.recommendation.grpc_service;

import com.vima.recommendation.RecommendationServiceGrpc;
import com.vima.recommendation.TextMessage;
import com.vima.recommendation.Uuid;
import com.vima.recommendation.service.AccommodationService;
import com.vima.recommendation.service.UserService;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class RecommendationGrpcService extends RecommendationServiceGrpc.RecommendationServiceImplBase {

    private final UserService userService;
    private final AccommodationService accommodationService;

    @Override
    public void createUserNod(Uuid request, StreamObserver<TextMessage> responseObserver){
        var result = userService.create(request.getValue());
        responseObserver.onNext(TextMessage.newBuilder().setValue(result ? "Node created" : "Error creating node.").build());
        responseObserver.onCompleted();
    }

    @Override
    public void createAccomNod(Uuid request, StreamObserver<TextMessage> responseObserver) {
        var result = accommodationService.create(request.getValue());
        responseObserver.onNext(TextMessage.newBuilder().setValue(result ? "Node created" : "Error creating node.").build());
        responseObserver.onCompleted();
    }

}
