package ru.job4j.dream.filter;

import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CORSFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig)  {

    }

    /**
     * Получение списка доступных хостов и сборка в строку для хидера
     * если список пуст, все кросс-хосты разрешены
     * @return
     */
    String getAcceptableHosts() {
        List<String> hosts = PsqlStore.instOf().getAcceptedHosts();
        return hosts.stream().reduce("*", (first, second) -> first + " " + second);
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        httpServletResponse.addHeader("Access-Control-Allow-Origin", getAcceptableHosts());
        httpServletResponse.addHeader("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST");
        filterChain.doFilter(servletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
