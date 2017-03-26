package Mp3Player.view.littleView;

import javax.swing.JLabel;

public class JLabelOnLeftPanel extends JLabel{
	/**
	 * 
	 */
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
