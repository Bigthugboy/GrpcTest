package com.example.testGrpcMessagingWithGo;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class MessagingWithGoSeverRunner {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("starting server...");
        Server server = ServerBuilder.forPort(8077)
                .addService(new TestWithGoServerPaymentService())
                .build();
        server.start();

        System.out.println("server started on port "+server.getPort());

        server.awaitTermination();
    }

}
