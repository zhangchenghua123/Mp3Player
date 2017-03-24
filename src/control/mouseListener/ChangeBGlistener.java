package control.mouseListener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import view.littleView.IconPanel;
/**
 * 小按钮，鼠标移上或移出以及点击时触发的动作
 * @author Berry
 *
 */
public class ChangeBGlistener implements MouseListener,MouseMotionListener{

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
		case 1: //应用程序图标
			
			break;
		case 2:
			view.MainView.frame.setExtendedState(JFrame.ICONIFIED);
			break;
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