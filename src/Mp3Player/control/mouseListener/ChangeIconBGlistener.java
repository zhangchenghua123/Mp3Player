package Mp3Player.control.mouseListener;



import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import Mp3Player.GetResourceClass;
import Mp3Player.control.action.pullMenu_onTitle;
import Mp3Player.control.file.MySheets;
import Mp3Player.model.Components;
import Mp3Player.model.OurValue;
import Mp3Player.view.littleView.AddSheetDialog;
import Mp3Player.view.littleView.IconPanel;
import Mp3Player.view.littleView.JLabelOnLeftPanel;

/**
 * 带图标的小按钮的监听事件
 * 鼠标移上或移出以及点击时触发的动作
 * @author Berry
 *
 */
public class ChangeIconBGlistener implements MouseListener,MouseMotionListener{

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch (((IconPanel)e.getComponent()).getId()) {
		case 0: //标题栏的下拉菜单
			pullMenu_onTitle  pMenu_onTitle=new pullMenu_onTitle();
//			Mp3Player.view.MainView.frame.add(pMenu_onTitle);
			pMenu_onTitle.show(e.getComponent() , 0, 48);
			break;
		case 1://最小化按钮
			Mp3Player.model.Components.frame.setExtendedState(JFrame.ICONIFIED);
			break;
		case 2://关闭按钮
			System.exit(0);
		case 3://添加歌单按钮
			AddSheetDialog dialog=new AddSheetDialog(Mp3Player.model.Components.frame,"添加新列表");
			
			dialog.setVisible(true);
			System.out.println("bbb");
			if(dialog.isRight()){
				System.out.println("ccc");
				MySheets.AddSheet(dialog.getName());
				int size=Components.mySongSheetsNameList.size();
				JLabelOnLeftPanel label=new JLabelOnLeftPanel(size+4,Components.mySongSheetsNameList.get(size-1));
				label.setFont(OurValue.getFont());
				label.setOpaque(true);
				label.setBounds(0, 40*(size-1), 250, 40);
				label.setBorder(new EmptyBorder(0, 30, 0, 0));
				label.setIcon(new ImageIcon(GetResourceClass.class.getResource( "image/sheet_unactive.png")));
				label.addMouseListener(new ChangeLabelBGListener());
				label.addMouseMotionListener(new ChangeLabelBGListener());
				Components.sheetPanel.setPreferredSize(new Dimension(220,Components.mySongSheetsNameList.size()*40));
				Components.sheetPanel.add(label);
				
				Components.sheetPanel.validate();
				Components.jscrolJanel.validate();
				Components.jscrolJanel.repaint();
				Components.jscrolJanel.getVerticalScrollBar().setValue(size*40);
			}
		default:
			
			break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		((IconPanel)e.getComponent()).setActivite(true);
		((IconPanel)e.getComponent()).repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		((IconPanel)e.getComponent()).setActivite(false);
		((IconPanel)e.getComponent()).repaint();
	}
	
}