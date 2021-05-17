package it.objectmethod.jpaecommerce.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import it.objectmethod.jpaecommerce.service.JWTService;

@Component
@Order(1)
public class AuthenticationFilter implements Filter {

	@Autowired
	private JWTService jwtServ;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		String url = httpReq.getRequestURI();

		if (url.endsWith("login") || url.endsWith("article-id") || url.endsWith("articles/all")) {
			System.out.println("RICHIESTA APPROVATA!");
			chain.doFilter(request, response);
		} else {
			String token = httpReq.getHeader("auth-token");
			if (token != null) {
				if (jwtServ.checkJWTToken(token)) {
					chain.doFilter(request, response);
				} else {
					httpResp.setStatus(HttpServletResponse.SC_FORBIDDEN);
				}
			} else {
				httpResp.setStatus(HttpServletResponse.SC_FORBIDDEN);
			}
		}
	}

}
