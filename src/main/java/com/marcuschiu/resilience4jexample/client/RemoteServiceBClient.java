package com.marcuschiu.resilience4jexample.client;

import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class RemoteServiceBClient {

    public static final String REMOTE_SERVICE_B = "remoteServiceB";

    @Retry(name = REMOTE_SERVICE_B, fallbackMethod = "callFail")
    public String call1() throws InterruptedException {
        System.out.println("RemoteServiceClientB.call() - executed");
        throw new RuntimeException("error with remote service");
    }

    private String callFail(RuntimeException e) {
        System.out.println("RemoteServiceClientB.callFail() - executed");
        return "remote call failed";
    }
}
