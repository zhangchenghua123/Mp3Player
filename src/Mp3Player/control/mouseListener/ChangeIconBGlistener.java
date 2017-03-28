package Mp3Player.control.mouseListener;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import Mp3Player.control.action.pullMenu_onTitle;
import Mp3Player.view.littleView.IconPanel;

/**
 * ��ͼ���С��ť�ļ����¼�
 * ������ϻ��Ƴ��Լ����ʱ�����Ķ���
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
		case 0: //�������������˵�
			pullMenu_onTitle  pMenu_onTitle=new pullMenu_onTitle();
//			Mp3Player.view.MainView.frame.add(pMenu_onTitle);
			pMenu_onTitle.show(e.getComponent() , 0, 48);
			break;
		case 1:
			Mp3Player.model.Components.frame.setExtendedState(JFrame.ICONIFIED);
			break;
		case 2:
			System.exit(0);
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