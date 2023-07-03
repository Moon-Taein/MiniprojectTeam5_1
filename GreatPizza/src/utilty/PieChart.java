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


public class PieChart extends JPanel {
	
	public PieChart() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("1", 40);
		dataset.setValue("2", 30);
		dataset.setValue("3", 20);
		dataset.setValue("4", 10);
		
		JFreeChart chart = ChartFactory.createPieChart(
			    "",     // 그래프 제목
			    dataset,         // 데이터셋
			    false,            // 범례 표시 여부
			    false,            // 도구 모음 표시 여부
			    false            // URL 링크 표시 여부
			);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(310, 200));

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
		plot.setLabelBackgroundPaint(Color.decode("#21222D"));
		plot.setLabelPaint(new Color(169, 223, 216));
		plot.setLabelOutlinePaint(Color.decode("#21222D"));
		plot.setBackgroundPaint(Color.decode("#21222D"));
        chart.setBackgroundPaint(Color.decode("#21222D"));
        
        this.add(chartPanel);
        this.setOpaque(false);
	}
}
