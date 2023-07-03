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
import java.util.List;
import java.util.Map;

public class AreaChart extends JPanel {
	
	private XYSeries series1;
	private XYSeries series2;

	public AreaChart(Map<Integer, List<String>> months) {
        // 데이터셋 생성
        XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeriesCollection dataset2 = new XYSeriesCollection();
        
        series1 = new XYSeries("Database");
        series2 = new XYSeries("Database2");

		for (int i = 1; i <= 12; i++) {
			if (months.get(i) != null) {
				int money = Integer.valueOf(months.get(i).get(1));
				series1.add(i, money);
				series2.add(i, money);
			}
		}

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
        chart.setBackgroundPaint(Color.decode("#21222D"));
        

        // 영역 색상 및 그라데이션 설정
        XYPlot plot = (XYPlot) chart.getPlot();
        XYAreaRenderer renderer = (XYAreaRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.CYAN);
        //Font axisF = tftFont;

        // 그라데이션 생성
        GradientPaint gradientPaint = new GradientPaint(
        		new Point2D.Double(0, 0), new Color(169, 223, 216),
        		new Point2D.Double(0, 1), Color.decode("#21222D"));

        // 그라데이션 적용
        renderer.setSeriesPaint(0, gradientPaint);
        renderer.setSeriesFillPaint(0, gradientPaint);

        // X축 설정
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        //plot.getRangeAxis().setTickLabelFont(axisF);
        plot.getRangeAxis().setTickLabelPaint(Color.WHITE);
        
        // Y축 설정
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        //plot.getDomainAxis().setTickLabelFont(axisF);
        plot.getDomainAxis().setTickLabelsVisible(false);        
        
        // 차트 패널 생성
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(new Dimension(570, 265));  
        
        // 차트 패널의 크기 조정
        Dimension preferredSize = new Dimension(570, 265);
        chartPanel.setPreferredSize(preferredSize);
        
        setSize(new Dimension(400, 280));
        add(chartPanel);

//        // 차트를 포함하는 프레임 생성
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(newpnl);
//        chartPanel.setSize(new Dimension(600,900));   
//        frame.pack();
//        
//        frame.setSize(800,500);
//        frame.setVisible(true);

        // 플롯 영역의 배경색 설정
        plot.setBackgroundPaint(Color.decode("#21222D"));
        //renderer.setOutline(true);

    }
}
