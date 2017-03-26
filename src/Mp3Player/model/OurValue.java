package Mp3Player.model;

import java.awt.Color;
import java.awt.Font;

import Mp3Player.view.littleView.JLabelOnLeftPanel;

public class OurValue {

	static JLabelOnLeftPanel lastActivelabel;
	public static Font getFont() {
		
	return new Font("Î¢ÈíÑÅºÚ",Font.PLAIN,20);
		
	}
//	public static Color getColor(){
		
//	}
	public static JLabelOnLeftPanel getLastActiveLabel(){
		return lastActivelabel;
	}
	public static void setLastActionLabel(JLabelOnLeftPanel label){
		lastActivelabel=label;
	}
}
