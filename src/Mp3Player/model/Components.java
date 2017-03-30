package Mp3Player.model;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;

import com.sun.org.apache.bcel.internal.generic.NEW;

import Mp3Player.view.littleView.IconPanel;
import Mp3Player.view.littleView.JLabelOnLeftPanel;

public class Components {
	
	public static JFrame frame;
	public static Container mainContainer;//全部的区域
	public static JPanel titlePanel;//标题栏
	
	public static IconPanel iconPanel;//应用程序图标
	public static IconPanel pullPanel;//下拉菜单
	public static IconPanel littlePanel;//最小化图标
	public static IconPanel closePanel;//关闭图标
	public static JPanel bodyPanel; //除了标题栏的部分，分三个区域，left，right，bottom
	public static JPanel leftPanel; //左侧的列表栏
	public static JPanel rightPanel;//右侧的歌曲栏
	public static JPanel bottompPanel;//下边的播放栏
	
	//左面板的东西
	public static JLabel myMusic; //我的音乐
	public static JLabel mySongSheet;
	public static JScrollPane sheetScrollPane;
	public static JPanel sheetPanel;
	public static IconPanel addSheet;
	public static ArrayList<String> mySongSheetsNameList;
	public static ArrayList<Component> mySongSheetLabelList;
	public static JScrollPane jscrolJanel;
	
	//右面板的东西
	public static JLabel sheetNameLabel;
	public static JLabelOnLeftPanel playAllLabel;
	public static JButton playAllButton;
	public static JTable songsListTable;
	public static ArrayList<Vector<String>> songList;
	
	//下面板的东西
	public static IconPanel lastSongPanel;
	public static IconPanel nextSongPanel;
	public static IconPanel playSongPanel;
	public static JSlider playingSlider;
	public static JLabel playingNameLabel;
	public static JLabel playingTimeLabel;
	
	
}

	
