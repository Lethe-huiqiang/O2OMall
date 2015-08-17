package com.jixie.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图片压缩-余俭
 * @author Administrator
 *
 */
public class ImageCompress {
	
	   /**
	    * 缩放图像(等比缩放)___水印处理 New(推荐使用该方法)
	    * @param file    (File)上传得到的文件(注意，必须是实际存在的)
	    * @param root 	       (String)保存目录
	    * @param fileName 	   (String)保存文件名
	    * @param objectFile 	(File)保存目标图像文件——为null，则不压缩
	    * @param MaxWidth   (double)目标图像最大宽度——若为0，则不压缩
	    * @param MaxHeight 	(double)目标图像最大高度——若为0，则不压缩
	    * @param waterMark 	(String)水印图像文件路径——若为null,则不加水印
	    */
	  //《<<<<高效压缩图像，并能够最大限度保持质量,推荐用>>>>>》
	   public String zoomImageNew (File file,String root,String fileName, File objectFile, double maxWidth ,double maxHeight, String waterMark){
		   try {
			    File sourceFile=new File(root,fileName);
				InputStream is = new FileInputStream(file);
				OutputStream os = new FileOutputStream(sourceFile);
				byte[] buffer = new byte[2048];
				int len = 0 ;
				int total = 0;
				while((len=is.read(buffer))!=-1){
					total += len;
					os.write(buffer, 0, len);
				}
				os.close();
				is.close();
				//判断图片大小
				if(total>20480*100){
					System.out.println("图片太大！！！");//2M
					sourceFile.delete();
					return "big";
				}else{
					   BufferedImage sourceImage = ImageIO.read(sourceFile); //读入文件
			           int width = sourceImage.getWidth(); //源图宽
			           int height = sourceImage.getHeight(); //源图长
				        if(maxWidth!=0&&maxHeight!=0){
				        // 为等比缩放计算输出的图片宽度及高度  
				          double rate1 = ((double) width) / (double) maxWidth * 1.0;  
				          double rate2 = ((double) height) / (double) maxHeight * 1.0;  
				        // 根据缩放比率大的进行缩放控制  
				          double rate = rate1 > rate2 ? rate1 : rate2;  
				          int tWidth = (int) (((double) width) / rate);  //缩放后图宽
				          int tHeight = (int) (((double) height) / rate);  //缩放后图长
				          System.out.println(tWidth+"   "+tHeight);
				          try{
				        	  Thumbnails.of(sourceFile).size((int)maxWidth,(int)maxHeight).toFile(objectFile);//《<<<<高效压缩图像，并能够最大限度保持质量>>>>>》
				          }catch(Exception e){
				        	  System.out.println("transmit photo error");
				        	  e.printStackTrace();
				        	  return "error";
				          }finally{
//				        	  sourceFile.delete();//删除原图  可选！
				          }
				          addWaterMarkForImage(objectFile,waterMark);//添加水印
				          addWaterMarkForImage(sourceFile,waterMark);//添加水印
				          System.out.println("成功执行缩放！");
				        }
				        //addWaterMarkForImage(sourceFile,waterMark);//添加水印
				        return "success";
				}
			} catch (IOException e) {
				System.out.println("transmit photo error2");
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
			}
		
	}     
	  
