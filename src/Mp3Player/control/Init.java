package Mp3Player.control;

import java.util.ArrayList;
import java.util.Vector;


import Mp3Player.control.file.MySheets;
import Mp3Player.control.file.MySongList;
import Mp3Player.model.Components;
public class Init {
	public static void initialization(){
		Components.mySongSheetsNameList=new ArrayList<String>();
		Components.mySongSheetsNameList.add("我喜欢");
		Components.mySongSheetsNameList.add("播放历史");
		Components.mySongSheetsNameList.add("本地歌曲");
		MySheets.init();
		MySongList.init();
		MySheets.getAllSheets();
		Components.songList=new ArrayList<Vector<String>>();
	}
}
