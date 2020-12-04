package com.formationbdi.springboot.app.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);

    /**
     * Definimos el tipo de filtro y cuando se va a ejecutar el filtro.
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pro";
    }


    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * Aqui si es true, siempre validamos el filtro.
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * Que es lo que se va hacer
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // Se importa el request de netflix zuul request.
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        logger.info("Entrando en POST filter");

        Long tiempoInicio = (Long) httpServletRequest.getAttribute("tiempoInicio");
        Long tiempoFinal = System.currentTimeMillis();
        Long tiempoTranscurrido = tiempoFinal - tiempoInicio;

        logger.info(String.format("Tiempo transcurrido en segundos %s", tiempoTranscurrido.doubleValue()/1000.00));
        logger.info(String.format("Tiempo transcurrido en miliseg $s", tiempoTranscurrido));

        return null;
    }
}
