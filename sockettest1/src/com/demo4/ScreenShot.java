package com.demo4;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
* 
* @ClassName: ScreenShot 
* @Description: 用于截屏的工具类，提供了截屏、缩放图片等功能 
* @author adice 
* @date 2018年6月13日 下午2:35:27 
*
 */
public class ScreenShot {
	private static Robot robot;
	public static Robot getRobotInstance(){
		if(robot != null){
			return robot;
		}else{
			try {
				robot = new Robot();
				return robot;
			} catch (AWTException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
	
	/**
	 * 截屏
	 * @return
	 */
	public static BufferedImage getScreen(){
		robot = ScreenShot.getRobotInstance();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dm = toolkit.getScreenSize();
		//一个矩形面板
		Rectangle rec = new Rectangle(0, 0, (int)dm.getWidth(), (int)dm.getHeight());
		//按照矩形截取图片到缓冲流
		BufferedImage img = robot.createScreenCapture(rec);
		return img;
	}
	
	/**
	 * 缩放图片
	 * @param img
	 * @param newW
	 * @param newH
	 * @return
	 */
	public static BufferedImage resize(BufferedImage img, int newW, int newH){
		//创建一个缩放后的图片流
		BufferedImage newImg = new BufferedImage(newW,newH,img.getType());
		Graphics2D g = newImg.createGraphics();
		//设置模式
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		//按比例缩放
		g.drawImage(img, 0, 0, newW, newH, 0, 0, img.getWidth(), img.getHeight(), null);
		g.dispose();
		return newImg;
	}
}
