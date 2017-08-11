package org.lrf.old_driver.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil<T>{

	final Class<T> typeParameterClass;
	
	public JsonUtil(Class<T> typeParameterClass){
		this.typeParameterClass = typeParameterClass;
	}
	
	public List<T> readListFromJson(String jsonPath) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, typeParameterClass);
		return objectMapper.readValue(new File(jsonPath), javaType);

	}	
}
