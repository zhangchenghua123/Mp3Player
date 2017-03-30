package Mp3Player.view;

import java.awt.BorderLayout;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import Mp3Player.GetResourceClass;
import Mp3Player.control.Init;
import Mp3Player.control.mouseListener.ChangeIconBGlistener;
import Mp3Player.control.mouseListener.ChangeLabelBGListener;
import Mp3Player.control.mouseListener.ChangeLocationListener;
import Mp3Player.model.OurValue;
import Mp3Player.model.TableValues;
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
		addRightTopPanel();
		addBottomPanel();
		Components.frame.setContentPane(Components.mainContainer);
		Components.frame.getContentPane().setVisible(true);
		Components.frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Init.initialization();
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
		Components.leftPanel.setBounds(5, 5, 250,660);
//		leftPanel.setPreferredSize(new Dimension(110,10));
		Components.rightPanel=new JPanel();
		Components.rightPanel.setLayout(null);
		Components.rightPanel.setBackground(new Color(255,255,255));
		Components.rightPanel.setBounds(255, 5,1020, 660);
//		rightPanel.setPreferredSize(new Dimension(110,10));
		Components.bottompPanel=new JPanel();
		Components.bottompPanel.setBackground(new Color(45,46,48));
		Components.bottompPanel.setBounds(5, 665, 1270, 70);
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
		Components.addSheet.addMouseListener(new ChangeIconBGlistener());
		Components.addSheet.addMouseMotionListener(new ChangeIconBGlistener());
		Components.leftPanel.add(Components.addSheet);
		Components.sheetPanel=new JPanel();
		Components.sheetPanel.setLocation(new Point(0,240));
		Components.sheetPanel.setPreferredSize(new Dimension(250,Components.mySongSheetsNameList.size()*40));
