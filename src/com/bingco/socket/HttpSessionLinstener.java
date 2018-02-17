package com.bingco.socket;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * HttpSession监听器
 *
 * @author bingco
 * @version v1.0
 * By 2018-02-16 11:31
 * Package com.bingco.socket
 * -----------------------------------------------------
 */
public class HttpSessionLinstener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ((HttpServletRequest)sre.getServletRequest()).getSession();
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }
}
