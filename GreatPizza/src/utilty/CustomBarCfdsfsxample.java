package utilty;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;

public class CustomBarCfdsfsxample {
    public static void main(String[] args) {
        // 데이터셋 생성
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Series 1", "Category 1");
        dataset.addValue(15, "Series 1", "Category 2");
        dataset.addValue(7, "Series 1", "Category 3");
        dataset.addValue(22, "Series 1", "Category 4");
        dataset.addValue(18, "Series 1", "Category 5");

        // 막대 그래프 생성
        JFreeChart chart = ChartFactory.createBarChart(
                "Custom Bar Chart", // 차트 제목
                "Category", // X축 레이블
                "Value", // Y축 레이블
                dataset // 데이터셋
        );

        // 막대 그래프 커스터마이징
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        int count = dataset.getColumnCount();
        for (int i = 0; i < count; i++) {
            Color color = new Color(0, 0, 255 - (i * (255 / count))); // 아래로 갈수록 연해지도록 색상 계산
            renderer.setSeriesPaint(i, color);
        }

        // X축 레이블 위치 설정
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

        // Y축 범위 설정
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setRange(0, 25);

        // 차트를 프레임에 표시
        ChartFrame frame = new ChartFrame("Custom Bar Chart", chart);
        frame.pack();
        frame.setVisible(true);
    }
}