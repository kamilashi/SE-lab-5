package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

import lib.MapStorage;
import lib.Tuple;
import javax.swing.JButton;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.GridLayout;

public class RegionModeFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7520363334341273313L;
	
	Dimension screenSize;

	public RegionModeFrame() throws IOException
	{

		ScreenSizeManager.fetchScreenInfo();
		screenSize = ScreenSizeManager.getScreenDimension();
		gui.MapPainter mapPainter = new gui.MapPainter();
		mapPainter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clipMap(e.getX(), e.getY(),20);
				mapPainter.repaint();
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(new Dimension(418, 679));
		setBounds(ScreenSizeManager.getScreenBounds());
		setPreferredSize(screenSize);
		setName("this");
		setVisible(true);
		setEnabled(true);
		
		lib.MapGenerator generator = new lib.MapGenerator();

		  //MapStorage.printMap();
			
			
		  
		  JPanel mainPanel = new JPanel();
		  this.getContentPane().add(mainPanel, BorderLayout.CENTER);
			mainPanel.setLayout(new BorderLayout(0, 0));
			
			JPanel northPanel = new JPanel();
			mainPanel.add(northPanel, BorderLayout.NORTH);
			northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 20));
			
			JButton loadButton = new JButton("Load");
			loadButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					try {
						MapStorage.loadSettings();
						mapPainter.repaint();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			JPanel northButtonPanel = new JPanel();
			northPanel.add(northButtonPanel);
			northButtonPanel.setLayout(new GridLayout(1, 0, 0, 0));
			
			loadButton.setFont(new Font("Roboto", Font.PLAIN, 20));
			northButtonPanel.add(loadButton);
			
			JButton saveButton = new JButton("Save");
			saveButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					try {
						MapStorage.saveSettings();
						//mapPainter.repaint();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			saveButton.setFont(new Font("Roboto", Font.PLAIN, 20));
			northButtonPanel.add(saveButton);
			
			JPanel centerPanel = new JPanel();
			centerPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
			centerPanel.setFont(new Font("Roboto", Font.PLAIN, 30));
			mainPanel.add(centerPanel, BorderLayout.CENTER);
			centerPanel.setLayout(new BorderLayout(0, 50));
		
			
			centerPanel.add(mapPainter);
			mapPainter.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			
			JPanel panel = new JPanel();
			FlowLayout flowLayout_2 = (FlowLayout) panel.getLayout();
			flowLayout_2.setHgap(8);
			centerPanel.add(panel, BorderLayout.WEST);
			
			JPanel westPanel = new JPanel();
			FlowLayout fl_westPanel = (FlowLayout) westPanel.getLayout();
			fl_westPanel.setHgap(20);
			mainPanel.add(westPanel, BorderLayout.WEST);
			
			JPanel eastPanel = new JPanel();
			FlowLayout flowLayout_1 = (FlowLayout) eastPanel.getLayout();
			flowLayout_1.setHgap(20);
			mainPanel.add(eastPanel, BorderLayout.EAST);
			
			JPanel southPanel = new JPanel();
			FlowLayout flowLayout = (FlowLayout) southPanel.getLayout();
			flowLayout.setHgap(70);
			flowLayout.setVgap(70);
			mainPanel.add(southPanel, BorderLayout.SOUTH);
			

			JPanel southButtonPanel = new JPanel();
			southPanel.add(southButtonPanel);
			
			JButton resetButton = new JButton("Reset");
			resetButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					MapStorage.resetMap();
					mapPainter.repaint();
				}
			});
			southButtonPanel.setLayout(new GridLayout(0, 2, 0, 0));
			resetButton.setFont(new Font("Roboto", Font.PLAIN, 20));
			southButtonPanel.add(resetButton);
			
			JButton OKbutton = new JButton("OK");
			OKbutton.setFont(new Font("Roboto", Font.PLAIN, 20));
			southButtonPanel.add(OKbutton);
			
			
			JLabel pageTitleLabel = new JLabel("       Define region            ");
			pageTitleLabel.setPreferredSize(new Dimension(105, 100));
			pageTitleLabel.setHorizontalAlignment(SwingConstants.LEFT);
			pageTitleLabel.setFont(new Font("Roboto Light", Font.PLAIN, 30));
			getContentPane().add(pageTitleLabel, BorderLayout.NORTH);
			

			OKbutton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {

				pageTitleLabel.setText("       Map has been sent!");
				}
			});
			
		
	}
	
			public void clipMap(int x, int y, int brushSize)
			{
				int i; int j;
				int halfSize = (brushSize/2);
				for(i=(x-halfSize);i<(x+halfSize);i++)
				{
					for (j=(y-halfSize);j<(y+halfSize);j++)
					{MapStorage.updateSettings(i, j);
					}
				}
			}
}
