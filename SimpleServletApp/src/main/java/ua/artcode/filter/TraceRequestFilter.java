package ua.artcode.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TraceRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("INIT TRACE_REQUEST_FILTER");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String message = String.format("method %s, pathInfo %s, queryStr %s, URI %s, remote Add %s",
                httpServletRequest.getMethod(),
                httpServletRequest.getPathInfo(),
                httpServletRequest.getQueryString(),
                httpServletRequest.getRequestURI(),
                httpServletRequest.getRemoteAddr());

        System.out.println(message);
        chain.doFilter(httpServletRequest,httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
