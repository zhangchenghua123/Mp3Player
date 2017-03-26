package Mp3Player.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Mp3Player.GetResourceClass;
import Mp3Player.control.mouseListener.ChangeIconBGlistener;
import Mp3Player.control.mouseListener.ChangeLabelBGListener;
import Mp3Player.control.mouseListener.ChangeLocationListener;
import Mp3Player.model.OurValue;
import Mp3Player.view.littleView.IconPanel;
import Mp3Player.view.littleView.JLabelOnLeftPanel;



public  class MainView {

	public static JFrame frame;
	private Container mainContainer;//全部的区域
	private JPanel titlePanel;//标题栏
	public static Point originPoint;
	private IconPanel iconPanel;//应用程序图标
	private IconPanel pullPanel;//下拉菜单
	private IconPanel littlePanel;//最小化图标
	private IconPanel closePanel;//关闭图标
	private JPanel bodyPanel;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel bottompPanel;
	//左面板的东西
	private JLabel myMusic;
	private JLabelOnLeftPanel myLikeLabel;
	private JLabelOnLeftPanel historyPlayingLabel;
	private JLabelOnLeftPanel localLabe;
	
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
		//重定义container
		mainContainer =new Container();
		mainContainer.setSize(1280, 800);
		mainContainer.setLayout(null);
		addtitleBar();
		addbody();
		addLeftPanel();
		frame.setContentPane(mainContainer);
		frame.getContentPane().setVisible(true);
		frame.setVisible(true);
		
		iconPanel.addMouseListener(new ChangeLocationListener());
		iconPanel.addMouseMotionListener(new ChangeLocationListener());
		
		titlePanel.addMouseListener(new ChangeLocationListener());
		titlePanel.addMouseMotionListener(new ChangeLocationListener());
		
		pullPanel.addMouseListener(new ChangeIconBGlistener());
		pullPanel.addMouseMotionListener(new ChangeIconBGlistener());
		littlePanel.addMouseListener(new ChangeIconBGlistener());
		littlePanel.addMouseMotionListener(new ChangeIconBGlistener());
		closePanel.addMouseListener(new ChangeIconBGlistener());
		closePanel.addMouseMotionListener(new ChangeIconBGlistener());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainView();
	}
	public void addtitleBar(){
		//初始化titlePanel
				img_active_url = GetResourceClass.class.getResource("image/title_bg.jpg");
				titlePanel=new IconPanel(-1,img_active_url,img_active_url);
				titlePanel.setOpaque(true ); 
				titlePanel.setBounds(0, 0, 1280,60 );
				titlePanel.setBackground(new Color(00,195,195));
				img_active_url = GetResourceClass.class.getResource("image/music.png");
				iconPanel=new IconPanel(-1, img_active_url, img_active_url);
				iconPanel.setPreferredSize(new Dimension(48, 48));
				iconPanel.setOpaque(false);
				img_active_url = GetResourceClass.class.getResource("image/pull_active.png");
				img_unactive_url = GetResourceClass.class.getResource("image/pull_unactive.png");
				pullPanel=new IconPanel(0, img_active_url, img_unactive_url);
				pullPanel.setPreferredSize(new Dimension(32,32));
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
//				iconPanel.setBounds(10, 20, 32, 32);
//				iconPanel.setOpaque(true);
				
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
				s.weightx=1;
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
				mainContainer.add(titlePanel);
				
	}
	public void addbody(){

		bodyPanel=new JPanel();
		bodyPanel.setBounds(0, 60,1280 , 740);
		bodyPanel.setBackground(new Color(255,255,255));
//		bodyPanel.setBorder(BorderFactory.createEtchedBorder());
		bodyPanel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, new Color(96,188,253)));
		bodyPanel.setLayout(null);
		leftPanel=new JPanel();
		leftPanel.setForeground(new Color(240,248,255));
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
		
		
		
		
		
		
		mainContainer.add(bodyPanel);
	}
	public void addLeftPanel(){
		leftPanel.setLayout(null);
		myMusic=new JLabel("我的音乐");
		myMusic.setFont(OurValue.getFont());
		myMusic.setForeground(new Color(196,196,196));
		myMusic.setBounds(20,20,220,20);
		leftPanel.add(myMusic);
		
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
			label.setBounds(0, 45+i*40, 250, 40);
			label.setBorder(new EmptyBorder(0,30,0,0));
			label.addMouseListener(new ChangeLabelBGListener());
			label.addMouseMotionListener(new ChangeLabelBGListener());
			leftPanel.add(label);
		}
//		myLikeLabel=new JLabelOnLeftPanel(1, "我喜欢");
//		myLikeLabel.setFont(OurValue.getFont());
//		myLikeLabel.setOpaque(true);
//		myLikeLabel.setIcon(new ImageIcon(GetResourceClass.class.getResource("image/mylike_unactive.png")));
//		myLikeLabel.setBounds(0, 45, 250, 40);
//		myLikeLabel.setBorder(new EmptyBorder(0,30,0,0));
//		myLikeLabel.addMouseListener(new ChangeLabelBGListener());
//		myLikeLabel.addMouseMotionListener(new ChangeLabelBGListener());
//		leftPanel.add(myLikeLabel);
//		historyPlayingLabel=new JLabelOnLeftPanel(2, "播放历史");
//		historyPlayingLabel.setFont(OurValue.getFont());
//		historyPlayingLabel.setOpaque(true);
//		historyPlayingLabel.setIcon(new ImageIcon(GetResourceClass.class.getResource("image/history_unactive.png")));
//		historyPlayingLabel.setBounds(0, 85, 250, 40);
//		historyPlayingLabel.setBorder(new EmptyBorder(0,30,0,0));
//		historyPlayingLabel.addMouseListener(new ChangeLabelBGListener());
//		historyPlayingLabel.addMouseMotionListener(new ChangeLabelBGListener());
//		leftPanel.add(historyPlayingLabel);
//		localLabe=new JLabelOnLeftPanel(2, "播放历史");
//		localLabe.setFont(OurValue.getFont());
//		localLabe.setOpaque(true);
//		localLabe.setIcon(new ImageIcon(GetResourceClass.class.getResource("image/history_unactive.png")));
//		localLabe.setBounds(0, 85, 250, 40);
//		localLabe.setBorder(new EmptyBorder(0,30,0,0));
//		localLabe.addMouseListener(new ChangeLabelBGListener());
//		localLabe.addMouseMotionListener(new ChangeLabelBGListener());
//		leftPanel.add(historyPlayingLabel);
	}
	
}
