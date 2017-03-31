package Mp3Player.control.mouseListener;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import Mp3Player.control.action.PopupMenuOnSong;
import Mp3Player.model.Components;
import Mp3Player.model.OurValue;

public class tableListener implements MouseListener,MouseMotionListener{

	public int lastrow=-1;

	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=Components.songsListTable.rowAtPoint(e.getPoint());
		if(OurValue.getCurrentRow()!=row){
			OurValue.setCurrentRow(row);
			System.out.println("aa"+row);
		}
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch (e.getClickCount()) {
		case 1:
			switch (e.getButton()) {
			case MouseEvent.BUTTON1://单击
				
				break;
			case MouseEvent.BUTTON3://右击
				PopupMenuOnSong popupMenuOnSong=new PopupMenuOnSong();
		
				popupMenuOnSong.show(Components.songsListTable, e.getX(), e.getY());
				break;
			default:
				break;
			}
			break;
		case 2:                     //双击
			
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
		OurValue.setCurrentRow(Components.songsListTable.rowAtPoint(e.getPoint()));
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
