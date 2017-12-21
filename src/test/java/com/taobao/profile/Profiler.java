package com.taobao.profile;

import java.util.concurrent.atomic.AtomicInteger;

public class Profiler {
    public static AtomicInteger instrumentClassCount = new AtomicInteger(0);

    public static AtomicInteger instrumentMethodCount = new AtomicInteger(0);

    public static void Start(int methodId) {
        System.out.println("Start:" + methodId);
    }

    public static void End(int methodId) {
        System.out.println("End:" + methodId);
    }
}