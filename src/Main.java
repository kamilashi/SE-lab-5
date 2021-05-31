import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Component;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import lib.MapStorage;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		//gui.ModeMenuFrame modeMenuFrame = new gui.ModeMenuFrame();
		
		  gui.RegionModeFrame regionModeFrame = new gui.RegionModeFrame();
		  lib.MapGenerator generator = new lib.MapGenerator();

		  //MapStorage.printMap();
			
			
		  
		  JPanel mainPanel = new JPanel();
		  regionModeFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
			mainPanel.setLayout(new BorderLayout(0, 0));
			
			JPanel northPanel = new JPanel();
			mainPanel.add(northPanel, BorderLayout.NORTH);
			northPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 50));
			
			JLabel lblNewLabel = new JLabel("Define regions");
			lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 30));
			lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
			northPanel.add(lblNewLabel);
			
			JPanel centerPanel = new JPanel();
			centerPanel.setFont(new Font("Roboto", Font.PLAIN, 30));
			mainPanel.add(centerPanel, BorderLayout.CENTER);
			centerPanel.setLayout(new BorderLayout(0, 0));
			
			
			
			gui.MapPainter mapPainter = new gui.MapPainter();
			centerPanel.add(mapPainter);
			//lib.MapStorage.saveSettings();
			
			
			
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
			flowLayout.setVgap(70);
			mainPanel.add(southPanel, BorderLayout.SOUTH);
			
			//MapStorage.getMap().printActivePoints();

			//ArrayList<lib.Tuple> excluded = new ArrayList<lib.Tuple>();
			
			
			
			//MapStorage.loadSettings();
			//mapPainter.printPoints();
			
			//mapPainter.updateMap();
			
			
			
			mapPainter.repaint();
			regionModeFrame.repaint();
			//lib.MapStorage.saveSettings();
			
	}

}
