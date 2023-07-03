package utilty;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DefaultDrawingSupplier;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.data.general.DefaultPieDataset;

//import frame.Pizza_PopUp_Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Paint;
import java.io.InputStream;

import javax.swing.*;


public class pieChartExample {
	/*
	private static Font tftFont = getBMJUAFont(18f);

	private static Font getBMJUAFont(float f) {
		// TFT 폰트 파일 로드
		InputStream fontStream = Pizza_PopUp_Frame.class.getResourceAsStream("/popup/BMJUA_ttf.ttf");
		Font tftFont;
		try {
			tftFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
			tftFont = tftFont.deriveFont(f);
			return tftFont;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}*/
	
	public static void main(String[] args) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("1", 30);
		dataset.setValue("2", 20);
		dataset.setValue("3", 10);
		dataset.setValue("4", 40);
		
		JFreeChart chart = ChartFactory.createPieChart(
			    "",     // 그래프 제목
			    dataset,         // 데이터셋
			    false,            // 범례 표시 여부
			    false,            // 도구 모음 표시 여부
			    false            // URL 링크 표시 여부
			);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setSize(new Dimension(400, 280)); 
		
		// 차트의 Plot 객체 가져오기

		PiePlot plot = (PiePlot) chart.getPlot();
		
		plot.setOutlineVisible(false);
		plot.setShadowPaint(new Color(0, 0, 0, 0));

		// DrawingSupplier 생성
		DefaultDrawingSupplier supplier = new DefaultDrawingSupplier(
		        new Paint[] {new Color(252, 184, 89), new Color(169, 223, 216), new Color(40, 174, 243), new Color(242, 200, 237)},
		        DefaultDrawingSupplier.DEFAULT_FILL_PAINT_SEQUENCE,
		        DefaultDrawingSupplier.DEFAULT_OUTLINE_PAINT_SEQUENCE,
		        DefaultDrawingSupplier.DEFAULT_STROKE_SEQUENCE,
		        DefaultDrawingSupplier.DEFAULT_OUTLINE_STROKE_SEQUENCE,
		        DefaultDrawingSupplier.DEFAULT_SHAPE_SEQUENCE
		);

		plot.setDrawingSupplier(supplier);

		// 배경색 설정
		//Font axisF = tftFont;
		plot.setLabelBackgroundPaint(new Color(23, 24, 33));
		//plot.setLabelFont(axisF);
		plot.setLabelPaint(new Color(169, 223, 216));
		plot.setLabelOutlinePaint(new Color(23, 24, 33));
		plot.setBackgroundPaint(new Color(23, 24, 33));
        chart.setBackgroundPaint(new Color(23, 24, 33));

		JFrame frame = new JFrame("Pie Chart Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(chartPanel);
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	
	

}
