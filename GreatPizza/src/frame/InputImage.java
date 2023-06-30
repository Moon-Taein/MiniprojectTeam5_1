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

public class InputImage {

	private static byte[] bigBytes;

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

	private static byte[] fileToBytes(String filePath) {
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

			// 이미지를 PNG 파일로 저장
			String outputPath = "resized_image.png"; // 저장할 이미지 파일 경로
			File outputFile = new File(outputPath);
			ImageIO.write(resizedBufferedImage, "png", outputFile);

			return outputPath;

		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}
	
	// 빅사이즈로 리사이징 해주는 놈
	private static String ImageResizeBig(String imagePath) {

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

			// 이미지를 PNG 파일로 저장
			String outputPath = "resized_Big_image.png"; // 저장할 이미지 파일 경로
			File outputFile = new File(outputPath);
			ImageIO.write(resizedBufferedImage, "png", outputFile);

			return outputPath;

		} catch (IOException e) {
			e.printStackTrace();

		}
		return null;
	}

	public static void inputIMAGE(MenuPopup menupopup) {
		JFrame frame = new JFrame();
		JFileChooser fileChooser = new JFileChooser();
		
		String userHome = System.getProperty("user.home");
	    fileChooser.setCurrentDirectory(new File(userHome + "/Desktop"));

		FileNameExtensionFilter filter = new FileNameExtensionFilter("이미지 파일", "jpg", "jpeg", "png", "gif");
		fileChooser.setFileFilter(filter);

		int returnValue = fileChooser.showOpenDialog(frame);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			String filePath = fileChooser.getSelectedFile().getAbsolutePath();
			// 선택된 파일에 대한 처리를 수행합니다.

			// 파일 확장자 확인
			String extension = getFileExtension(filePath);

			if (isFileSizeValid(filePath) && isImageDimensionsValid(filePath) && isImageExtension(extension)) {
				// 파일 제약 조건을 만족하는 경우
				// 파일 경로를 출력하거나 원하는 처리를 수행
//				System.out.println("선택된 파일 경로: " + filePath);
				
				String newfilePath = ImageResizeExample(filePath);
				String twofilePath = ImageResizeBig(filePath);
				byte[] fileBytes = fileToBytes(newfilePath);
				bigBytes = fileToBytes(twofilePath);
				menupopup.addImage(fileBytes);


				// 추가적인 파일 처리 작업 수행
			} else {
				// 파일 제약 조건을 만족하지 않는 경우
				System.out.println("선택된 파일은 제약 조건을 만족하지 않습니다.");
				System.out.println(isFileSizeValid(filePath));
				System.out.println(isImageDimensionsValid(filePath));
				System.out.println(!isImageExtension(extension));
				// 필요한 처리를 수행하거나 에러 메시지를 표시
				// ...
			}
		}
	}

	public byte[] getBytes() {
		return bigBytes;
	}
}
