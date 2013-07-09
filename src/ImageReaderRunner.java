/********************************************************************* 
 * Copyright(C) 2011-2012 LiMingkuan(11331173)  All rights reserved.
 * LiMingkuan is a student majoring in Software Engineering,
 * from the School of Software, 
 * SUN YAT-SEN UNIVERSITY, GZ 510006, P. R. China
 ********************************************************************/


// ImagaReaderRunner.java
import imagereader.Runner;

public class ImageReaderRunner {
	
	public static void main(String[] args) {
		
		ImplementImageIO imageioer = new ImplementImageIO();
		ImplementImageProcesser processor = new ImplementImageProcesser();
		Runner.run(imageioer, processor);
	}
}