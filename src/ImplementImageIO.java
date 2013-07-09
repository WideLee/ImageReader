import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import imagereader.IImageIO;

public class ImplementImageIO implements IImageIO {

	public int bfSize;
	public int biWidth;
	public int biHeight;
	public int biBitCount;
	public int widthBytes;
	public int[] colors;

	@Override
	public Image myRead(String imgName) throws IOException {
		FileInputStream inputStream = new FileInputStream(imgName);

		byte[] fileHeader = new byte[14];
		// read the image fileHeader
		inputStream.read(fileHeader, 0, 14);
		bfSize = (((int) fileHeader[5] & 0x00FF) << 24)
				| (((int) fileHeader[4] & 0x00FF) << 16)
				| (((int) fileHeader[3] & 0x00FF) << 8)
				| ((int) fileHeader[2] & 0x00FF);

		byte[] infoHeader = new byte[40];
		inputStream.read(infoHeader, 0, 40);

		// get the image width
		biWidth = (((int) infoHeader[7] & 0x00FF) << 24)
				| (((int) infoHeader[6] & 0x00FF) << 16)
				| (((int) infoHeader[5] & 0x00FF) << 8)
				| ((int) infoHeader[4] & 0x00FF);

		// get the image height
		biHeight = (((int) infoHeader[11] & 0x00FF) << 24)
				| (((int) infoHeader[10] & 0x00FF) << 16)
				| (((int) infoHeader[9] & 0x00FF) << 8)
				| ((int) infoHeader[8] & 0x00FF);

		// get the bitCount, in this exercise, it always is 24
		biBitCount = (((int) infoHeader[15] & 0x00FF) << 8)
				| ((int) infoHeader[14] & 0x00FF);

		if (biBitCount == 24) {

			widthBytes = ((int) (biWidth * biBitCount + 31) / 32) * 4;
			// get color for each pixel
			// reading is begin in bottom-left
			// but the array is begin in top-left
			colors = new int[bfSize];
			byte[] colorBuffer = new byte[10];
			for (int i = biHeight - 1; i >= 0; i--) {
				for (int j = 0; j < biWidth; j++) {
					inputStream.read(colorBuffer, 0, 3);
					// System.out.printf("%d: %d %d %d\n", i * biWidth + j,
					// colorBuffer[0], colorBuffer[1], colorBuffer[2]);
					colors[i * biWidth + j] = ((int) 0xFF << 24)
							| (((int) colorBuffer[2] & 0x00FF) << 16)
							| (((int) colorBuffer[1] & 0x00FF) << 8)
							| ((int) colorBuffer[0] & 0x00FF);
					// each element in array of color is begin with FF
				}
				// read the extra byte of a line
				inputStream.read(colorBuffer, 0, widthBytes - biWidth * 3);
			}
		} else {
			System.out.println("ERROR! the BitCount is not 24!");
		}
		inputStream.close();
		
		// create a image using the information generate before and return it.
		return Toolkit.getDefaultToolkit().createImage(
				new MemoryImageSource(biWidth, biHeight, colors, 0, biWidth));
	}

	@Override
	public Image myWrite(Image image, String fileName) throws IOException {
		
		// transform a image to BufferedImage
		BufferedImage bufferedImage = new BufferedImage(image.getWidth(null),
				image.getHeight(null), BufferedImage.TYPE_INT_RGB);

		Graphics graphic = bufferedImage.createGraphics();
		graphic.drawImage(image, 0, 0, null);
		graphic.dispose();
		
		// using the API in Java of ImageIO to write the image to file
		ImageIO.write(bufferedImage, "bmp", new File(fileName));

		return image;
	}

}