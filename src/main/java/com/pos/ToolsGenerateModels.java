package com.pos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ToolsGenerateModels {


	public static void GenerateRepositorysFromModels() {
		
		try {
			
			Path currentRelativePath = Paths.get("");
			String pathBase = currentRelativePath.toAbsolutePath().toString();
			System.out.println("Current relative path is: " + pathBase);
			String pathRepositorys =  pathBase + "\\src\\main\\java\\com\\pos\\repository\\";
			String pathModels = pathBase + "\\src\\main\\java\\com\\pos\\models\\";

			
			
	    // Leer Modelos
		File folder = new File(pathModels);		 
        File[] files = folder.listFiles(); 
        for (File file : files)
        {
            if (file.isFile())
            {
            	//nombre.substring(0,nombre.lastIndexO f("."));
                //System.out.println(file.getName());
                // Generar Repositorys a partir del Modelo
            	String nameFile = file.getName().substring(0,file.getName().lastIndexOf("."));

            	//System.out.println(nameFile[0]);
                String PlantillaModelo = "package com.pos.repository;\r\n" + 
                		"\r\n" + 
                		"import org.springframework.data.repository.CrudRepository;\r\n" + 
                		"\r\n" + 
                		"import com.pos.models." + nameFile +";\r\n" + 
                		"\r\n" + 
                		"	// This will be AUTO IMPLEMENTED by Spring into a Bean called CustomerRepository\r\n" + 
                		"	// CRUD refers Create, Read, Update, Delete\r\n" + 
                		"	public interface "+nameFile+"Repository extends CrudRepository<"+nameFile+", Integer> {\r\n" + 
                		"	\r\n" + 
                		"	    //List<Customer> findByName(String name);	    \r\n" + 
                		"	    //List<Customer> findByNameContaining(String name);\r\n" + 
                		"	  \r\n" + 
                		"		\r\n" + 
                		"	}	";
                
                
                
                createFileUsingFileOutputStreamClass(pathRepositorys + nameFile + "Repository" + ".java",PlantillaModelo);
            	System.out.println("Generando " + nameFile + "Repository");
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
