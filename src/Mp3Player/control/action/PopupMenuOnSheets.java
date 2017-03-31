package Mp3Player.control.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import Mp3Player.GetResourceClass;
import Mp3Player.control.file.MySheets;
import Mp3Player.control.file.MySongList;
import Mp3Player.model.Components;
import Mp3Player.model.OurValue;
import Mp3Player.view.littleView.SheetNameDialog;

public class PopupMenuOnSheets extends JPopupMenu{

	/**
	 * 
	 */
	public static final int up=1;
	public static final int down=2;
	private static final long serialVersionUID = 1L;
	JMenuItem reName;
	JMenuItem delete;
	JMenuItem clear;
	
	public  PopupMenuOnSheets(int location) {
		clear=new JMenuItem("清空列表");
		clear.setFont(OurValue.getFont());
		add(clear);
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MySongList.deleteAllSongsFromListname(Components.mySongSheetsNameList.get(OurValue.getLastActiveLabel().getId()));
				Components.songList.clear();
				Components.songsListTable.repaint();
			}
		});
		if(location==up)
			return;
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
				//
				String name=Components.mySongSheetsNameList.get(OurValue.getLastActiveLabel().getId());
				System.out.println(name);
				//第一步，从xml文件删除，deleteSheet函数内部会删除mysonglist里名为name的列表
				MySheets.deleteSheet(name);
				//第二步，从Components.mySongSheetsNameList里删除
				Components.mySongSheetsNameList.remove(OurValue.getLastActiveLabel().getId());
				//第三步更新界面
				Action.updateMySheetsPanel();
				Components.jscrolJanel.validate();
				Components.jscrolJanel.repaint();
				OurValue.setLastActionLabel(null);
			}
		});
		reName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//第一步，弹出对话框让用户输入正确的新名字
				SheetNameDialog sheetNameDialog=new SheetNameDialog(Components.frame, SheetNameDialog.rename);
				sheetNameDialog.setVisible(true);
				System.out.println("bbb");
				if(sheetNameDialog.isRight()){
					//第二步，更新xml文件，updateSheet这个函数还会更新mysonglist这个xml文件
					String newName=sheetNameDialog.getName();
					String oldName=Components.mySongSheetsNameList.get(OurValue.getLastActiveLabel().getId());
					MySheets.updateSheet(oldName, newName);
					//第三步，更新Components.mySongSheetsNameList
					Components.mySongSheetsNameList.set(OurValue.getLastActiveLabel().getId(), newName);
					//第四步，更新显示
					OurValue.getLastActiveLabel().setText(newName);
				}
			}
		});
	}
}
