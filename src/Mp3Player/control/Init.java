package Mp3Player.control;

import java.util.ArrayList;
import java.util.Vector;


import Mp3Player.control.file.MySheets;
import Mp3Player.control.file.MySongList;
import Mp3Player.model.Components;
public class Init {
	public static void initialization(){
		Components.mySongSheetsNameList=new ArrayList<String>();
		MySheets.init();
		MySongList.init();
		MySheets.getAllSheets();
		Components.songList=new ArrayList<Vector<String>>();
	}
}
