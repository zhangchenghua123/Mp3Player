package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import control.mouseListener.ChangeBGlistener;
import control.mouseListener.ChangeLocationListener;
import control.mouseListener.fda;

import view.littleView.IconPanel;

public  class MainView {

	public static JFrame frame;
	private Container mainContainer;//全部的区域
	private JPanel titlePanel;//标题栏
	public static Point originPoint;
	private IconPanel iconPanel;//应用程序图标
	private IconPanel littlePanel;//应用程序图标
	private IconPanel closePanel;//应用程序图标
	private int mouseLocation;
	int a=2;
	/**
	 * @param args
	 */
	public MainView(){
		//初始化frame
		frame=new JFrame("Mp3Player");
		originPoint=new Point();
		frame.setSize(1000, 800);
		frame.setUndecorated(true);
//		com.sun.awt.AWTUtilities.setWindowOpacity(frame, 1.0f);
//		frame.setBackground(new Color(0,0,0,0));
		//重定义container
		mainContainer =new Container();
//		mainPanel.setBackground(new Color(255,255,0));
		mainContainer.setSize(1000, 800);
		mainContainer.setLayout(null);
		
		//初始化titlePanel
		titlePanel=new JPanel();
		titlePanel.setOpaque(true);
//		titlePanel.setLayout(new GridBagLayout());
//		titlePanel.setLayout(null); 
		titlePanel.setBounds(0, 0, 1000, 80);
		titlePanel.setBackground(new Color(00,143,00));
		titlePanel.setBorder(BorderFactory.createEtchedBorder());
//		frame.setBackground(Color.BLUE);
		
		iconPanel=new IconPanel(1,"./src/image/music.png","./src/image/music.png");
		iconPanel.setPreferredSize(new Dimension(64, 64));
		littlePanel=new IconPanel(2,"./src/image/little_active.png","./src/image/little_unactive.png");
		littlePanel.setPreferredSize(new Dimension(32, 32));
		closePanel=new IconPanel(3,"./src/image/close_active.png","./src/image/close_unactive.png");
		closePanel.setPreferredSize(new Dimension(32, 32));
		iconPanel.setFocusable(false);
//		iconPanel.setBounds(10, 20, 32, 32);
//		iconPanel.setOpaque(true);
		
		GridBagLayout layout=new GridBagLayout();
		titlePanel.setLayout(layout);
		titlePanel.add(iconPanel);
		titlePanel.add(littlePanel);
		titlePanel.add(closePanel);
		GridBagConstraints s=new GridBagConstraints();
		s.fill=GridBagConstraints.NONE;
		s.gridx = 0;
        s.gridy = 0;
		s.weightx=1;
		s.weighty=0;
		s.ipadx=1;
		s.ipady=1;
		s.anchor=GridBagConstraints.WEST;
		s.insets=new Insets(0, 10, 0, 0);
		titlePanel.add(iconPanel, s);
		s.gridx = 1;
        s.gridy = 0;
		s.gridwidth=1;
		s.weightx=0;
		s.weighty=0;
		titlePanel.add(littlePanel, s);
		s.gridx = 2;
        s.gridy = 0;
		s.gridwidth=2;
		s.weightx=0;
		s.weighty=0;
		s.insets=new Insets(0, 5, 0, 10);
		titlePanel.add(closePanel, s);
		
		
//		titlePanel.add(iconPanel);
		mainContainer.add(titlePanel);
		frame.setContentPane(mainContainer);
		frame.getContentPane().setVisible(true);
		frame.setVisible(true);
		
		iconPanel.addMouseListener(new ChangeLocationListener());
		iconPanel.addMouseMotionListener(new ChangeLocationListener());
		
		titlePanel.addMouseListener(new ChangeLocationListener());
	
		titlePanel.addMouseMotionListener(new ChangeLocationListener());
		littlePanel.addMouseListener(new ChangeBGlistener());
		littlePanel.addMouseMotionListener(new ChangeBGlistener());
		closePanel.addMouseListener(new ChangeBGlistener());
		closePanel.addMouseMotionListener(new ChangeBGlistener());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainView();
	}
	

}
