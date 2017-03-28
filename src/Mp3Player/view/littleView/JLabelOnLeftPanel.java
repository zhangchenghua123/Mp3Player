package Mp3Player.view.littleView;

import javax.swing.JLabel;
/**
 * 主面板左侧显示每个列表的条形区域
 * 鼠标指向某一个时，改变背景色，并替换前边的小图标，移开时恢复状态
 * 点击时，改变另一种背景色，并替换前边的小图标，点击别的列表恢复状态
 */
public class JLabelOnLeftPanel extends JLabel{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private boolean isActive;
	public JLabelOnLeftPanel(int id,String name){
		super(name);
		isActive=false;
		this.id=id;
	}
	public int getId() {
		return id;
	}

	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
