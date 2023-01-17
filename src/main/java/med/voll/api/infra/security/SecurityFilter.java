package med.voll.api.infra.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter{

	// sempre que houver uma requisicao dentro da api, será chamado esse metodo
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		var tokenJWT = recuperarToken(request);
		
		System.out.println(tokenJWT);
		
		filterChain.doFilter(request, response); //Sempre chamar esse metodo para prosseguir com a requisicao, se nao tiver ele nao devolve nada
	
	}

	private String recuperarToken(HttpServletRequest request) {
		
		var authorizationHeader = request.getHeader("Authorization");
		
		if(null == authorizationHeader)
			throw new RuntimeException("Token JWT nao enviado no cabecalho Authorization");
		
		return authorizationHeader.replace("Bearer ", "");
	}

}
