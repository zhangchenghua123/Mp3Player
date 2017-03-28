package Mp3Player.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import java.awt.Insets;
import java.awt.Point;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Mp3Player.GetResourceClass;
import Mp3Player.control.mouseListener.ChangeIconBGlistener;
import Mp3Player.control.mouseListener.ChangeLabelBGListener;
import Mp3Player.control.mouseListener.ChangeLocationListener;
import Mp3Player.model.OurValue;
import Mp3Player.view.littleView.IconPanel;
import Mp3Player.view.littleView.JLabelOnLeftPanel;


import Mp3Player.model.Components;
public  class MainView {

	
	public static Point originPoint;
	int a=2;
	URL img_active_url;
	URL img_unactive_url;
	/**
	 * @param args
	 */
	public MainView(){
		//初始化frame
		Components.frame=new JFrame("Mp3Player");
		originPoint=new Point();
		Components.frame.setSize(1280, 800);
		Components.frame.setUndecorated(true);
		Components.frame.setIconImage((new ImageIcon(GetResourceClass.class.getResource("image/music.png"))).getImage());
		//重定义container
		Components.mainContainer =new Container();
		Components.mainContainer.setSize(1280, 800);
		Components.mainContainer.setLayout(null);
		addtitleBar();
		addbody();
		addLeftTopPanel();
		addLeftBottomPanel();
		Components.frame.setContentPane(Components.mainContainer);
		Components.frame.getContentPane().setVisible(true);
		Components.frame.setVisible(true);
		
		
		
		
		
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainView();
	}
	public void addtitleBar(){
		//初始化titlePanel
				img_active_url = GetResourceClass.class.getResource("image/title_bg.jpg");
				Components.titlePanel=new IconPanel(-1,img_active_url,img_active_url);
				Components.titlePanel.setOpaque(true ); 
				Components.titlePanel.setBounds(0, 0, 1280,60 );
				Components.titlePanel.setBackground(new Color(00,195,195));
				Components.titlePanel.addMouseListener(new ChangeLocationListener());
				Components.titlePanel.addMouseMotionListener(new ChangeLocationListener());
				
				img_active_url = GetResourceClass.class.getResource("image/music.png");
				Components.iconPanel=new IconPanel(-1, img_active_url, img_active_url);
				Components.iconPanel.setPreferredSize(new Dimension(48, 48));
				Components.iconPanel.setOpaque(false);
				Components.iconPanel.setFocusable(false);
				Components.iconPanel.addMouseListener(new ChangeLocationListener());
				Components.iconPanel.addMouseMotionListener(new ChangeLocationListener());
				
				img_active_url = GetResourceClass.class.getResource("image/pull_active.png");
				img_unactive_url = GetResourceClass.class.getResource("image/pull_unactive.png");
				Components.pullPanel=new IconPanel(0, img_active_url, img_unactive_url);
				Components.pullPanel.setPreferredSize(new Dimension(32,32));
				Components.pullPanel.setOpaque(false);
				Components.pullPanel.addMouseListener(new ChangeIconBGlistener());
				Components.pullPanel.addMouseMotionListener(new ChangeIconBGlistener());
				
				img_active_url = GetResourceClass.class.getResource("image/little_active.png");
				img_unactive_url = GetResourceClass.class.getResource("image/little_unactive.png");
				Components.littlePanel=new IconPanel(1, img_active_url, img_unactive_url);
				Components.littlePanel.setOpaque(false);
				Components.littlePanel.setPreferredSize(new Dimension(32, 32));
				Components.littlePanel.addMouseListener(new ChangeIconBGlistener());
				Components.littlePanel.addMouseMotionListener(new ChangeIconBGlistener());
				
				img_active_url = GetResourceClass.class.getResource("image/close_active.png");
				img_unactive_url = GetResourceClass.class.getResource("image/close_unactive.png");
				Components.closePanel=new IconPanel(2, img_active_url, img_unactive_url);
				Components.closePanel.setOpaque(false);
				Components.closePanel.setPreferredSize(new Dimension(32, 32));
				Components.closePanel.addMouseListener(new ChangeIconBGlistener());
				Components.closePanel.addMouseMotionListener(new ChangeIconBGlistener());
				
//				iconPanel.setBounds(10, 20, 32, 32);
//				iconPanel.setOpaque(true);
				
				GridBagLayout layout=new GridBagLayout();
				Components.titlePanel.setLayout(layout);
				Components.titlePanel.add(Components.iconPanel);
				Components.titlePanel.add(Components.pullPanel);
				Components.titlePanel.add(Components.littlePanel);
				Components.titlePanel.add(Components.closePanel);
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
				Components.titlePanel.add(Components.iconPanel, s);
				s.gridx = 1;
		        s.gridy = 0;
				s.weightx=1;
				s.weighty=0;
				s.ipadx=1;
				s.ipady=1;
				s.anchor=GridBagConstraints.WEST;
				s.insets=new Insets(8, 10, 0, 0);
				Components.titlePanel.add(Components.pullPanel, s);
				
				
				s.gridx = 2;
		        s.gridy = 0;
				s.gridwidth=1;
				s.weightx=0;
				s.weighty=0;
				Components.titlePanel.add(Components.littlePanel, s);
				s.gridx = 3;
		        s.gridy = 0;
				s.gridwidth=2;
				s.weightx=0;
				s.weighty=0;
				s.insets=new Insets(0, 15, 0, 40);
				Components.titlePanel.add(Components.closePanel, s);
				Components.mainContainer.add(Components.titlePanel);
				
	}
	public void addbody(){

		Components.bodyPanel=new JPanel();
		Components.bodyPanel.setBounds(0, 60,1280 , 740);
		Components.bodyPanel.setBackground(new Color(255,255,255));
//		bodyPanel.setBorder(BorderFactory.createEtchedBorder());
		Components.bodyPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(96,188,253)));
		Components.bodyPanel.setLayout(null);
		Components.leftPanel=new JPanel();
		Components.leftPanel.setForeground(new Color(240,248,255));
		Components.leftPanel.setBounds(5, 5, 250,600);
