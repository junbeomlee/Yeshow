package com.jabyun.yeshow.test.util;

import org.junit.internal.runners.InitializationError;
import org.junit.runner.notification.RunNotifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class InstanceTestClassRunner extends SpringJUnit4ClassRunner {

	private InstanceTestClassListener instanceSetupListener;
	
    public InstanceTestClassRunner(Class<?> clazz) throws org.junit.runners.model.InitializationError {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	

    @Override
    protected Object createTest() throws Exception {
        Object test = super.createTest();
        // Note that JUnit4 will call this createTest() multiple times for each
        // test method, so we need to ensure to call "beforeClassSetup" only once.
        if (test instanceof InstanceTestClassListener && instanceSetupListener == null) {
            instanceSetupListener = (InstanceTestClassListener) test;
            instanceSetupListener.beforeClassSetup();
        }
        return test;
    }

    @Override
    public void run(RunNotifier notifier) {
        super.run(notifier);
        if (instanceSetupListener != null)
            instanceSetupListener.afterClassSetup();
    }
}
