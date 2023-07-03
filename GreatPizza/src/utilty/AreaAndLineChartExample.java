package utilty;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.AreaRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class AreaAndLineChartExample {

    public static void main(String[] args) {
        // 데이터 생성
        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); // AreaChart용 데이터셋
        DefaultCategoryDataset dataset2 = new DefaultCategoryDataset(); // LineChart용 데이터셋
        
        // 데이터 입력 ( 값, 범례, 카테고리 )
        dataset1.addValue(10, "Series 1", "Category 1");
        dataset1.addValue(5, "Series 1", "Category 2");
        dataset1.addValue(15, "Series 1", "Category 3");
        
        dataset2.addValue(10, "Series 1", "Category 1");
        dataset2.addValue(5, "Series 1", "Category 2");
        dataset2.addValue(15, "Series 1", "Category 3");
        
        // 렌더러 생성
        AreaRenderer renderer1 = new AreaRenderer();
        LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        
        // 카테고리 플롯 생성
        CategoryPlot plot = new CategoryPlot();
        
        // 데이터셋 설정
        plot.setDataset(dataset1);
        plot.setRenderer(renderer1);
        
        plot.setDataset(1, dataset2);
        plot.setRenderer(1, renderer2);
        
        // X축 설정
        CategoryAxis domainAxis = new CategoryAxis("Category");
        plot.setDomainAxis(domainAxis);
        
        // Y축 설정
        NumberAxis rangeAxis = new NumberAxis("Value");
        plot.setRangeAxis(rangeAxis);
        
        // 차트 생성
        JFreeChart chart = new JFreeChart(plot);
        
        // 차트 프레임 생성 및 표시
        ChartFrame frame = new ChartFrame("Area and Line Chart", chart);
        frame.pack();
        frame.setVisible(true);
    }
}