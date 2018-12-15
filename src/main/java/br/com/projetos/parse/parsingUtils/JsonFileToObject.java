package br.com.projetos.parse.parsingUtils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.projetos.parse.parsingUtils.dominios.Evento;

public class JsonFileToObject {
	
	String fileName;
	private static final String FILE_PATH = "./";
	
	public JsonFileToObject(String fileName) {
		super();
		this.fileName = FILE_PATH  + fileName;
	}
	
	public Evento parseEvento () throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		File file = new File(fileName);
		
		Evento evento = objectMapper.readValue(file, Evento.class);
		
		return evento;
	}

	public static void main(String[] args) {
		
		JsonFileToObject obj = new JsonFileToObject("evento.json");
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
			System.out.println("SUCESSO: parse efetuado -> Json File to Object !!!");
			System.out.println("Evento=[" + evento.toString() + "]");
		}


	}

}