//		leftPanel.setPreferredSize(new Dimension(110,10));
		Components.rightPanel=new JPanel();
		Components.rightPanel.setBackground(new Color(0,255,0));
		Components.rightPanel.setBounds(255, 5,1020, 600);
//		rightPanel.setPreferredSize(new Dimension(110,10));
		Components.bottompPanel=new JPanel();
		Components.bottompPanel.setBackground(new Color(0,0,255));
		Components.bottompPanel.setBounds(5, 605, 1270, 140);
//		bottompPanel.setPreferredSize(new Dimension(110,10));
		Components.bodyPanel.add(Components.leftPanel);
		Components.bodyPanel.add(Components.rightPanel);
		Components.bodyPanel.add(Components.bottompPanel);
		
		
		
		
		
		
		Components.mainContainer.add(Components.bodyPanel);
	}
	public void addLeftTopPanel(){
		Components.leftPanel.setLayout(null);
		Components.myMusic=new JLabel("我的音乐");
		Components.myMusic.setFont(OurValue.getFont());
		Components.myMusic.setForeground(new Color(196,196,196));
		Components.myMusic.setBounds(0,0,250,60);
		Components.myMusic.setBorder(new EmptyBorder(20,20,5,0));
		Components.leftPanel.add(Components.myMusic);
		
		ArrayList<Map<String, String>> lefttopList=new ArrayList<Map<String,String>>();
		HashMap<String, String> map1=new HashMap<String, String>();
		map1.put("name", "我喜欢");
		map1.put("location", "image/mylike_unactive.png");
		lefttopList.add(map1);
		HashMap<String, String> map2=new HashMap<String, String>();
		map2.put("name", "播放历史");
		map2.put("location", "image/history_unactive.png");
		lefttopList.add(map2);
		HashMap<String, String> map3=new HashMap<String, String>();
		map3.put("name", "本地歌曲");
		map3.put("location", "image/local_unactive.png");
		lefttopList.add(map3);
		for(int i=0;i<lefttopList.size();i++){
			JLabelOnLeftPanel label=new JLabelOnLeftPanel(i+1,lefttopList.get(i).get("name"));
			label.setFont(OurValue.getFont());
			label.setOpaque(true);
			label.setIcon(new ImageIcon(GetResourceClass.class.getResource(lefttopList.get(i).get("location"))));
			label.setBounds(0, 60+i*40, 250, 40);
			label.setBorder(new EmptyBorder(0,30,0,0));
			label.addMouseListener(new ChangeLabelBGListener());
			label.addMouseMotionListener(new ChangeLabelBGListener());
			Components.leftPanel.add(label);
		}
	}
	public void addLeftBottomPanel(){
		Components.mySongSheet=new JLabel("我的歌单");
		Components.mySongSheet.setFont(OurValue.getFont());
		Components.mySongSheet.setForeground(new Color(196,196,196));
		Components.mySongSheet.setBounds(0,180,150,60);
		Components.mySongSheet.setBorder(new EmptyBorder(20,20,5,0));
		Components.leftPanel.add(Components.mySongSheet);
		
		
		img_active_url = GetResourceClass.class.getResource("image/addSheet_active.png");
		img_unactive_url = GetResourceClass.class.getResource("image/addSheet_unactive.png");
		Components.addSheet=new IconPanel(3, img_active_url, img_unactive_url);
		Components.addSheet.setBounds(170, 200, 32, 32);
//		Components.addSheet.setBorder(new EmptyBorder(20,30,5,5));
		Components.addSheet.addMouseListener(new ChangeIconBGlistener());
		Components.addSheet.addMouseMotionListener(new ChangeIconBGlistener());
		Components.leftPanel.add(Components.addSheet);
		Components.sheetPanel=new JPanel();
		Components.sheetPanel.setLocation(new Point(30,240));//setBounds(0, 240, 250, 250);
		Components.sheetPanel.setPreferredSize(new Dimension(230,1000));
		Components.sheetPanel.setLayout(new GridLayout(20,1));
		for(int i=0;i<5;i++){
			JLabelOnLeftPanel label=new JLabelOnLeftPanel(i+4,"歌单"+i);
			label.setFont(OurValue.getFont());
			label.setOpaque(true);
			label.setBounds(0, 240+40*i, 230, 40);
			label.setIcon(new ImageIcon(GetResourceClass.class.getResource( "image/local_unactive.png")));
//			label.setBorder(new EmptyBorder(0,30,0,0));
			label.addMouseListener(new ChangeLabelBGListener());
			label.addMouseMotionListener(new ChangeLabelBGListener());
			Components.sheetPanel.add(label);
		}
		JScrollPane jscrolJanel = new JScrollPane(Components.sheetPanel);
		jscrolJanel.setBounds(30, 240, 250, 250);
		jscrolJanel.setBorder(null);
//		jscrolJanel.setViewportView(Components.sheetPanel);
		Components.leftPanel.add(jscrolJanel);
		
		
		
	}
}
