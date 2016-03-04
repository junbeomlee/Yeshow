package com.jabyun.yeshow.Domain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
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
			imageEncode = Base64.getEncoder().encodeToString(image.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imageEncode;
	}
	
}
