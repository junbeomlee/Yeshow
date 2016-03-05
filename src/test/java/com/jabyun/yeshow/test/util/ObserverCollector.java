package com.jabyun.yeshow.test.util;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jabyun.yeshow.Domain.Store;
import com.jabyun.yeshow.Domain.User;
import com.jabyun.yeshow.Repository.StoreRepository;
import com.jabyun.yeshow.Repository.UserRepository;


@Aspect
@Component
public class ObserverCollector {
	
	@Autowired StoreRepository storeRepository;
	@Autowired UserRepository userRepository;
	
	private List<Object> objectList = new ArrayList<Object>();
	
	public ObserverCollector (){}

	@Transactional
	//@Around("execution(* com.jabyun.yeshow.test.factory.*.make*Entity(..))")
    public Object aroundTargetMethod(ProceedingJoinPoint thisJoinPoint)
            throws Throwable {
        System.out.println("AspectUsingAnnotation.aroundTargetMethod start.");
       
        Object object = thisJoinPoint.proceed();
        objectList.add(object);

        return object;
    }
	
	//@Before("execution(* com.jabyun.yeshow.test.*+.afterClassSetup(..))")
	public void clearAll(JoinPoint joinPoint){
		
		try{
		System.out.println(joinPoint.getSignature().getName());
		for(int i=0;i<this.objectList.size();i++){
			Object object = this.objectList.get(i);
			if(object instanceof User){
				userRepository.delete((User)object);
			}else if(this.objectList.get(i) instanceof Store){
				storeRepository.delete((Store)object);
			}
		}
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
}
