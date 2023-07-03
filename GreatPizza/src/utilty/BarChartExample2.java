package utilty;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnitSource;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;

public class BarChartExample2 {
    public static void main(String[] args) {
        // 데이터셋 생성 및 값 추가
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();
        dataset1.addValue(50, "Database 1", "Category 1");
        dataset1.addValue(0, "Database 1", "Category 2");
        dataset1.addValue(0, "Database 1", "Category 3");
        dataset1.addValue(0, "Database 1", "Category 4");


        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();
        dataset2.addValue(0, "Database 2", "Category 1");
        dataset2.addValue(20, "Database 2", "Category 2");
        dataset2.addValue(0, "Database 2", "Category 3");
        dataset2.addValue(0, "Database 2", "Category 4");

        DefaultCategoryDataset dataset3 = new DefaultCategoryDataset();
        dataset3.addValue(0, "Database 3", "Category 1");
        dataset3.addValue(0, "Database 3", "Category 2");
        dataset3.addValue(80, "Database 3", "Category 3");
        dataset3.addValue(0, "Database 3", "Category 4");

        DefaultCategoryDataset dataset4 = new DefaultCategoryDataset();
        dataset4.addValue(0, "Database 4", "Category 1");
        dataset4.addValue(0, "Database 4", "Category 2");
        dataset4.addValue(0, "Database 4", "Category 3");
        dataset4.addValue(20, "Database 4", "Category 4");
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
        
        for (int i = 0; i < dataset3.getRowCount(); i++) {
            Comparable seriesKey = dataset3.getRowKey(i);
            for (int j = 0; j < dataset3.getColumnCount(); j++) {
                Comparable categoryKey = dataset3.getColumnKey(j);
                double value = dataset3.getValue(i, j).doubleValue();
                mergedDataset.addValue(value, seriesKey, categoryKey);
            }
        }

        for (int i = 0; i < dataset4.getRowCount(); i++) {
            Comparable seriesKey = dataset4.getRowKey(i);
            for (int j = 0; j < dataset4.getColumnCount(); j++) {
                Comparable categoryKey = dataset4.getColumnKey(j);
                double value = dataset4.getValue(i, j).doubleValue();
                mergedDataset.addValue(value, seriesKey, categoryKey);
            }
        }
        
        // 막대 그래프 생성
        JFreeChart chart = ChartFactory.createBarChart(
                "",   // 그래프 제목
                "",    // x축 레이블
                "",       // y축 레이블
                mergedDataset, // 병합한 데이터셋 사용
                PlotOrientation.HORIZONTAL, // 그래프 방향
                false,          // 범례 표시 여부
                false,         // 도구 팁 표시 여부
                false          // URL 생성 여부
        );
        
        // 배경색 설정
        chart.setBackgroundPaint(new Color(23, 24, 33));

        // 막대 색상 설정
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());
        renderer.setShadowVisible(false);
        renderer.setShadowVisible(false);  // 그래프 그림자 비활성화
        renderer.setSeriesPaint(0, new Color(252, 184, 89));
        renderer.setSeriesPaint(1, new Color(169, 223, 216));
        renderer.setSeriesPaint(2, new Color(40, 174, 243));
        renderer.setSeriesPaint(3, new Color(242, 200, 237));

        
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
        rangeAxis.setStandardTickUnits(new NumberTickUnitSource());
        rangeAxis.setTickLabelsVisible(false);  

        // 차트 패널 생성
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setSize(new Dimension(400, 280)); 
        
        // ChartPanel 내부 JPanel의 배경색 설정
        CategoryPlot categoryPlot = chart.getCategoryPlot();
        categoryPlot.setBackgroundPaint(new Color(23, 24, 33));


        // 차트를 포함하는 프레임 생성
        JFrame frame = new JFrame("Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(400, 280)); 
    }
}