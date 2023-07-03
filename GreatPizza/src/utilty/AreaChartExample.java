package utilty;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

//import frame.Pizza_PopUp_Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.InputStream;

public class AreaChartExample {
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
	}
	*/
	
    public static void main(String[] args) {
        // 데이터셋 생성
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        
        XYSeries series1 = new XYSeries("Database");
        XYSeries series2 = new XYSeries("Database2");

        // 데이터 추가
        series1.add(1, 40);
        series1.add(2, 30);
        series1.add(3, 55);
        series1.add(4, 80);
        series1.add(5, 55);
        series1.add(6, 43);
        series1.add(7, 20);
        series1.add(9, 71);
        series1.add(10, 55);
        series1.add(11, 50);
        series1.add(12, 10);
        
        series2.add(1, 40);
        series2.add(2, 30);
        series2.add(3, 55);
        series2.add(4, 80);
        series2.add(5, 55);
        series2.add(6, 43);
        series2.add(7, 20);
        series2.add(9, 71);
        series2.add(10, 55);
        series2.add(11, 50);
        series2.add(12, 10);

        dataset.addSeries(series1);
        dataset2.addSeries(series2);
        

        // 영역 그래프 생성
        JFreeChart chart = ChartFactory.createXYAreaChart(
                "",   // 그래프 제목
                " ",    // x축 레이블
                "",       // y축 레이블
                dataset,       // 데이터셋
                PlotOrientation.VERTICAL, // 그래프 방향
                false,          // 범례 표시 여부
                false,         // 도구 팁 표시 여부
                false          // URL 생성 여부
        );
        
      
        
        // 배경색 설정
        chart.setBackgroundPaint(new Color(23, 24, 33));
        

        // 영역 색상 및 그라데이션 설정
        XYPlot plot = (XYPlot) chart.getPlot();
        XYAreaRenderer renderer = (XYAreaRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.CYAN);
        //Font axisF = tftFont;

        // 그라데이션 생성
        GradientPaint gradientPaint = new GradientPaint(
        		new Point2D.Double(0, 0), new Color(169, 223, 216),
        		new Point2D.Double(0, 1), new Color(23, 24, 33));

        // 그라데이션 적용
        renderer.setSeriesPaint(0, gradientPaint);
        renderer.setSeriesFillPaint(0, gradientPaint);

        // X축 설정
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        //plot.getRangeAxis().setTickLabelFont(axisF);
        plot.getRangeAxis().setTickLabelPaint(new Color(169, 223, 216));
        
        
        
        // Y축 설정
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        //plot.getDomainAxis().setTickLabelFont(axisF);
        plot.getDomainAxis().setTickLabelsVisible(false);        
        
        // 차트 패널 생성
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(new Dimension(400, 280));  
        
        // 차트 패널의 크기 조정
        Dimension preferredSize = new Dimension(400, 280);
        chartPanel.setPreferredSize(preferredSize);
        
        JPanel newpnl = new JPanel();
        newpnl.setSize(new Dimension(400, 280));
        newpnl.add(chartPanel);

        // 차트를 포함하는 프레임 생성
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(newpnl);
        chartPanel.setSize(new Dimension(600,900));   
        frame.pack();
        
        frame.setSize(800,500);
        frame.setVisible(true);
        

        // 플롯 영역의 배경색 설정
        plot.setBackgroundPaint(new Color(23, 24, 33));
        //renderer.setOutline(true);

    }
}
