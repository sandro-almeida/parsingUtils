package br.com.projetos.parse.parsingUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import br.com.projetos.parse.parsingUtils.dominios.Destinatario;
import br.com.projetos.parse.parsingUtils.dominios.Evento;
import br.com.projetos.parse.parsingUtils.dominios.Notificacao;

public class ObjectToJsonFile {
	//TODO: fazer um parse generico que aceite qualquer objeto e gere o Json
	String fileName;
	private static final String FILE_PATH = "./";
	
	public ObjectToJsonFile(String fileName) {
		super();
		this.fileName = FILE_PATH + fileName;
	}

	public void parseEvento(Evento evento) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		File outputFile = new File(fileName);

		// Serialize Java Objects to Json file
		objectMapper.writeValue(outputFile, evento);

	}
	
	public static void main(String[] args) {
		Destinatario destinatario1 = new Destinatario("abc@abc.com.br");
		Destinatario destinatario2 = new Destinatario("dummy@dummy.com.br");
		List<Destinatario> list = new ArrayList<Destinatario>();
		list.add(destinatario1);
		list.add(destinatario2);
		
		Notificacao notificacao = new Notificacao();
		
		Evento evento = new Evento("Consulta ABC", "Primeira consulta do ABC", "ABC", "select * from dummyBD where a = 'A';", notificacao, list);
		
		ObjectToJsonFile obj = new ObjectToJsonFile("evento.json");
		
		try {
			obj.parseEvento(evento);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERRO: parse falhou !!!");
			return;
		}
		
		System.out.println("SUCESSO: parse efetuado -> Object to Json File !!!");
	}

}
