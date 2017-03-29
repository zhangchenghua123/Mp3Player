package Mp3Player.control.action;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;

import Mp3Player.GetResourceClass;
import Mp3Player.control.mouseListener.ChangeLabelBGListener;
import Mp3Player.model.Components;
import Mp3Player.model.OurValue;
import Mp3Player.view.littleView.JLabelOnLeftPanel;

public class Action {

	/**
	 * 删除我的列表时调用
	 */
	public static void updateMySheetsPanel(){
		Components.sheetPanel.removeAll();
		for(int i=0;i<Components.mySongSheetsNameList.size();i++){
			Components.sheetPanel.setPreferredSize(new Dimension(250,Components.mySongSheetsNameList.size()*40));
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
		Components.sheetPanel.validate();
		Components.sheetPanel.repaint();
	}
}
