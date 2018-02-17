package com.bingco.socket;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bingco
 * @version v1.0
 * By 2018-02-16 14:47
 * Package com.bingco.socket
 * -----------------------------------------------------
 */
public class SocketPool {

    private static Map<String, SocketConnection> pool = new HashMap<>();

    public static SocketConnection getAttribute(String key) {
        return pool.get(key);
    }

    public static void setAttribute(String key, SocketConnection value) {
        pool.put(key, value);
    }

    public static void removeAtrribute(String key) {
        pool.remove(key);
    }

    public static void clear() {
        pool.clear();
    }

    public static Map<String, SocketConnection> getSocketPool() {
        return pool;
    }
}
