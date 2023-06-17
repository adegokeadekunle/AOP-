package demo;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthenticationAspect {


    //for as classes, make sure you annotate them as aspect
    @Pointcut("within(demo..*)") //this will be executed on all the classes and methods within this package
    public void authenticationPointCut(){

    }
    @Pointcut("within(demo..*)") //this will be executed in this class and all the methods in it
    public void authorizationPointCut(){

    }

    @Before("authenticationPointCut() && authorizationPointCut()")
    public void authenticate(){
        System.out.println("authenticating transaction calls");
    }
}
