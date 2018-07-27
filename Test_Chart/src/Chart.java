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
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class Chart {
	
	private JFrame frame;
	ResultSet ResultSet;
	
	
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
		frame.setResizable(true);
		frame.setBounds(100, 100, 746, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setForeground(Color.GRAY);
		
		
		
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				//¸ü¤JJDBC Driver 
		        try {
		        	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			        Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost;"+ "databaseName=ManagerDB;user=sa;password=!QAZ2wsx;");
			        DatabaseMetaData metadata = conn.getMetaData();           
			        //System.out.println("Database Name: "+ metadata.getDatabaseProductName());
			        System.out.println("Connect MS DB");
			        Statement Statement = conn.createStatement();
			        String query = "SELECT [MachineName],count([MachineName]) as'Crash_Count' FROM [MngDB2].[dbo].[GameCrashReport] Where [TimeCreated] >= '2018-04-05 05:11:07.0000000' and [TimeCreated] <='2018-04-10 05:11:07.0000000' Group By [MachineName]";
			        ResultSet = Statement.executeQuery(query);
			        while (ResultSet.next()) {
			        	int Column = Integer.parseInt(ResultSet.getString(2));
			            System.out.println(ResultSet.getString(1)+","+ResultSet.getString(2));
			            dataset.setValue(Column, "Lineage M GameWorld", ResultSet.getString(1));
			        }

					JFreeChart Chart = ChartFactory.createBarChart3D("Lineage M GameWorld Crash Chart", "GameWorld", "Carsh_Count", dataset, PlotOrientation.VERTICAL, true, true, false);
					CategoryPlot catPlot = Chart.getCategoryPlot();
					catPlot.setRangeGridlinePaint(Color.BLACK);
					//ChartFrame chartFrm = new ChartFrame("Lineage M GameWorld Crah Grapth", Chart, true);
					//chartFrm.setVisible(true);
					//chartFrm.setSize(500, 400);
					ChartPanel chartPanel = new ChartPanel(Chart);
					panel.removeAll();
					panel.add(chartPanel);
					panel.updateUI();
				} catch (ClassNotFoundException e1) {
					System.out.println("MS DB Connet Error....");
					e1.printStackTrace();
				} catch (SQLException e1) {
					System.out.println("MS DB Connet Error....");
					e1.printStackTrace();
				}
		        /*
				for(int i=1;i<=10;i++) {
					dataset.setValue(i, "Point", "People_"+i);
					//dataset.setValue(60, "Point", "java");
				}*/

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


