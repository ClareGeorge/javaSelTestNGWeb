package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestDataBuild {

	public static List<HashMap<String, String>> readJsonData(String jsonDataFile, String testcaseName) throws IOException {
		//commons io and jackson databind  are the dependencies
		String jsonData = FileUtils.readFileToString(new File(jsonDataFile), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
		
		HashMap<String,List<HashMap<String, String>>> parsedData = mapper.readValue(
													jsonData, 
													new TypeReference<HashMap<String,List<HashMap<String, String>>>>(){}
													);
		
		return parsedData.get(testcaseName);
	}
	public static  String getConfigValue(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\java\\resources\\global.properties");
		Properties props = new Properties();
		props.load(fis);
		String value = props.getProperty(key);
		return value ;
		
		
	}
	
}