	   /**
	    * 为图像添加水印___水印处理
	    * @param sourceFile    (File)源文件(注意，必须是实际存在的)
	    * @param waterMark 	(String)水印图像文件路径
	    */
	   public void addWaterMarkForImage (File sourceFile , String waterMark){
		   try {
			   if(null!=waterMark){
			   BufferedImage sourceImage = ImageIO.read(sourceFile); //读入文件
	           int width = sourceImage.getWidth(); //源图宽
	           int height = sourceImage.getHeight(); //源图长
			 /********************水印图处理，控制它与源图的比例为1:3***********************/
		        int miniMaxWidth = (int)width/3;//水印与源图的比例为1:3
				int miniMaxHeight = (int)height/3;
				
			   BufferedImage waterImage = ImageIO.read(new File(waterMark)); //读入水印文件
	           int wWidth = waterImage.getWidth(); //水印源图宽
	           int wHeight = waterImage.getHeight(); //水印源图长
	           
			  if(miniMaxWidth>=1&&miniMaxHeight>=1){
				  	  //等比压缩水印图
			          double rateW = ((double) wWidth) / (double) miniMaxWidth * 1.0;  
			          double rateH = ((double) wHeight) / (double) miniMaxHeight * 1.0;  
			          double rateA = rateW > rateH ? rateW : rateH;  //水印图缩放比例
			          double rateT=rateA>1?1/rateA:rateA;
			          BufferedImage miniWatermarkImage = Thumbnails.of(waterImage).scale(rateT).asBufferedImage();//生成缩放水印图对象
			          //缩放水印图相关参数
					  int  mWidth = miniWatermarkImage.getWidth(null);//缩放水印图宽
					  int  mHeight =  miniWatermarkImage.getHeight(null);//缩放水印图长

					  BufferedImage bimage  =   new  BufferedImage(width,height, BufferedImage.TYPE_INT_RGB); 
					  Graphics2D g = bimage.createGraphics( );
					  g.setColor(Color.red);
					  g.setBackground(Color.white);
					  g.drawImage(sourceImage,  0 ,  0 ,  null);
					  int rWidth = width-mWidth-15;//水印图相对母图位置
					  int rHeight = height-mHeight-15;
					  if(rWidth<=0||rHeight<=0){
						  g.drawString( "千千结水印图像" , 15 ,15);  // 添加文字 
						  g.dispose();
						  System.out.println("加文字水印！");
					  }else{
						  g.drawImage(miniWatermarkImage,  rWidth , rHeight , null );
						  g.dispose();
						  System.out.println("加图像水印！");
					  }
					  FileOutputStream out = new  FileOutputStream(sourceFile);
					  JPEGImageEncoder encoder  = JPEGCodec.createJPEGEncoder(out); 
					  JPEGEncodeParam param  =  encoder.getDefaultJPEGEncodeParam(bimage); 
					  param.setQuality(50f,  true ); 
					  encoder.encode(bimage, param); 
					  out.close();
			      }
			   }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}       
   /**
    * 缩放图像(按最大的宽和长进行缩放,如果原图片比最大宽和长要小保留源图片)
    * @param sourceFile 	(File)源图像文件
    * @param objectFile 	(File)保存目标图像文件
    * @param MaxWidth     	(double)目标图像最大宽度
    * @param MaxHeight     	(double)目标图像最大高度
    */
   public void compressImage (File sourceFile, File objectFile, double MaxWidth ,double MaxHeight)
 	{
	   boolean flag = true;//默认对图片缩放，如果原图片比最大宽和长要小保留源图片，不进行缩放
       try
       {
           BufferedImage sourceImage = ImageIO.read(sourceFile); //读入文件
           int width = sourceImage.getWidth(); //源图宽
           int height = sourceImage.getHeight(); //源图长
           //计算新图片的大小
           if(height<=width){
        	   if (width<=MaxWidth) {
        		   flag = false;
        	   }else{
        		   height = (int)((height*MaxWidth)/width);
        		   width = (int) MaxWidth;
        	   }
           }else{
        	   if(height<=MaxHeight){
        		   flag = false;
        	   }else{
        		   width=(int)((width*MaxHeight)/height);
        		   height=(int) MaxHeight;
        	   }
           }
           if(flag){
        	   Image image = sourceImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
               BufferedImage tagImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
               Graphics g = tagImage.getGraphics();
               g.drawImage(image, 0, 0, null); // 绘制缩小后的图
               g.dispose();
               ImageIO.write(tagImage, "JPEG", objectFile);// 输出到文件流 
           }else{
        	   	//不更改原图，直接生成原图
        	   	InputStream is = new FileInputStream(sourceFile);
				OutputStream os = new FileOutputStream(objectFile);
				byte[] buffer = new byte[1024];
				int len = 0 ;
				while((len=is.read(buffer))!=-1){
					os.write(buffer, 0, len);
				}
				os.close();
				is.close();
           }
           System.out.println("执行成功！");
       }
       catch (IOException e)
      	{
    	   System.out.println("compressImage错误"+e);
       }
   }
	
	
	
	/**
    * 缩放图像(按比例缩放)
    * @param (String)sourceString 	源图像文件
    * @param (String)objectString     保存目标图像文件
    * @param (double)scale      	缩放比例:百分比用小数表示
    */
   public void compressImage(String sourceString, String  objectString, double scale)
 	{
       try
       {
           BufferedImage sourceImage = ImageIO.read(new File(sourceString)); // 读入文件
           int width = sourceImage.getWidth(); // 得到源图宽
           int height = sourceImage.getHeight(); // 得到源图长
           width = (int) (width * scale);//计算新图片的宽
           height = (int) (height * scale);//计算新图片的长
           Image image = sourceImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
           BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
           Graphics g = tag.getGraphics();
           g.drawImage(image, 0, 0, null); // 绘制缩小后的图
           g.dispose();
           ImageIO.write(tag, "JPEG", new File(objectString));// 输出到文件流
       }
       catch (Exception e)
      	{
           System.out.println("compressImage错误"+e);
       }
   }
   
   /**
    * 缩放图像(按比例缩放)
    * @param (File)sourceFile 		源图像文件
    * @param (File)objectFile 		保存目标图像文件
    * @param (double)scale     	 	缩放比例:百分比用小数表示
    */
   public void compressImage (File sourceFile, File objectFile, double scale)
 	{
       try
       {
           BufferedImage sourceImage = ImageIO.read(sourceFile); // 读入文件
           int width = sourceImage.getWidth(); // 得到源图宽
           int height = sourceImage.getHeight(); // 得到源图长
           width = (int) (width * scale);//计算新图片的宽
           height = (int) (height * scale);//计算新图片的长
           Image image = sourceImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
           BufferedImage tagImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
           Graphics g = tagImage.getGraphics();
           g.drawImage(image, 0, 0, null); // 绘制缩小后的图
           g.dispose();
           ImageIO.write(tagImage, "JPEG", objectFile);// 输出到文件流
       }
       catch (IOException e)
      	{
    	   System.out.println("compressImage错误"+e);
       }
   }
   
}
