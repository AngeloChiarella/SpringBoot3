package med.voll.api.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import med.voll.api.domain.usuario.Usuario;

@Service
public class TokenService {

	public String gerarToken(Usuario usuario) {
		try {
		    var algoritmo = Algorithm.HMAC256("12345678");
		    return JWT.create()
		        .withIssuer("API Voll.med")//nome da api
		        .withSubject(usuario.getLogin())//insere login no token
//		        .withClaim("id", usuario.getId()) // insere campo chave e valor no token, atributos
		        .withExpiresAt(dataExpiracao()) // data para expiracao de token
		        .sign(algoritmo);
		} catch (JWTCreationException exception){
			new RuntimeException("Erro ao gerar JWT: ", exception);
		}
		return null;
	}

	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
}
