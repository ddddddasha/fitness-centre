package app.servlets.fitness.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.util.stream.Stream;

import static app.servlets.fitness.util.Constants.*;

@Slf4j
@Aspect
@Component
public class AspectController {

    @Pointcut("execution(* app.servlets.fitness.controllers..*(..)) && !@annotation(ExcludeLog)")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void logRequest(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(REQUEST_LOG_PATTERN, request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI());
        logMethodArguments(joinPoint);
    }

    @AfterReturning(pointcut = "pointCut()", returning = RESPONSE)
    public void logResponse(JoinPoint joinPoint, Object response){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        log.info(RESPONSE_LOG_PATTERN,
                request.getMethod(),
                joinPoint.getSignature().toShortString(),
                request.getRequestURI(),
                Optional.ofNullable(response).orElse(EMPTY));
        logMethodArguments(joinPoint);
    }

    private void logMethodArguments(JoinPoint joinPoint) {
        Stream.of(joinPoint.getArgs())
                .forEach(o -> log.info(ARGUMENT_LOG_PATTERN, o));
    }
}