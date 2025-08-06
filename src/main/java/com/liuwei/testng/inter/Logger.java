package com.liuwei.testng.inter;

import org.apache.commons.logging.Log;

public interface Logger extends Log {

    void info(Object var1, Object[] var2);

    @Override
    default boolean isFatalEnabled() {
        return false;
    }

    @Override
    default boolean isErrorEnabled() {
        return false;
    }

    @Override
    default boolean isWarnEnabled() {
        return false;
    }

    @Override
    default boolean isInfoEnabled() {
        return false;
    }

    @Override
    default boolean isDebugEnabled() {
        return false;
    }

    @Override
    default boolean isTraceEnabled() {
        return false;
    }

    @Override
    default void fatal(Object o) {

    }

    @Override
    default void fatal(Object o, Throwable throwable) {

    }

    @Override
    default void error(Object o) {

    }

    @Override
    default void error(Object o, Throwable throwable) {

    }

    @Override
    default void warn(Object o) {

    }

    @Override
    default void warn(Object o, Throwable throwable) {

    }

    @Override
    default void info(Object o) {

    }

    @Override
    default void info(Object o, Throwable throwable) {

    }

    @Override
    default void debug(Object o) {

    }

    @Override
    default void debug(Object o, Throwable throwable) {

    }

    @Override
    default void trace(Object o) {

    }

    @Override
    default void trace(Object o, Throwable throwable) {

    }
}
