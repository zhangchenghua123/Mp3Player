package Mp3Player.model;

import java.awt.Container;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
	public static JLabel myMusic;
	public static JLabel mySongSheet;
	public static JScrollPane sheetScrollPane;
	public static JPanel sheetPanel;
	public static IconPanel addSheet;
	
}
