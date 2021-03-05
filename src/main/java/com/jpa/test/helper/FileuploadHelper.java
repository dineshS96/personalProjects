package com.jpa.test.helper;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileuploadHelper {
	public final String UPLOAD_DIR="C:\\Users\\dineshs\\Documents\\workspace-spring-tool-suite-4-4.9.0.RELEASE\\bootRestBook\\src\\main\\resources\\static\\image";
	
	public boolean uploadFile(MultipartFile d)
	{
		boolean f=false;
		
		try {
			
			InputStream is = d.getInputStream();
			byte data[]=new byte[is.available()];
			 
			is.read(data);
			
			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+"\\"+d.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			f=true;
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return f;
	}
}
