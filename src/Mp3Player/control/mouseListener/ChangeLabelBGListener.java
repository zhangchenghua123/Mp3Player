package Mp3Player.control.mouseListener;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Mp3Player.GetResourceClass;
import Mp3Player.model.OurValue;
import Mp3Player.view.littleView.JLabelOnLeftPanel;
/**
 * ����б���ʾlabel�ļ����¼�
 * ��������Ƴ������ʱ�Ķ���
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
		//�ָ���һ�������label
		label=OurValue.getLastActiveLabel();
		if(label!=null){
			if(label.getId()==((JLabelOnLeftPanel)(e.getComponent())).getId())
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
			}
			label.setBackground(null);
			label.repaint();
		}
		//�޸ĵ�ǰ�����label
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
			break;
		}
		label.setBackground(new Color(255,0,0));
		label.repaint();
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
