package Mp3Player.control.action;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import Mp3Player.control.file.MySongList;
import Mp3Player.model.Components;
import Mp3Player.model.OurValue;

public class PopupMenuOnSong extends JPopupMenu{

	JMenu addToMenu;
	ArrayList lists;
	public PopupMenuOnSong(){
		addToMenu=new JMenu("添加到");
		
		
		addToMenu.setFont(OurValue.getFont());
		String songName=Components.songList.get(OurValue.getCurrentRow()).get(0);
		lists=MySongList.isExistedInList(songName);
		for(int i=0;i<Components.mySongSheetsNameList.size();i++){
			String listName=Components.mySongSheetsNameList.get(i);
			final JMenuItem item=new JMenuItem(listName);
			item.setFont(OurValue.getFont());
			if(isExist(listName)){
				item.setEnabled(false);
			}
			item.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println(item.getText());
					MySongList.addSongToList(item.getText(),Components.songList.get(OurValue.getCurrentRow()).get(0));
				}
			});
			addToMenu.add(item);
		}
		add(addToMenu);
	}
	public boolean isExist(String listName){
		for(int i=0;i<lists.size();i++){
			if(lists.get(i).equals(listName))
				return true;
		}
		return false;
	}
}
