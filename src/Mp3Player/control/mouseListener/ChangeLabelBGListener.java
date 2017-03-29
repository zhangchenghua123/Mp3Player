package Mp3Player.control.mouseListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import Mp3Player.GetResourceClass;
import Mp3Player.control.action.PopupMenuOnSheets;
import Mp3Player.model.OurValue;
import Mp3Player.view.littleView.JLabelOnLeftPanel;
/**
 * 左侧列表显示label的监听事件
 * 鼠标移上移出及点击时的动作
 * 
 * @author Berry
 *
 */
public class ChangeLabelBGListener implements MouseListener,
		MouseMotionListener {

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
		JLabelOnLeftPanel label;
		//恢复上一个点击的label
		label=OurValue.getLastActiveLabel();
		if(label!=null){
			if(label.getId()==((JLabelOnLeftPanel)(e.getComponent())).getId()&&e.getButton()==MouseEvent.BUTTON1)
				return;
			switch(label.getId()){
			case 1:
				label.setIcon(new ImageIcon(GetResourceClass.class.getResource("image/mylike_unactive.png")));
				
				break;
			case 2:
				label.setIcon(new ImageIcon(GetResourceClass.class.getResource("image/history_unactive.png")));
				break;
			case 3:
				label.setIcon(new ImageIcon(GetResourceClass.class.getResource("image/local_unactive.png")));
			default:
				label.setIcon(new ImageIcon(GetResourceClass.class.getResource("image/sheet_unactive.png")));
			}
			label.setBackground(null);
			label.repaint();
		}
		//修改当前点击的label
		label=(JLabelOnLeftPanel)(e.getComponent());
		OurValue.setLastActionLabel(label);
		switch (label.getId()) {
		case 1:
			label.setIcon(new ImageIcon(GetResourceClass.class.getResource("image/mylike_active.png")));
			break;
		case 2:
			label.setIcon(new ImageIcon(GetResourceClass.class.getResource("image/history_active.png")));
			break;
		case 3:
			label.setIcon(new ImageIcon(GetResourceClass.class.getResource("image/local_active.png")));
			break;
		default:
			label.setIcon(new ImageIcon(GetResourceClass.class.getResource("image/sheet_active.png")));
			break;
		}
		label.setBackground(new Color(255,0,0));
		label.repaint();
		if(e.getButton()==MouseEvent.BUTTON1){
			//单击，同步右边的歌曲列表
		}
		else if(e.getButton()==MouseEvent.BUTTON3&&label.getId()>3){ //右键，且是我的列表那块，不是我喜欢的那块那的
			//右击，在指针处弹出菜单
			PopupMenuOnSheets popupMenuOnSheets=new PopupMenuOnSheets();
			popupMenuOnSheets.setLocation(e.getPoint());
			popupMenuOnSheets.show(label, e.getX(), e.getY());
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
		if(OurValue.getLastActiveLabel()!=(JLabelOnLeftPanel)(e.getComponent())){
			((JLabelOnLeftPanel)(e.getComponent())).setBackground(new Color(240,248,255));
//			((JLabelOnLeftPanel)(e.getComponent())).setIcon(new ImageIcon(GetResourceClass.class.getResource("image/mylike_active.png")));
			e.getComponent().repaint();
		}
	}

	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(OurValue.getLastActiveLabel()!=(JLabelOnLeftPanel)(e.getComponent())){
			((JLabelOnLeftPanel)(e.getComponent())).setBackground(null);
//			((JLabelOnLeftPanel)(e.getComponent())).setIcon(new ImageIcon(GetResourceClass.class.getResource("image/mylike_unactive.png")));
			e.getComponent().repaint();
		}
	}

}
