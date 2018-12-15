package br.com.projetos.parse.parsingUtils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import br.com.projetos.parse.parsingUtils.dominios.Evento;

public class XmlFileToObject {

	String fileName;
	private static final String FILE_PATH = "./";
	
	public XmlFileToObject(String fileName) {
		super();
		this.fileName = FILE_PATH  + fileName;
	}
	
	public Evento parseEvento () throws JsonParseException, JsonMappingException, IOException {
		
		XmlMapper xmlMapper = new XmlMapper();
		
		File file = new File(fileName);
		
		Evento evento = xmlMapper.readValue(file, Evento.class);
		
		return evento;
	}

	public static void main(String[] args) {
		
		XmlFileToObject obj = new XmlFileToObject("evento.xml");
		Evento evento = null;
		
		try {
			evento = obj.parseEvento();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERRO: parse falhou - JsonParseException !!!");
			return;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERRO: parse falhou - JsonMappingException !!!");
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERRO: parse falhou - IOException !!!");
			return;
		}
		
		if (evento != null) {
			System.out.println("SUCESSO: parse efetuado -> Xml File to Object !!!");
			System.out.println("Evento=[" + evento.toString() + "]");
		}


	}

}
