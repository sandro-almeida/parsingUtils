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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object parseObject (Class c) throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		File file = new File(fileName);
		
		Object obj = objectMapper.readValue(file, c);
		
		return obj;
	}

	public static void main(String[] args) {
		
		JsonFileToObject obj = new JsonFileToObject("evento.json");
		Evento evento = null;
		
		try {
			evento = (Evento) obj.parseObject(Evento.class);
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