//		GridLayout gridLayout=new GridLayout(0,1);
//		gridLayout.setColumns(1);
//		gridLayout.setRows(Components.mySongSheetList.size());
		Components.sheetPanel.setLayout(null);
		for(int i=0;i<Components.mySongSheetsNameList.size();i++){
			JLabelOnLeftPanel label=new JLabelOnLeftPanel(i+4,Components.mySongSheetsNameList.get(i));
			label.setFont(OurValue.getFont());
			label.setOpaque(true);
			label.setBounds(0, 40*i, 250, 40);
			label.setBorder(new EmptyBorder(0, 30, 0, 0));
			label.setIcon(new ImageIcon(GetResourceClass.class.getResource( "image/sheet_unactive.png")));
			label.addMouseListener(new ChangeLabelBGListener());
			label.addMouseMotionListener(new ChangeLabelBGListener());
			Components.sheetPanel.add(label);
		}
		Components.jscrolJanel = new JScrollPane(Components.sheetPanel,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Components.jscrolJanel.setBounds(0, 240, 250, 250);
		Components.jscrolJanel.setBorder(new EmptyBorder(0,0,0,0));
		Components.leftPanel.add(Components.jscrolJanel);
	}
	public void addRightTopPanel(){
		Components.sheetNameLabel=new JLabel("我喜欢");
		Components.sheetNameLabel.setFont(OurValue.getBigFont());
		Components.sheetNameLabel.setForeground(new Color(73,73,73));
		Components.sheetNameLabel.setBounds(40, 20, 100, 50);
		Components.rightPanel.add(Components.sheetNameLabel);   
		
		Components.playAllButton=new JButton("播放全部");
		Components.playAllButton.setIcon(new ImageIcon(GetResourceClass.class.getResource("image/playAll.png")));
		Components.playAllButton.setBounds(150, 20, 130, 50);
		Components.playAllButton.setFont(OurValue.getFont());
		Components.playAllButton.setMargin(new Insets(0,0,0,0));
		Components.playAllButton.setFocusPainted(false);
		Components.playAllButton.setBackground(new Color(240,248,255));
		Components.playAllButton.setBorderPainted(false);
		Components.rightPanel.add(Components.playAllButton);  
		
		
		
		TableValues tableValues=new TableValues();
		Components.songsListTable=new JTable(tableValues);
	
		Components.songsListTable.setBounds(20, 90, 1000, 500);
		Components.songsListTable.getTableHeader().setPreferredSize(new Dimension(280,50));
		Components.songsListTable.getTableHeader().setFont(OurValue.getFont());
		Components.songsListTable.setRowHeight(50);
		Components.songsListTable.setFillsViewportHeight(true);//填充高度
		Components.songsListTable.setFont(OurValue.getFont());
		
		DefaultTableCellRenderer   r   =   new   DefaultTableCellRenderer();   
		r.setHorizontalAlignment(JLabel.CENTER); 
		TableColumn column1=Components.songsListTable.getColumn("文件名");
		column1.setCellRenderer(r);
		Components.songsListTable.setShowVerticalLines(false);
		Components.songsListTable.setIntercellSpacing(new Dimension(0,0));
		Components.songsListTable.setFocusable(false);
//		Components.songsListTable.setCellSelectionEnabled(false);
		Components.songsListTable.setBackground(Color.white);
		Components.songsListTable.setBorder(new EmptyBorder(0,0,0,0));
		Components.songsListTable.getColumnModel().getColumn(0).setPreferredWidth(700);
		Components.songsListTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		Components.songsListTable.getColumnModel().getColumn(2).setPreferredWidth(150);
		Components.songsListTable.getColumnModel().getColumn(3).setPreferredWidth(100);
		JScrollPane jsp = new JScrollPane(Components.songsListTable);  
       jsp.setBounds(20, 90, 1000, 500);
       jsp.setBorder(new EmptyBorder(0,0,0,0));
       jsp.setBackground(Color.WHITE);
		Components.rightPanel.add(jsp);
	}
	public void addBottomPanel(){
		Components.bottompPanel.setLayout(null);
		Components.lastSongPanel=new IconPanel(4,GetResourceClass.class.getResource("image/lastSong_active.png"),
				GetResourceClass.class.getResource("image/lastSong_unactive.png"));
		Components.lastSongPanel.setOpaque(false);
		Components.lastSongPanel.setBounds(30,19,32,32);
		Components.lastSongPanel.addMouseListener(new ChangeIconBGlistener());
		Components.lastSongPanel.addMouseMotionListener(new ChangeIconBGlistener());
		Components.bottompPanel.add(Components.lastSongPanel);
		
		Components.playSongPanel=new IconPanel(5,GetResourceClass.class.getResource("image/playSong_active.png"),
				GetResourceClass.class.getResource("image/playSong_unactive.png"));
		Components.playSongPanel.setOpaque(false);
		Components.playSongPanel.setBounds(70,11,48,48);
		Components.playSongPanel.addMouseListener(new ChangeIconBGlistener());
		Components.playSongPanel.addMouseMotionListener(new ChangeIconBGlistener());
		Components.bottompPanel.add(Components.playSongPanel);
		
		Components.nextSongPanel=new IconPanel(6,GetResourceClass.class.getResource("image/nextSong_active.png"),
				GetResourceClass.class.getResource("image/nextSong_unactive.png"));
		Components.nextSongPanel.setOpaque(false);
		Components.nextSongPanel.setBounds(126,19,32,32);
		Components.nextSongPanel.addMouseListener(new ChangeIconBGlistener());
		Components.nextSongPanel.addMouseMotionListener(new ChangeIconBGlistener());
		Components.bottompPanel.add(Components.nextSongPanel);
		
		Components.playingSlider= new JSlider(JSlider.HORIZONTAL,0, 100, 0);
		Components.playingSlider.setBounds(200,45, 600, 6);
		Components.playingSlider.setOpaque(false);
		Components.bottompPanel.add(Components.playingSlider);
		
		Components.playingNameLabel=new JLabel("歌曲名");
		Components.playingNameLabel.setOpaque(false);
		Components.playingNameLabel.setForeground(Color.LIGHT_GRAY);
		Components.playingNameLabel.setFont(OurValue.getFont());
		Components.playingNameLabel.setBounds(200, 0, 500, 40);
		Components.bottompPanel.add(Components.playingNameLabel);
		
		Components.playingTimeLabel=new JLabel("2:30 /4:50");
		Components.playingTimeLabel.setOpaque(false);
		Components.playingTimeLabel.setForeground(Color.LIGHT_GRAY);
		Components.playingTimeLabel.setFont(OurValue.getFont());
		Components.playingTimeLabel.setBounds(700, 0, 100, 40);
		Components.bottompPanel.add(Components.playingTimeLabel);
	}

	
}

