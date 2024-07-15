package com.example.testGrpcMessagingWithGo;

import io.grpc.stub.StreamObserver;

public class TestWithGoServerPaymentService extends PaymentServiceGrpc.PaymentServiceImplBase {
    @Override
    public void makePayment(PaymentRequest request, StreamObserver<PaymentResponse> responseObserver) {
        responseObserver.onNext(PaymentResponse.newBuilder()
                .setPaymentStatus("SuccessFul")
                .setAmount(request.getAmount())
                .build()
        );
        responseObserver.onCompleted();

    }
}
