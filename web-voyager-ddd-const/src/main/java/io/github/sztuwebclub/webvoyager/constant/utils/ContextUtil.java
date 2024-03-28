package io.github.sztuwebclub.webvoyager.constant.utils;

public class ContextUtil {
    private ContextUtil() {}

    public static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Integer id) {
        threadLocal.set(id);
    }

    public static Integer getCurrentId() {
        return threadLocal.get();
    }

    public static void removeCurrentId() {
        threadLocal.remove();
    }

}