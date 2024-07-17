package com.example.testGrpcMessagingWithGo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class MessagingWithGoJavaClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        log.info("Client Starts checking for listening server on 8070....");

        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8070).usePlaintext().build();

        AddDebitAccountServiceGrpc.AddDebitAccountServiceBlockingStub addDebitAccountServiceBlockingStub = AddDebitAccountServiceGrpc.newBlockingStub(managedChannel);

        Account accountToBeAdded = Account.newBuilder()
                .setAccountName("vee Test")
                .setAccountNumber("0112345678")
                .setBankCode("998")
                .setCommonName("arKCz83xBv1scTwhATmOGbt2XQOC3am7ROgGATtC2ydEe1Wy1S")
                .build();

        AddDebitAccountRequest request = AddDebitAccountRequest.newBuilder()
                .addAccounts(accountToBeAdded)
                .build();

        AddDebitAccountResponse response = addDebitAccountServiceBlockingStub.addDebitAccount(request);

        log.info("AddDebitAccountResponse {}", response.toString());


    }

}
