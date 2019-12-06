package com.pos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ToolsGenerateControllers {


	public static void GenerateControllersFromModels() {
		
		try {
			
			Path currentRelativePath = Paths.get("");
			String pathBase = currentRelativePath.toAbsolutePath().toString();
			System.out.println("Current relative path is: " + pathBase);
			String pathControllers =  pathBase + "\\src\\main\\java\\com\\pos\\controllers\\";
			String pathModels = pathBase + "\\src\\main\\java\\com\\pos\\models\\";

			
			
	    // Leer Modelos
		File folder = new File(pathModels);		 
        File[] files = folder.listFiles(); 
        for (File file : files)
        {
            if (file.isFile())
            {

                // Generar Controllers a partir del Modelo
            	String nameFile = file.getName().substring(0,file.getName().lastIndexOf("."));                
            	String nameFileMinus  = nameFile.toLowerCase(); 

            	
            	
            	//System.out.println(nameFile[0]);
                String PlantillaModelo = "package com.pos.controllers;\r\n" + 
                		"\r\n" + 
                		"import org.springframework.beans.factory.annotation.Autowired;\r\n" + 
                		"import org.springframework.http.HttpStatus;\r\n" + 
                		"import org.springframework.http.ResponseEntity;\r\n" + 
                		"import org.springframework.stereotype.Controller;\r\n" + 
                		"import org.springframework.web.bind.annotation.GetMapping;\r\n" + 
                		"import org.springframework.web.bind.annotation.PostMapping;\r\n" + 
                		"import org.springframework.web.bind.annotation.RequestBody;\r\n" + 
                		"import org.springframework.web.bind.annotation.RequestMapping;\r\n" + 
                		"import org.springframework.web.bind.annotation.ResponseBody;\r\n" + 
                		"\r\n" + 
                		"import com.pos.models."+nameFile+";\r\n" + 
                		"import com.pos.repository."+nameFile+"Repository;\r\n" + 
                		"\r\n" + 
                		"@Controller   \r\n" + 
                		"//@ComponentScan(basePackages = \"com.pos\")\r\n" + 
                		"@RequestMapping(path=\"/"+nameFile+"\") \r\n" + 
                		"public class "+nameFile+"Controller {\r\n" + 
                		"	\r\n" + 
                		"	@Autowired\r\n" + 
                		"	private "+nameFile+"Repository "+nameFileMinus+"Repository;\r\n" + 
                		"	\r\n" + 
                		"	@PostMapping(path=\"/createn"+nameFileMinus+"\") \r\n" + 
                		"	public @ResponseBody ResponseEntity<String> create"+nameFile+" (\r\n" + 
                		"			@RequestBody "+nameFile+" "+nameFileMinus+") {		\r\n" + 
                		"		"+nameFileMinus+"Repository.save("+nameFileMinus+");\r\n" + 
                		"		return new ResponseEntity<String>(HttpStatus.OK);\r\n" + 
                		"	}\r\n" + 
                		"	\r\n" + 
                		"	@PostMapping(path=\"/update"+nameFileMinus+"\") \r\n" + 
                		"	public @ResponseBody ResponseEntity<String> createNew"+nameFile+" (\r\n" + 
                		"			@RequestBody "+nameFile+" "+nameFileMinus+") {		\r\n" + 
                		"		"+nameFileMinus+"Repository.save("+nameFileMinus+");\r\n" + 
                		"		return new ResponseEntity<String>(HttpStatus.OK);\r\n" + 
                		"	}\r\n" + 
                		"	\r\n" + 
                		"	@GetMapping(path=\"/getall"+nameFileMinus+"\")\r\n" + 
                		"	public @ResponseBody Iterable<"+nameFile+"> getAll"+nameFile+"() {\r\n" + 
                		"		// This returns a JSON or XML with the users\r\n" + 
                		"		return "+nameFileMinus+"Repository.findAll();		\r\n" + 
                		"	}	\r\n" + 
                		"	\r\n" + 
                		"	@PostMapping(path=\"/remove"+nameFileMinus+"\") \r\n" + 
                		"	public @ResponseBody ResponseEntity<String> remove"+nameFile+" (\r\n" + 
                		"			@RequestBody "+nameFile+" "+nameFileMinus+") {\r\n" + 
                		"		"+nameFileMinus+"Repository.delete("+nameFileMinus+");\r\n" + 
                		"		return new ResponseEntity<String>(HttpStatus.OK);\r\n" + 
                		"	}\r\n" + 
                		"		\r\n" + 
                		"}";
                
                
                
                createFileUsingFileOutputStreamClass(pathControllers + nameFile + "Controller" + ".java",PlantillaModelo);
            	System.out.println("Generando " + nameFile + "Controller");
            }
        }
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	 private static void createFileUsingFileOutputStreamClass(String Path, String data) throws IOException
	    {
	        FileOutputStream out = new FileOutputStream(Path);
	        out.write(data.getBytes());
	        out.close();
	    }

}
