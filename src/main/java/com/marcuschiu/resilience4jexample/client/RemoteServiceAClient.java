package com.marcuschiu.resilience4jexample.client;

import com.marcuschiu.resilience4jexample.util.Util;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.stereotype.Service;

@Service
public class RemoteServiceAClient {

    public static final String REMOTE_SERVICE_A = "remoteServiceA";

    private String callFail(RuntimeException e) {
        System.out.println("RemoteServiceClientA.callFail() - executed");
        return "remote call failed";
    }

    /**
     * The Resilience4j Aspects order is following:
     * - Retry ( CircuitBreaker ( RateLimiter ( TimeLimiter ( Bulkhead ( Function ) ) ) ) )
     * - so Retry is applied at the end (if needed).
     */
    @Bulkhead(name = REMOTE_SERVICE_A, fallbackMethod = "callFail")
    @TimeLimiter(name = REMOTE_SERVICE_A, fallbackMethod = "callFail")
    @RateLimiter(name = REMOTE_SERVICE_A, fallbackMethod = "callFail")
    @CircuitBreaker(name = REMOTE_SERVICE_A, fallbackMethod = "callFail")
    @Retry(name = REMOTE_SERVICE_A, fallbackMethod = "callFail")
    public String call1() {
        System.out.println("RemoteServiceClientA.call1() - executed");
        return "Hello, World";
    }

    @Retry(name = REMOTE_SERVICE_A, fallbackMethod = "callFail")
    public String call2() {
        System.out.println("RemoteServiceClientA.call2() - executed");
        throw new RuntimeException("error with remote service");
    }

    @CircuitBreaker(name = REMOTE_SERVICE_A, fallbackMethod = "callFail")
    public String call3() {
        System.out.println("RemoteServiceClientA.call3() - executed");
        throw new RuntimeException("error with remote service");
    }

    @RateLimiter(name = REMOTE_SERVICE_A, fallbackMethod = "callFail")
    public String call4() {
        System.out.println("RemoteServiceClientA.call4() - executed");
        throw new RuntimeException("error with remote service");
    }

    @TimeLimiter(name = REMOTE_SERVICE_A, fallbackMethod = "callFail")
    public String call5() {
        System.out.println("RemoteServiceClientA.call5() - executed");
        throw new RuntimeException("error with remote service");
    }

    @Bulkhead(name = REMOTE_SERVICE_A, fallbackMethod = "callFail")
    public String call6() throws InterruptedException {
        System.out.println("RemoteServiceClientA.call6() - executed");
        Thread.sleep(5000);
        Util.printStackTrace();
        throw new RuntimeException("error with remote service");
    }
}
