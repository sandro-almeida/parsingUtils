package br.com.projetos.parse.parsingUtils.dominios;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Notificacao {
	
	@JsonProperty("status")
	@JacksonXmlProperty(localName = "status")
	Integer status;

	@JsonProperty("data e hora")
	@JacksonXmlProperty(localName = "dataHora")
	LocalDateTime dataHora;

	public Notificacao() {
		super();
	}

	//TODO: criar um Enum para guardar informacoes de status
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	@Override
	public String toString() {
		return "Notificacao [status=" + status + ", dataHora=" + dataHora + "]";
	}
	
}
