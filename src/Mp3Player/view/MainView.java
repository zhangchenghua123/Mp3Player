package Mp3Player.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import sun.awt.geom.AreaOp.AddOp;

import Mp3Player.GetResourceClass;
import Mp3Player.control.mouseListener.ChangeBGlistener;
import Mp3Player.control.mouseListener.ChangeLocationListener;
import Mp3Player.view.littleView.IconPanel;



public  class MainView {

	public static JFrame frame;
	private Container mainContainer;//全部的区域
	private JPanel titlePanel;//标题栏
	public static Point originPoint;
	private IconPanel iconPanel;//应用程序图标
	private IconPanel pullPanel;//下拉菜单
	private IconPanel littlePanel;//应用程序图标
	private IconPanel closePanel;//应用程序图标
	private JPanel bodyPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel bottompPanel;
	int a=2;
	URL img_active_url;
	URL img_unactive_url;
	/**
	 * @param args
	 */
	public MainView(){
		//初始化frame
		frame=new JFrame("Mp3Player");
		originPoint=new Point();
		frame.setSize(1280, 800);
		frame.setUndecorated(true);
		frame.setIconImage((new ImageIcon(GetResourceClass.class.getResource("image/music.png"))).getImage());
//		com.sun.awt.AWTUtilities.setWindowOpacity(frame, 1.0f);
//		frame.setBackground(new Color(0,0,0,0));
		//重定义container
		mainContainer =new Container();
//		mainPanel.setBackground(new Color(255,255,0));
		mainContainer.setSize(1280, 800);
		mainContainer.setLayout(null);
		
		//初始化titlePanel
		img_active_url = GetResourceClass.class.getResource("image/title_bg.jpg");
		titlePanel=new IconPanel(-1,img_active_url,img_active_url);
		titlePanel.setOpaque(true );
//		titlePanel.setLayout(new GridBagLayout());
//		titlePanel.setLayout(null); 
		titlePanel.setBounds(0, 0, 1280,60 );
		titlePanel.setBackground(new Color(00,195,195));
//		titlePanel.setBorder(BorderFactory.createEtchedBorder());
//		frame.setBackground(Color.BLUE);
		img_active_url = GetResourceClass.class.getResource("image/music.jpg");
		iconPanel=new IconPanel(0, img_active_url, img_active_url);
		iconPanel.setPreferredSize(new Dimension(48, 48));
		iconPanel.setOpaque(false);
		img_active_url = GetResourceClass.class.getResource("image/pull_active.png");
		img_unactive_url = GetResourceClass.class.getResource("image/pull_unactive.png");
		pullPanel=new IconPanel(0, img_active_url, img_unactive_url);
		pullPanel.setOpaque(false);
		img_active_url = GetResourceClass.class.getResource("image/little_active.png");
		img_unactive_url = GetResourceClass.class.getResource("image/little_unactive.png");
		littlePanel=new IconPanel(1, img_active_url, img_unactive_url);
		littlePanel.setOpaque(false);
		img_active_url = GetResourceClass.class.getResource("image/close_active.png");
		img_unactive_url = GetResourceClass.class.getResource("image/close_unactive.png");
		littlePanel.setPreferredSize(new Dimension(32, 32));
		closePanel=new IconPanel(2, img_active_url, img_unactive_url);
		closePanel.setOpaque(false);
		closePanel.setPreferredSize(new Dimension(32, 32));
		iconPanel.setFocusable(false);
//		iconPanel.setBounds(10, 20, 32, 32);
//		iconPanel.setOpaque(true);
		
		GridBagLayout layout=new GridBagLayout();
		titlePanel.setLayout(layout);
		titlePanel.add(iconPanel);
		titlePanel.add(pullPanel);
		titlePanel.add(littlePanel);
		titlePanel.add(closePanel);
		GridBagConstraints s=new GridBagConstraints();
		s.fill=GridBagConstraints.NONE;
		s.gridx = 0;
        s.gridy = 0;
		s.weightx=0;
		s.weighty=0;
		s.ipadx=1;
		s.ipady=1;
		s.anchor=GridBagConstraints.WEST;
		s.insets=new Insets(8, 10, 0, 0);
		titlePanel.add(iconPanel, s);
		
		s.gridx = 1;
        s.gridy = 0;
		s.weightx=0;
		s.weighty=0;
		s.ipadx=1;
		s.ipady=1;
		s.anchor=GridBagConstraints.WEST;
		s.insets=new Insets(8, 10, 0, 0);
		titlePanel.add(pullPanel, s);
		
		
		s.gridx = 2;
        s.gridy = 0;
		s.gridwidth=1;
		s.weightx=0;
		s.weighty=0;
		titlePanel.add(littlePanel, s);
		s.gridx = 3;
        s.gridy = 0;
		s.gridwidth=2;
		s.weightx=0;
		s.weighty=0;
		s.insets=new Insets(0, 15, 0, 40);
		titlePanel.add(closePanel, s);
		
		
//		titlePanel.add(iconPanel);
		bodyPanel=new JPanel();
		bodyPanel.setBounds(0, 60,1280 , 740);
		bodyPanel.setBackground(new Color(255,255,255));
//		bodyPanel.setBorder(BorderFactory.createEtchedBorder());
		bodyPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(96,188,253)));
		bodyPanel.setLayout(null);
		leftPanel=new JPanel();
		leftPanel.setBackground(new Color(255,0,0));
		leftPanel.setBounds(5, 5, 250,600);
//		leftPanel.setPreferredSize(new Dimension(110,10));
		rightPanel=new JPanel();
		rightPanel.setBackground(new Color(0,255,0));
		rightPanel.setBounds(255, 5,1020, 600);
//		rightPanel.setPreferredSize(new Dimension(110,10));
		bottompPanel=new JPanel();
		bottompPanel.setBackground(new Color(0,0,255));
		bottompPanel.setBounds(5, 605, 1270, 140);
//		bottompPanel.setPreferredSize(new Dimension(110,10));
		bodyPanel.add(leftPanel);
		bodyPanel.add(rightPanel);
		bodyPanel.add(bottompPanel);
		
		
		
		
		
		mainContainer.add(titlePanel);
		mainContainer.add(bodyPanel);
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
