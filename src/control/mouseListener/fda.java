package control.mouseListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import view.littleView.IconPanel;

public class fda implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		view.MainView.frame.setExtendedState(JFrame.ICONIFIED);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		view.MainView.originPoint.x=e.getX();
		view.MainView.originPoint.y=e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		((IconPanel)e.getComponent()).setActivite(false);
		((IconPanel)e.getComponent()).repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		((IconPanel)e.getComponent()).setActivite(true);
		((IconPanel)e.getComponent()).repaint();
	}

}
