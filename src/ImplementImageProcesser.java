/********************************************************************* 
 * Copyright(C) 2011-2012 LiMingkuan(11331173)  All rights reserved.
 * LiMingkuan is a student majoring in Software Engineering,
 * from the School of Software, 
 * SUN YAT-SEN UNIVERSITY, GZ 510006, P. R. China
 ********************************************************************/

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;

import imagereader.IImageProcessor;

public class ImplementImageProcesser implements IImageProcessor {
	public int[] colors;

	@Override
	public Image showChanelB(Image image) {
		
		// transform a image to BufferedImage
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
				image.getHeight(null), BufferedImage.TYPE_INT_RGB);

		Graphics graphic = bufferedImage.createGraphics();
		graphic.drawImage(image, 0, 0, null);
		graphic.dispose();

		colors = new int[bufferedImage.getHeight() * bufferedImage.getWidth()];

		for (int i = bufferedImage.getHeight() - 1; i >= 0; i--) {
			for (int j = 0; j < bufferedImage.getWidth(); j++) {
				// get the RGB in the (j, i) position of image
				int temp = bufferedImage.getRGB(j, i);
				// only keep the channel blue
				temp &= 0xFF0000FF;
				colors[i * bufferedImage.getWidth() + j] = temp;
				// System.out.printf("%d\n", i * bufferedImage.getWidth() + j);
			}
		}
		
		return Toolkit.getDefaultToolkit().createImage(
				new MemoryImageSource(bufferedImage.getWidth(), bufferedImage
						.getHeight(), colors, 0, bufferedImage.getWidth()));
	}

	@Override
	public Image showChanelG(Image image) {
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
				image.getHeight(null), BufferedImage.TYPE_INT_RGB);

		Graphics graphic = bufferedImage.createGraphics();
		graphic.drawImage(image, 0, 0, null);
		graphic.dispose();

		colors = new int[bufferedImage.getHeight() * bufferedImage.getWidth()];

		for (int i = bufferedImage.getHeight() - 1; i >= 0; i--) {
			for (int j = 0; j < bufferedImage.getWidth(); j++) {
				// System.out.printf("%d %d\n", i, j);
				int temp = bufferedImage.getRGB(j, i);
				// System.out.printf("%d\n", temp);
				temp &= 0xFF00FF00;
				colors[i * bufferedImage.getWidth() + j] = temp;
				// System.out.printf("%d\n", i * bufferedImage.getWidth() + j);
			}
		}
		return Toolkit.getDefaultToolkit().createImage(
				new MemoryImageSource(bufferedImage.getWidth(), bufferedImage
						.getHeight(), colors, 0, bufferedImage.getWidth()));
	}

	@Override
	public Image showChanelR(Image image) {
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
				image.getHeight(null), BufferedImage.TYPE_INT_RGB);

		Graphics graphic = bufferedImage.createGraphics();
		graphic.drawImage(image, 0, 0, null);
		graphic.dispose();

		colors = new int[bufferedImage.getHeight() * bufferedImage.getWidth()];

		for (int i = bufferedImage.getHeight() - 1; i >= 0; i--) {
			for (int j = 0; j < bufferedImage.getWidth(); j++) {
				// System.out.printf("%d %d\n", i, j);
				int temp = bufferedImage.getRGB(j, i);
				// System.out.printf("%d\n", temp);
				temp &= 0xFFFF0000;
				colors[i * bufferedImage.getWidth() + j] = temp;
				// System.out.printf("%d\n", i * bufferedImage.getWidth() + j);
			}
		}
		return Toolkit.getDefaultToolkit().createImage(
				new MemoryImageSource(bufferedImage.getWidth(), bufferedImage
						.getHeight(), colors, 0, bufferedImage.getWidth()));
	}

	@Override
	public Image showGray(Image image) {
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
				image.getHeight(null), BufferedImage.TYPE_INT_RGB);

		Graphics graphic = bufferedImage.createGraphics();
		graphic.drawImage(image, 0, 0, null);
		graphic.dispose();

		colors = new int[bufferedImage.getHeight() * bufferedImage.getWidth()];

		for (int i = bufferedImage.getHeight() - 1; i >= 0; i--) {
			for (int j = 0; j < bufferedImage.getWidth(); j++) {
				int temp = bufferedImage.getRGB(j, i);
				int red = (0x00FF0000 & temp) >> 16;
				int green = (0x0000FF00 & temp) >> 8;
				int blue = 0x000000FF & temp;
				// get the value of gray
				int gray = (int) (0.299f * red + 0.587f * green + 0.114f * blue);

				colors[i * bufferedImage.getWidth() + j] = (0x00FF << 24)
						| (gray << 16) | (gray << 8) | gray;
			}
		}
		return Toolkit.getDefaultToolkit().createImage(
				new MemoryImageSource(bufferedImage.getWidth(), bufferedImage
						.getHeight(), colors, 0, bufferedImage.getWidth()));
	}

}
