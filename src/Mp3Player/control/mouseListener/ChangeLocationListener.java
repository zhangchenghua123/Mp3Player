package Mp3Player.control.mouseListener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
/**
 * 标题栏titlepanel的监听
 * 通过鼠标移动窗体
 * @author Berry
 *
 */
public class ChangeLocationListener implements MouseMotionListener,MouseListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			Point point=Mp3Player.model.Components.frame.getLocation();
			Mp3Player.model.Components.frame.setLocation(point.x-Mp3Player.view.MainView.originPoint.x+e.getX(), point.y+e.getY()-Mp3Player.view.MainView.originPoint.y);
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			Mp3Player.view.MainView.originPoint.x=e.getX();
			Mp3Player.view.MainView.originPoint.y=e.getY();
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	}

