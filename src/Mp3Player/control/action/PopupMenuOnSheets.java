package Mp3Player.control.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Mp3Player.GetResourceClass;
import Mp3Player.control.file.MySheets;
import Mp3Player.model.Components;
import Mp3Player.model.OurValue;

public class PopupMenuOnSheets extends JPopupMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuItem reName;
	JMenuItem delete;

	public  PopupMenuOnSheets() {
		reName=new JMenuItem("重命名");
		reName.setFont(OurValue.getFont());
		delete=new JMenuItem("删除");
		delete.setIcon(new ImageIcon(GetResourceClass.class.getResource( "image/sheet_unactive.png")));
		delete.setFont(OurValue.getFont());
		add(reName);
		add(delete);
		addAction();
		
	}
	private void addAction() {
		// TODO Auto-generated method stub
		delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//提示用户是否删除，
				String name=Components.mySongSheetsNameList.get(OurValue.getLastActiveLabel().getId()-4);
				System.out.println(name);
				Components.mySongSheetsNameList.remove(OurValue.getLastActiveLabel().getId()-4);
				Action.updateMySheetsPanel();
				MySheets.deleteSheet(name);
				Components.jscrolJanel.validate();
				Components.jscrolJanel.repaint();
				OurValue.setLastActionLabel(null);
			}
		});
	}
}
