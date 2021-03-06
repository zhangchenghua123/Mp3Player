package Mp3Player.view.littleView;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * 图标类的按钮
 * 鼠标指向时，显示img_active_url路径下的图片，否则显示img_unactive_url下的图片
 * 点击时，根据设置的固有ID，在ChangeIconBGlistener的点击监听器中根据ID执行任务
 */
public class IconPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private boolean isActivite;
	private URL img_active_url;
	private URL img_unactive_url;
	private int id;
	public IconPanel(int id,URL img_active_url,URL img_unactive_url) {
		isActivite=false;
		this.id=id;
		this.img_active_url=img_active_url;
		this.img_unactive_url=img_unactive_url;
	}
	
 	public int getId() {
		return id;
	}

 	
	public URL getImg_active_url() {
		return img_active_url;
	}

	public void setImg_active_url(URL img_active_url) {
		this.img_active_url = img_active_url;
	}

	public URL getImg_unactive_url() {
		return img_unactive_url;
	}

	public void setImg_unactive_url(URL img_unactive_url) {
		this.img_unactive_url = img_unactive_url;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isActivite() {
		return isActivite;
	}

	public void setActivite(boolean isActivite) {
		this.isActivite = isActivite;
	}

	


	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
//		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = 0, y = 0;
		   ImageIcon icon;
		   
		   if(isActivite)
			   icon=new ImageIcon(img_active_url);
		   else 
			   icon=new ImageIcon(img_unactive_url);
		   ((Graphics2D)g).drawImage(icon.getImage(), x, y, getSize().width,getSize().height, this);// 图片会自动缩放
	}

}
