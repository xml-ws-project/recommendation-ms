package com.vima.recommendation.grpc_service;

import com.vima.recommendation.service.UserService;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
@RequiredArgsConstructor
public class RecommendationGrpcService extends RecommendationServiceGrpc.RecommendationServiceImplBase {

    private final UserService userService;
}
