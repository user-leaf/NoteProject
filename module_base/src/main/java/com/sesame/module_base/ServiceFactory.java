package com.sesame.module_base;

public class ServiceFactory {

    private static volatile ServiceFactory singleton;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (singleton == null) {
            synchronized (ServiceFactory.class) {
                if (singleton == null) {
                    singleton = new ServiceFactory();
                }
            }
        }
        return singleton;
    }

    private IKotlinService kotlinService;
    private ITestService testService;

    public IKotlinService getKotlinService() {
        if (kotlinService == null){
            kotlinService = new EmptyKotlinService();
        }
        return kotlinService;
    }

    public void setKotlinService(IKotlinService kotlinService) {
        this.kotlinService = kotlinService;
    }

    public ITestService getTestService() {
        if (testService == null){
            return new EmptyTestService();
        }
        return testService;
    }

    public void setTestService(ITestService testService) {
        this.testService = testService;
    }
}