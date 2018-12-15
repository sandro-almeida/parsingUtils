package br.com.projetos.parse.parsingUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import br.com.projetos.parse.parsingUtils.dominios.Destinatario;
import br.com.projetos.parse.parsingUtils.dominios.Evento;
import br.com.projetos.parse.parsingUtils.dominios.Notificacao;

public class ObjectToYamlFile {
	String fileName;
	private static final String FILE_PATH = "./";
	
	public ObjectToYamlFile(String fileName) {
		super();
		this.fileName = FILE_PATH + fileName;
	}

	public void parseObject(Object o) throws IOException {

		ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

		File outputFile = new File(fileName);

		// Serialize Java Objects to Yaml file
		objectMapper.writeValue(outputFile, o);

	}
	
	public static void main(String[] args) {
		Destinatario destinatario1 = new Destinatario("abc@abc.com.br");
		Destinatario destinatario2 = new Destinatario("dummy@dummy.com.br");
		List<Destinatario> list = new ArrayList<Destinatario>();
		list.add(destinatario1);
		list.add(destinatario2);
		
		Notificacao notificacao = new Notificacao();
		
		Evento evento = new Evento("Consulta Yaml", "Primeira consulta do Yaml", "YAML", "select * from dummyBD where a = 'A';", notificacao, list);
		
		ObjectToYamlFile obj = new ObjectToYamlFile("evento.yaml");
		
		try {
			obj.parseObject(evento);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERRO: parse falhou !!!");
			return;
		}
		
		System.out.println("SUCESSO: parse efetuado -> Object to Yaml File !!!");
	}

}
