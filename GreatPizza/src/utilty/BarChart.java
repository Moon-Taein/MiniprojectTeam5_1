package utilty;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class BarChart extends JPanel {
	
    public BarChart(String x, String date) {
    	int z = Integer.valueOf(x);
        // 데이터셋 생성 및 값 추가
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        if (date == "MONDAY") {
        	dataset1.setValue(z, "Database 1", "Category 1");
        } else if (date == "TUESDAY") {
        	dataset1.setValue(14, "Database 1", "Category 1");
        	dataset1.addValue(z, "Database 1", "Category 2");
        } else if (date == "WEDNESDAY") {
        	dataset1.setValue(14, "Database 1", "Category 1");
        	dataset1.addValue(16, "Database 1", "Category 2");
        	dataset1.addValue(z, "Database 1", "Category 3");
        } else if (date == "THURSDAY") {
        	dataset1.setValue(14, "Database 1", "Category 1");
        	dataset1.addValue(16, "Database 1", "Category 2");
        	dataset1.addValue(20, "Database 1", "Category 3");
        	dataset1.addValue(z, "Database 1", "Category 4");
        } else if (date == "FRIDAY") {
        	dataset1.addValue(z, "Database 1", "Category 5");
        } else if (date == "SATURDAY") {
        	dataset1.addValue(z, "Database 1", "Category 6");
        } else if (date == "SUNDAY") {
        	dataset1.addValue(z, "Database 1", "Category 7");
        }

        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2.addValue(14, "Database 2", "Category 1");
        dataset2.addValue(18, "Database 2", "Category 2");
        dataset2.addValue(11, "Database 2", "Category 3");
        dataset2.addValue(12, "Database 2", "Category 4");
        dataset2.addValue(13, "Database 2", "Category 5");
        dataset2.addValue(16, "Database 2", "Category 6");
        dataset2.addValue(14, "Database 2", "Category 7");

        // 데이터셋 병합
        DefaultCategoryDataset mergedDataset = new DefaultCategoryDataset();
        for (int i = 0; i < dataset1.getRowCount(); i++) {
            Comparable seriesKey = dataset1.getRowKey(i);
            for (int j = 0; j < dataset1.getColumnCount(); j++) {
                Comparable categoryKey = dataset1.getColumnKey(j);
                double value = dataset1.getValue(i, j).doubleValue();
                mergedDataset.addValue(value, seriesKey, categoryKey);
            }
        }
        for (int i = 0; i < dataset2.getRowCount(); i++) {
            Comparable seriesKey = dataset2.getRowKey(i);
            for (int j = 0; j < dataset2.getColumnCount(); j++) {
                Comparable categoryKey = dataset2.getColumnKey(j);
                double value = dataset2.getValue(i, j).doubleValue();
                mergedDataset.addValue(value, seriesKey, categoryKey);
            }
        }

        // 막대 그래프 생성
        JFreeChart chart = ChartFactory.createBarChart(
                "",   // 그래프 제목
                "",    // x축 레이블
                "",       // y축 레이블
                mergedDataset, // 병합한 데이터셋 사용
                PlotOrientation.VERTICAL, // 그래프 방향
                false,          // 범례 표시 여부
                false,         // 도구 팁 표시 여부
                false          // URL 생성 여부
        );
        
        // 배경색 설정
        chart.setBackgroundPaint(Color.decode("#21222D"));

        // 막대 색상 설정
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setShadowVisible(false);
        renderer.setShadowVisible(false);  // 그래프 그림자 비활성화
        renderer.setSeriesPaint(0, new Color(169, 223, 216));
        renderer.setSeriesPaint(1, Color.decode("#87888C"));

        // 막대 너비 및 간격 설정
        double barWidth = 0.3; // 막대의 너비
        double categoryMargin = 0; // 막대 사이의 간격
        renderer.setMaximumBarWidth(barWidth);
        renderer.setItemMargin(categoryMargin);
        
        // X축 설정
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryMargin(0.2);
        domainAxis.setTickLabelsVisible(false);  

        // Y축 설정
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        rangeAxis.setTickLabelsVisible(false);  

        // 차트 패널 생성
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(new Dimension(570, 265)); 
        
        // ChartPanel 내부 JPanel의 배경색 설정
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.setBackgroundPaint(Color.decode("#21222D"));
        
        Dimension preferredSize = new Dimension(570, 265);
        chartPanel.setPreferredSize(preferredSize);
        
        setSize(new Dimension(570, 265));
        add(chartPanel);
        
        plot.setBackgroundPaint(Color.decode("#21222D"));
    }
}