package com.bingco.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;character=utf-8");
        response.setCharacterEncoding("utf-8");

        String method = req.getParameter("method");
        if (method != null && !method.isEmpty()) {
            Class<? extends BaseServlet> clazz = this.getClass();
            try {
                Method init = clazz.getMethod(method , HttpServletRequest.class, HttpServletResponse.class);
                Object invoke = init.invoke(this, req, resp);
                if (invoke != null && invoke instanceof String) {
                    String transfer = (String) invoke;
                    if (transfer.startsWith("r:")) {
                        response.sendRedirect(transfer.split(":")[1]);
                    }

                    if(transfer.startsWith("d:")) {
                        request.getRequestDispatcher(transfer.split(":")[1]).forward(request, response);
                    }
                }
            }

            catch(Exception e) {}
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {}

    @Override
    public void destroy() {}

    public void template(HttpServletRequest request, HttpServletResponse response) throws ServletException {}
}
