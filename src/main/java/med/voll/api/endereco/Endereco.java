package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

	private String logradouro;
	private String bairro;
	private String cep;
	private String numero;
	private String complemento;
	private String cidade;
	private String uf;

	public Endereco(DadosEndereco dados) {
		this.logradouro = dados.logradouro();
		this.bairro = dados.bairro();
		this.cep = dados.cep();
		this.numero = dados.numero();
		this.complemento = dados.complemento();
		this.cidade = dados.cidade();
		this.uf = dados.uf();
	}

	public void atualizarEndereco(DadosEndereco dados) {
		if (null != dados.logradouro())this.logradouro = dados.logradouro();
		
		if (null != dados.bairro())this.logradouro = dados.bairro();
		
		if (null != dados.cep())this.logradouro = dados.cep();
		
		if (null != dados.numero())this.logradouro = dados.numero();
		
		if (null != dados.complemento())this.logradouro = dados.complemento();
		
		if (null != dados.cidade())this.logradouro = dados.cidade();
		
		if (null != dados.uf()) this.logradouro = dados.uf();
	}
}
