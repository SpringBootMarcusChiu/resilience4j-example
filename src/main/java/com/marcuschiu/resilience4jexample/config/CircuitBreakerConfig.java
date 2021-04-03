package com.marcuschiu.resilience4jexample.config;

/**
 * This configuration of beans can be completely replaced by the application.yml
 * in which SpringBoot would AutoConfigure the beans for you
 */
//@Configuration
//public class CircuitBreakerConfig {
//    @Bean
//    public CircuitBreakerConfigCustomizer someRemoteSvcCircuitBreaker() {
//        return CircuitBreakerConfigCustomizer
//                .of(RemoteServiceClient.REMOTE_SERVICE_A, builder -> builder.slidingWindowSize(100));
//    }

//    @Bean
//    public CircuitBreakerConfigCustomizer someRemoteSvcCircuitBreaker() {
//        //https://resilience4j.readme.io/docs/circuitbreaker
//        return CircuitBreakerConfigCustomizer
//                .of("remoteServiceA", builder -> {
//                    builder.slidingWindowSize(5);
//                    builder.failureRateThreshold(3);
//                    builder.waitDurationInOpenState(Duration.ofSeconds(10));
//                    builder.slowCallDurationThreshold(Duration.ofSeconds(5));
//                    builder.slowCallRateThreshold(100);
//                    builder.permittedNumberOfCallsInHalfOpenState(2);
//                    builder.slidingWindowType(COUNT_BASED);
//                });
//    }
//}
