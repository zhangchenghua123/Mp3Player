package Mp3Player.control;

import java.util.ArrayList;


import Mp3Player.control.file.MySheets;
import Mp3Player.model.Components;
public class Init {
	public static void initialization(){
		Components.mySongSheetsNameList=new ArrayList<String>();
		MySheets.init();
		MySheets.getAllSheets();
		
	}
}
