package com.jabyun.yeshow.Domain;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

public class StoreDefaultImage {

	public static String getImage(String imageName){
		
	
		BufferedImage image=null;
		String imageEncode=null;
		//System.out.println(imageName);
		try {
			//System.out.println(Paths.get("").toAbsolutePath().toString());
			image = ImageIO.read(new File(imageName));
			
			ByteArrayOutputStream baos = null;
			try {
			    baos = new ByteArrayOutputStream();
			    ImageIO.write(image, "png", baos);
			} finally {
			    try {
			        baos.close();
			    } catch (Exception e) {
			    }
			}
		
			imageEncode = Base64.getEncoder().encodeToString(baos.toByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageEncode;
	}
	
}
