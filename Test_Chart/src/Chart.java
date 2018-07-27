import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class Chart {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chart window = new Chart();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Chart() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 746, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.GRAY);
		
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*int s1 = Integer.parseInt("10");
					final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					dataset.setValue(s1, "1", "Test_1");
					System.out.println(dataset);
					JFreeChart Chart = ChartFactory.createBarChart("", "", "", dataset, PlotOrientation.HORIZONTAL, false, false, false);
					CategoryPlot catPlot = Chart.getCategoryPlot();
					catPlot.setRangeGridlinePaint(Color.BLACK);
					ChartPanel chartPanel = new ChartPanel(Chart);
					panel.removeAll();
					panel.add(chartPanel,BorderLayout.CENTER);
					panel.validate();*/
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				dataset.setValue(70, "Point", "EJ");
				dataset.setValue(60, "Point", "java");
				JFreeChart Chart = ChartFactory.createBarChart3D("People_Rcord", "People_Name", "People_Point", dataset, PlotOrientation.VERTICAL, true, true, false);
				CategoryPlot catPlot = Chart.getCategoryPlot();
				catPlot.setRangeGridlinePaint(Color.BLACK);
				ChartFrame chartFrm = new ChartFrame("People_Rcord", Chart, true);
				chartFrm.setVisible(true);
				chartFrm.setSize(500, 400);
				ChartPanel chartPanel = new ChartPanel(Chart);
				panel.removeAll();
				panel.add(chartPanel);
				panel.updateUI();
			}
		});
		
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(337)
							.addComponent(btnTest))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnTest)
					.addGap(22))
		);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		frame.getContentPane().setLayout(groupLayout);
	}
}


