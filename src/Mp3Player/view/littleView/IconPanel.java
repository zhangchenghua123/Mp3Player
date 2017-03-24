package Mp3Player.view.littleView;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class IconPanel extends JPanel {
	private boolean isActivite;
	private String activiteImg;
	private String unActiviteImg;
	private int id;
	public IconPanel(int id,String activiteImg,String unActiviteImg) {
		isActivite=false;
		this.id=id;
		this.activiteImg=activiteImg;
		this.unActiviteImg=unActiviteImg;
	}
	
 	public int getId() {
		return id;
	}

	public void setName(int id) {
		this.id = id;
	}

	public boolean isActivite() {
		return isActivite;
	}

	public void setActivite(boolean isActivite) {
		this.isActivite = isActivite;
	}

	public String getActiviteImg() {
		return activiteImg;
	}

	public void setActiviteImg(String activiteImg) {
		this.activiteImg = activiteImg;
	}

	public String getUnActiviteImg() {
		return unActiviteImg;
	}

	public void setUnActiviteImg(String unActiviteImg) {
		this.unActiviteImg = unActiviteImg;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}

	public void paintComponent(Graphics g) {
	   int x = 0, y = 0;
	   ImageIcon icon;
	   super.paintComponent(g);
	   setBackground(new Color(00,143,00));
//	   if(a==1)icon= new ImageIcon("./src/image/little_active.png");// 003.jpg是测试图片在项目的根目录下
//	   else icon= new ImageIcon("./src/image/little_unactive.png");// 003.jpg是测试图片在项目的根目录下
	   if(isActivite)
		   icon=new ImageIcon(activiteImg);
	   else 
		   icon=new ImageIcon(unActiviteImg);
	   g.drawImage(icon.getImage(), x, y, getSize().width,getSize().height, this);// 图片会自动缩放
//	    g.drawImage(icon.getImage(), 50, 50,this);//图片不会自动缩放
	}

}
