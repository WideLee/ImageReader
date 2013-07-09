import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author limkuan
 *
 */
public class testImageProcesser {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * {@link ImplementImageProcesser#showChanelB(java.awt.Image)} 的测试方法。
	 */
	@Test
	public void testShowChanelB() {
		ImplementImageIO imageIO = new ImplementImageIO();
		ImplementImageProcesser imageProcesser = new ImplementImageProcesser();
		
		try {
			Image pic_1 = imageIO.myRead("res/1.bmp");
			Image blueImage_1 = imageProcesser.showChanelB(pic_1);
			BufferedImage bufferedImage_1 = new BufferedImage(blueImage_1.getWidth(null),
					blueImage_1.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics graphic_1 = bufferedImage_1.createGraphics();
			graphic_1.drawImage(blueImage_1, 0, 0, null);
			graphic_1.dispose();

			Image goal_1 = imageIO.myRead("res/1_blue_goal.bmp");
			BufferedImage goalbufferedImage_1 = new BufferedImage(goal_1.getWidth(null),
					goal_1.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics goalGraphic_1 = goalbufferedImage_1.createGraphics();
			goalGraphic_1.drawImage(goal_1, 0, 0, null);
			goalGraphic_1.dispose();
			
			// determine height and width of two image is equal
			assertEquals(blueImage_1.getHeight(null), goal_1.getHeight(null));
			assertEquals(blueImage_1.getWidth(null), goal_1.getWidth(null));
			for (int i = imageIO.biHeight - 1; i >= 0; i--) {
				for (int j = 0; j < imageIO.biWidth; j++) {
					int temp = bufferedImage_1.getRGB(j, i);
					int goal_temp = goalbufferedImage_1.getRGB(j, i);
					// determine value of RGB in each pixel of image is equal
					assertEquals(temp, goal_temp);
				}
			}
			
			// matching another picture.
			Image pic_2 = imageIO.myRead("res/2.bmp");
			Image blueImage_2 = imageProcesser.showChanelB(pic_2);
			BufferedImage bufferedImage_2 = new BufferedImage(blueImage_2.getWidth(null),
					blueImage_2.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics graphic_2 = bufferedImage_2.createGraphics();
			graphic_2.drawImage(blueImage_2, 0, 0, null);
			graphic_2.dispose();

			Image goal_2 = imageIO.myRead("res/2_blue_goal.bmp");
			BufferedImage goalbufferedImage_2 = new BufferedImage(goal_2.getWidth(null),
					goal_2.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics goalGraphic_2 = goalbufferedImage_2.createGraphics();
			goalGraphic_2.drawImage(goal_2, 0, 0, null);
			goalGraphic_2.dispose();
			
			
			assertEquals(blueImage_2.getHeight(null), goal_2.getHeight(null));
			assertEquals(blueImage_2.getWidth(null), goal_2.getWidth(null));
			for (int i = imageIO.biHeight - 1; i >= 0; i--) {
				for (int j = 0; j < imageIO.biWidth; j++) {
					int temp = bufferedImage_2.getRGB(j, i);
					int goal_temp = goalbufferedImage_2.getRGB(j, i);
					assertEquals(temp, goal_temp);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail("IO exception");
		}
		
	}

	/**
	 * {@link ImplementImageProcesser#showChanelG(java.awt.Image)} 的测试方法。
	 */
	@Test
	public void testShowChanelG() {
		ImplementImageIO imageIO = new ImplementImageIO();
		ImplementImageProcesser imageProcesser = new ImplementImageProcesser();
		
		try {
			Image pic_1 = imageIO.myRead("res/1.bmp");
			Image greenImage_1 = imageProcesser.showChanelG(pic_1);
			BufferedImage bufferedImage_1 = new BufferedImage(greenImage_1.getWidth(null),
					greenImage_1.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics graphic_1 = bufferedImage_1.createGraphics();
			graphic_1.drawImage(greenImage_1, 0, 0, null);
			graphic_1.dispose();

			Image goal_1 = imageIO.myRead("res/1_green_goal.bmp");
			BufferedImage goalbufferedImage_1 = new BufferedImage(goal_1.getWidth(null),
					goal_1.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics goalGraphic_1 = goalbufferedImage_1.createGraphics();
			goalGraphic_1.drawImage(goal_1, 0, 0, null);
			goalGraphic_1.dispose();
			
			
			assertEquals(greenImage_1.getHeight(null), goal_1.getHeight(null));
			assertEquals(greenImage_1.getWidth(null), goal_1.getWidth(null));
			for (int i = imageIO.biHeight - 1; i >= 0; i--) {
				for (int j = 0; j < imageIO.biWidth; j++) {
					int temp = bufferedImage_1.getRGB(j, i);
					int goal_temp = goalbufferedImage_1.getRGB(j, i);
					assertEquals(temp, goal_temp);
				}
			}
			
			Image pic_2 = imageIO.myRead("res/2.bmp");
			Image greenImage_2 = imageProcesser.showChanelG(pic_2);
			BufferedImage bufferedImage_2 = new BufferedImage(greenImage_2.getWidth(null),
					greenImage_2.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics graphic_2 = bufferedImage_2.createGraphics();
			graphic_2.drawImage(greenImage_2, 0, 0, null);
			graphic_2.dispose();

			Image goal_2 = imageIO.myRead("res/2_green_goal.bmp");
			BufferedImage goalbufferedImage_2 = new BufferedImage(goal_2.getWidth(null),
					goal_2.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics goalGraphic_2 = goalbufferedImage_2.createGraphics();
			goalGraphic_2.drawImage(goal_2, 0, 0, null);
			goalGraphic_2.dispose();
			
			
			assertEquals(greenImage_2.getHeight(null), goal_2.getHeight(null));
			assertEquals(greenImage_2.getWidth(null), goal_2.getWidth(null));
			for (int i = imageIO.biHeight - 1; i >= 0; i--) {
				for (int j = 0; j < imageIO.biWidth; j++) {
					int temp = bufferedImage_2.getRGB(j, i);
					int goal_temp = goalbufferedImage_2.getRGB(j, i);
					assertEquals(temp, goal_temp);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail("IO exception");
		}

	}

	/**
	 * {@link ImplementImageProcesser#showChanelR(java.awt.Image)} 的测试方法。
	 */
	@Test
	public void testShowChanelR() {
		ImplementImageIO imageIO = new ImplementImageIO();
		ImplementImageProcesser imageProcesser = new ImplementImageProcesser();
		
		try {
			Image pic_1 = imageIO.myRead("res/1.bmp");
			Image redImage_1 = imageProcesser.showChanelR(pic_1);
			BufferedImage bufferedImage_1 = new BufferedImage(redImage_1.getWidth(null),
					redImage_1.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics graphic_1 = bufferedImage_1.createGraphics();
			graphic_1.drawImage(redImage_1, 0, 0, null);
			graphic_1.dispose();

			Image goal_1 = imageIO.myRead("res/1_red_goal.bmp");
			BufferedImage goalbufferedImage_1 = new BufferedImage(goal_1.getWidth(null),
					goal_1.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics goalGraphic_1 = goalbufferedImage_1.createGraphics();
			goalGraphic_1.drawImage(goal_1, 0, 0, null);
			goalGraphic_1.dispose();
			
			
			assertEquals(redImage_1.getHeight(null), goal_1.getHeight(null));
			assertEquals(redImage_1.getWidth(null), goal_1.getWidth(null));
			for (int i = imageIO.biHeight - 1; i >= 0; i--) {
				for (int j = 0; j < imageIO.biWidth; j++) {
					int temp = bufferedImage_1.getRGB(j, i);
					int goal_temp = goalbufferedImage_1.getRGB(j, i);
					assertEquals(temp, goal_temp);
				}
			}
			
			Image pic_2 = imageIO.myRead("res/2.bmp");
			Image redImage_2 = imageProcesser.showChanelR(pic_2);
			BufferedImage bufferedImage_2 = new BufferedImage(redImage_2.getWidth(null),
					redImage_2.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics graphic_2 = bufferedImage_2.createGraphics();
			graphic_2.drawImage(redImage_2, 0, 0, null);
			graphic_2.dispose();

			Image goal_2 = imageIO.myRead("res/2_red_goal.bmp");
			BufferedImage goalbufferedImage_2 = new BufferedImage(goal_2.getWidth(null),
					goal_2.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics goalGraphic_2 = goalbufferedImage_2.createGraphics();
			goalGraphic_2.drawImage(goal_2, 0, 0, null);
			goalGraphic_2.dispose();
			
			
			assertEquals(redImage_2.getHeight(null), goal_2.getHeight(null));
			assertEquals(redImage_2.getWidth(null), goal_2.getWidth(null));
			for (int i = imageIO.biHeight - 1; i >= 0; i--) {
				for (int j = 0; j < imageIO.biWidth; j++) {
					int temp = bufferedImage_2.getRGB(j, i);
					int goal_temp = goalbufferedImage_2.getRGB(j, i);
					assertEquals(temp, goal_temp);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail("IO exception");
		}
	}

	/**
	 * {@link ImplementImageProcesser#showGray(java.awt.Image)} 的测试方法。
	 */
	@Test
	public void testShowGray() {
		ImplementImageIO imageIO = new ImplementImageIO();
		ImplementImageProcesser imageProcesser = new ImplementImageProcesser();
		
		try {
			Image pic_1 = imageIO.myRead("res/1.bmp");
			Image grayImage_1 = imageProcesser.showGray(pic_1);
			BufferedImage bufferedImage_1 = new BufferedImage(grayImage_1.getWidth(null),
					grayImage_1.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics graphic_1 = bufferedImage_1.createGraphics();
			graphic_1.drawImage(grayImage_1, 0, 0, null);
			graphic_1.dispose();

			Image goal_1 = imageIO.myRead("res/1_gray_goal.bmp");
			BufferedImage goalbufferedImage_1 = new BufferedImage(goal_1.getWidth(null),
					goal_1.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics goalGraphic_1 = goalbufferedImage_1.createGraphics();
			goalGraphic_1.drawImage(goal_1, 0, 0, null);
			goalGraphic_1.dispose();
			
			
			assertEquals(grayImage_1.getHeight(null), goal_1.getHeight(null));
			assertEquals(grayImage_1.getWidth(null), goal_1.getWidth(null));
			for (int i = imageIO.biHeight - 1; i >= 0; i--) {
				for (int j = 0; j < imageIO.biWidth; j++) {
					int temp = bufferedImage_1.getRGB(j, i);
					int gray = temp & 0xFF;
					int goal_temp = goalbufferedImage_1.getRGB(j, i);
					int goal_gray = goal_temp & 0xFF;

					assertTrue(Math.abs(gray - goal_gray) < 2);
				}
			}
			
			Image pic_2 = imageIO.myRead("res/2.bmp");
			Image grayImage_2 = imageProcesser.showGray(pic_2);
			BufferedImage bufferedImage_2 = new BufferedImage(grayImage_2.getWidth(null),
					grayImage_2.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics graphic_2 = bufferedImage_2.createGraphics();
			graphic_2.drawImage(grayImage_2, 0, 0, null);
			graphic_2.dispose();

			Image goal_2 = imageIO.myRead("res/2_gray_goal.bmp");
			BufferedImage goalbufferedImage_2 = new BufferedImage(goal_2.getWidth(null),
					goal_2.getHeight(null), BufferedImage.TYPE_INT_RGB);

			Graphics goalGraphic_2 = goalbufferedImage_2.createGraphics();
			goalGraphic_2.drawImage(goal_2, 0, 0, null);
			goalGraphic_2.dispose();
			
			
			assertEquals(grayImage_2.getHeight(null), goal_2.getHeight(null));
			assertEquals(grayImage_2.getWidth(null), goal_2.getWidth(null));
			for (int i = imageIO.biHeight - 1; i >= 0; i--) {
				for (int j = 0; j < imageIO.biWidth; j++) {
					int temp = bufferedImage_2.getRGB(j, i);
					int gray = temp & 0xFF;
					int goal_temp = goalbufferedImage_2.getRGB(j, i);
					int goal_gray = goal_temp & 0xFF;

					assertTrue(Math.abs(gray - goal_gray) < 2);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail("IO exception");
		}
		
	}

}
