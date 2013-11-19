package br.com.assistenciaTecnica.organization.security;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.assistenciaTecnica.organization.managedBeans.security.*;

@WebFilter("*.xhtml")
public class AuthenticationFilter implements Filter{
	private static final String[] index = { "javax.faces.resource",
	"index.xhtml" };
	
	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpSession sessao = ((HttpServletRequest) request).getSession();
		
		if(checkPage(request)){
			chain.doFilter(request, response);
		}else{
			if (sessao == null || sessao.getAttribute("loginBean") == null || 
					((LoginBean) sessao.getAttribute("loginBean")).getUser() == null) {
				
				RequestDispatcher dis = request
						.getRequestDispatcher("/index.xhtml");
				dis.forward(request, response);
			} else {
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	protected boolean checkPage(ServletRequest request) {

		String resource = ((HttpServletRequest) request).getRequestURI();

		for (String esc : index) {
			if (resource.contains(esc)) {
				return true;
			}
		}
		System.out.println(resource);
		return false;
	}

}
