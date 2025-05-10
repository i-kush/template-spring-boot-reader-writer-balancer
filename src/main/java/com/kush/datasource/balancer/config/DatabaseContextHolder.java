package com.kush.datasource.balancer.config;

import java.util.Optional;

public final class DatabaseContextHolder {

    private static final ThreadLocal<DatabaseType> CONTEXT = new ThreadLocal<>();

    private DatabaseContextHolder() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void set(DatabaseType databaseType) {
        CONTEXT.set(databaseType);
    }

    public static DatabaseType get() {
        return Optional.ofNullable(CONTEXT.get())
                       .orElse(DatabaseType.WRITER);
    }

    public static void clear() {
        CONTEXT.remove();
    }
}