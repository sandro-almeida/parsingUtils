package br.com.projetos.parse.parsingUtils.dominios;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Evento {
	
	@JsonProperty("titulo")
	@JacksonXmlProperty(localName = "titulo")
	String titulo;
	
	@JsonProperty("descricao")
	@JacksonXmlProperty(localName = "descricao")
	String descricao;
	
	@JsonProperty("sistema")
	@JacksonXmlProperty(localName = "sistema")
	String sistema;
	
	@JsonProperty("consultaSql")
	@JacksonXmlProperty(localName = "consultaSql")
	String consultaSql;
	
	@JsonProperty("notificacao")
	@JacksonXmlProperty(localName = "notificacao")
	Notificacao notificacao;
	
	@JsonProperty("destinatario")
	@JacksonXmlProperty(localName = "destinatarios")
	List<Destinatario> destinatario;
	
	
	
	//TODO: criar metodo para criar um Evento com notificacao 'Nao enviada'
	
	public Evento() {
		super();
	}

	public Evento(String titulo, String descricao, String sistema, String consultaSql,
			List<Destinatario> destinatario) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.sistema = sistema;
		this.consultaSql = consultaSql;
		this.destinatario = destinatario;
	}
	
	//TODO: remover este construtor; usado apenas para testar a anotacao JsonProperty
	public Evento(String titulo, String descricao, String sistema, String consultaSql, Notificacao notificacao,
			List<Destinatario> destinatario) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.sistema = sistema;
		this.consultaSql = consultaSql;
		this.notificacao = notificacao;
		this.destinatario = destinatario;
	}



	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getConsultaSql() {
		return consultaSql;
	}

	public void setConsultaSql(String consultaSql) {
		this.consultaSql = consultaSql;
	}

	public Notificacao getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

	public List<Destinatario> getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(List<Destinatario> destinatario) {
		this.destinatario = destinatario;
	}


	@Override
	public String toString() {
		return "Evento [titulo=" + titulo + ", descricao=" + descricao + ", sistema=" + sistema + ", consultaSql="
				+ consultaSql + ", notificacao=" + notificacao + ", destinatario=" + destinatario + "]";
	}
	

}



