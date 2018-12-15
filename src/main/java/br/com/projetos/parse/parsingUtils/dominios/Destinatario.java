package br.com.projetos.parse.parsingUtils.dominios;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//TODO: esta anotacao abaixo nao esta funcionando; continua retornando <destinatarios>  
@JacksonXmlRootElement(localName = "destinatario")
public class Destinatario {

	@JsonProperty("endereco")
	@JacksonXmlProperty(localName = "endereco")
	String endereco;

	public Destinatario() {
		super();
	}

	public Destinatario(String endereco) {
		super();
		this.endereco = endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Destinatario [endereco=" + endereco + "]";
	}
	

}
