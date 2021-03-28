package com.marcuschiu.resilience4jexample;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

@Service
public class RemoteServiceClient {

    public static final String REMOTE_SERVICE_A = "remoteServiceA";

//    @CircuitBreaker(name = REMOTE_SERVICE_A, fallbackMethod = "callFail")
//    @RateLimiter(name = REMOTE_SERVICE_A)
//    @Bulkhead(name = REMOTE_SERVICE_A)
    @Retry(name = REMOTE_SERVICE_A, fallbackMethod = "callFail")
//    @TimeLimiter(name = REMOTE_SERVICE_A)
    public String call() {
        System.out.println("RemoteServiceClient.call() - executed");
        throw new RuntimeException("error with remote service");
    }

    private String callFail(RuntimeException e) {
        System.out.println("RemoteServiceClient.callFail() - executed");
        return "remote call failed";
    }
}
