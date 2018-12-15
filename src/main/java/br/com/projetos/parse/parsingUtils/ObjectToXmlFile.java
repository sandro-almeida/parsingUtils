package br.com.projetos.parse.parsingUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.projetos.parse.parsingUtils.dominios.Destinatario;
import br.com.projetos.parse.parsingUtils.dominios.Evento;
import br.com.projetos.parse.parsingUtils.dominios.Notificacao;

public class ObjectToXmlFile {

	String fileName;
	private static final String FILE_PATH = "./";
	
	public ObjectToXmlFile(String fileName) {
		super();
		this.fileName = FILE_PATH + fileName;
	}
	
	public void parseObject(Object o) throws IOException {

		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

		File outputFile = new File(fileName);

		// Serialize Java Objects to Xml file
		xmlMapper.writeValue(outputFile, o);

	}
	
	public static void main(String[] args) {
		Destinatario destinatario1 = new Destinatario("abcde@abc.com.br");
		Destinatario destinatario2 = new Destinatario("veryDummy@dummy.com.br");
		List<Destinatario> list = new ArrayList<Destinatario>();
		list.add(destinatario1);
		list.add(destinatario2);
		
		Notificacao notificacao = new Notificacao();
		
		Evento evento = new Evento("Consulta ABCDE", "Primeira consulta do ABCDE", "ABC", "select * from dummyBD where a = 'A';", notificacao, list);
		
		ObjectToXmlFile obj = new ObjectToXmlFile("evento.xml");
		
		try {
			obj.parseObject(evento);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERRO: parse falhou !!!");
			return;
		}
		
		System.out.println("SUCESSO: parse efetuado -> Object to Xml File !!!");
	}

}
