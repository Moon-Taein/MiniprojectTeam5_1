package frame;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImagePlus {

	private static String outputPath;
	private static String outputPathBig;

	// 파일의 확장자를 반환하는 메서드
	private static String getFileExtension(String selectedFile) {
		String extension = "";
		int dotIndex = selectedFile.lastIndexOf(".");
		if (dotIndex > 0 && dotIndex < selectedFile.length() - 1) {
			extension = selectedFile.substring(dotIndex + 1).toLowerCase();
		}
		return extension;
	}

	// 이미지 파일 확장자인지 확인하는 메서드
	private static boolean isImageExtension(String extension) {
		return extension.equals("jpg") || extension.equals("jpeg") || extension.equals("png")
				|| extension.equals("gif");
		// 원하는 이미지 확장자를 추가로 확인할 수 있습니다.
	}

	public static byte[] fileToBytes(String filePath) {
		byte[] bytes = null;

		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);

			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int bytesRead;

			while ((bytesRead = bis.read(buffer, 0, bufferSize)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}

			bis.close();
			fis.close();

			bytes = bos.toByteArray();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bytes;

	}
	
	public static byte[] bigFileToBytes(String filePath) {
		byte[] bytes = null;

		try {
			File file = new File(filePath);
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);

			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int bytesRead;

			while ((bytesRead = bis.read(buffer, 0, bufferSize)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}

			bis.close();
			fis.close();

			bytes = bos.toByteArray();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bytes;

	}

	private static boolean isFileSizeValid(String filePath) {

		File file = new File(filePath);

		// 파일 크기 제약을 확인하는 로직을 구현
		// 필요한 경우 파일의 크기를 확인하고 제약을 적용
		// 반환 값은 제약 조건을 만족하는지 여부 (true 또는 false)
		long fileSize = file.length();

		// 파일 크기가 2MB(2,000,000 바이트) 이하인지 확인

		return fileSize <= 2_000_000;
	}

	private static boolean isImageDimensionsValid(String filePath) {
		// 이미지 크기 제약을 확인하는 로직을 구현
		// 필요한 경우 파일을 이미지로 로드하고 크기를 확인하고 제약을 적용
		// 반환 값은 제약 조건을 만족하는지 여부 (true 또는 false)
		return true;
	}

	private static String ImageResizeExampleBig(String imagePath) {

		try {
			// 이미지 파일 로드
			BufferedImage originalImage = ImageIO.read(new File(imagePath));// 입력 이미지 파일 경로

			// 변경할 사이즈 지정
			int newWidth = 410; // 새로운 너비
			int newHeight = 380; // 새로운 높이

			// 이미지 크기 변경
			BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

			// Graphics2D 객체를 사용하여 변경된 이미지 그리기
			Graphics2D graphics2D = resizedImage.createGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			graphics2D.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
			graphics2D.dispose();

			// 변경된 이미지를 저장할 BufferedImage 생성
			BufferedImage resizedBufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

			// 투명한 배경으로 그래픽 컨텍스트 생성
			Graphics2D transparentGraphics = resizedBufferedImage.createGraphics();
			transparentGraphics.setComposite(AlphaComposite.Clear);
			transparentGraphics.fillRect(0, 0, newWidth, newHeight);
			transparentGraphics.setComposite(AlphaComposite.Src);
			transparentGraphics.drawImage(resizedImage, 0, 0, null);
			transparentGraphics.dispose();

			outputPathBig = "D:\\resized_Big_image.png";
			File outputFile = new File(outputPath);
			ImageIO.write(resizedBufferedImage, "png", outputFile);

			return outputPathBig;

		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}
	
	private static String ImageResizeExample(String imagePath) {

		try {
			// 이미지 파일 로드
			BufferedImage originalImage = ImageIO.read(new File(imagePath));// 입력 이미지 파일 경로

			// 변경할 사이즈 지정
			int newWidth = 180; // 새로운 너비
			int newHeight = 150; // 새로운 높이

			// 이미지 크기 변경
			BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);

			// Graphics2D 객체를 사용하여 변경된 이미지 그리기
			Graphics2D graphics2D = resizedImage.createGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			graphics2D.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
			graphics2D.dispose();

			// 변경된 이미지를 저장할 BufferedImage 생성
			BufferedImage resizedBufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

			// 투명한 배경으로 그래픽 컨텍스트 생성
			Graphics2D transparentGraphics = resizedBufferedImage.createGraphics();
			transparentGraphics.setComposite(AlphaComposite.Clear);
			transparentGraphics.fillRect(0, 0, newWidth, newHeight);
			transparentGraphics.setComposite(AlphaComposite.Src);
			transparentGraphics.drawImage(resizedImage, 0, 0, null);
			transparentGraphics.dispose();

			outputPath = "D:\\resized_image.png";
			File outputFile = new File(outputPath);
			ImageIO.write(resizedBufferedImage, "png", outputFile);

			return outputPath;

		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}

	public static void imagePlusFrame(MenuPopup menupopup) {
		JFrame frame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();

		FileNameExtensionFilter filter = new FileNameExtensionFilter("이미지 파일", "jpg", "jpeg", "png", "gif");
		fileChooser.setFileFilter(filter);

		// 바탕 화면 경로 설정
		String desktopPath = System.getProperty("user.home") + "/Desktop";
		File desktopDirectory = new File(desktopPath);
		fileChooser.setCurrentDirectory(desktopDirectory);

		int returnValue = fileChooser.showOpenDialog(frame);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			String filePath = fileChooser.getSelectedFile().getAbsolutePath();
			// 선택된 파일에 대한 처리를 수행합니다.

			// 파일 확장자 확인
			String extension = getFileExtension(filePath);

			String path = outputPath;
			menupopup.addImage(path);
		}


		// 바탕 화면에 프레임이 표시되도록 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500); // 프레임의 크기 설정
		frame.setLocationRelativeTo(null); // 화면 중앙에 위치하도록 설정
	}

	private static void saveBytesToFile(byte[] bytes, String filePath) {
		try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
			fos.write(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
