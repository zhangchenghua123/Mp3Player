package Mp3Player.model;

import java.awt.Color;
import java.awt.Font;

import Mp3Player.view.littleView.JLabelOnLeftPanel;

public class OurValue {

	static JLabelOnLeftPanel lastActivelabel;
	/**
	 * 获取软件字体
	 * @return
	 */
	public static Font getFont() {
		return new Font("微软雅黑",Font.PLAIN,20);	
	}
	public static Font getBigFont() {
		return new Font("微软雅黑",Font.PLAIN,30);	
	}
	/**
	 * 
	 * @return
	 */
//	public static Color getColor(){
//		
//	}
	
	public static JLabelOnLeftPanel getLastActiveLabel(){
		return lastActivelabel;
	}
	public static void setLastActionLabel(JLabelOnLeftPanel label){
		lastActivelabel=label;
	}
}
