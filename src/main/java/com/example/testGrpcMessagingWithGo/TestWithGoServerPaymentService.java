package com.example.testGrpcMessagingWithGo;

import io.grpc.stub.StreamObserver;

public class TestWithGoServerPaymentService extends AddDebitAccountServiceGrpc.AddDebitAccountServiceImplBase {

    @Override
    public void addDebitAccount(AddDebitAccountRequest request, StreamObserver<AddDebitAccountResponse> responseObserver) {

    }
}
