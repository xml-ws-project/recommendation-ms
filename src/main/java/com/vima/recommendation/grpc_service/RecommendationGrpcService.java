package com.vima.recommendation.grpc_service;

import com.vima.gateway.Empty;
import com.vima.gateway.RecommendationServiceGrpc;
import com.vima.gateway.RecommendationServiceOuterClass;
import com.vima.gateway.Uuid;
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
    public void createUserNode(Uuid request, StreamObserver<Empty> responseObserver){
        userService.create(request.getValue());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void createAccomNode(Uuid request, StreamObserver<Empty> responseObserver) {
        accommodationService.create(request.getValue());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void createReserveRel(RecommendationServiceOuterClass.ReserveRelationship request, StreamObserver<Empty> responseObserver){
        userService.createRelationship(request.getUserId(), request.getAccomId(), -1);
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    @Override
    public void createRateRel(RecommendationServiceOuterClass.RateRelationship request, StreamObserver<Empty> responseObserver){
        userService.createRelationship(request.getUserId(), request.getAccomId(), request.getValue());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
