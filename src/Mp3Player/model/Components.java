package Mp3Player.model;

import java.awt.Container;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Mp3Player.view.littleView.IconPanel;
import Mp3Player.view.littleView.JLabelOnLeftPanel;

public class Components {
	
	public static JFrame frame;
	public static Container mainContainer;//ȫ��������
	public static JPanel titlePanel;//������
	
	public static IconPanel iconPanel;//Ӧ�ó���ͼ��
	public static IconPanel pullPanel;//�����˵�
	public static IconPanel littlePanel;//��С��ͼ��
	public static IconPanel closePanel;//�ر�ͼ��
	public static JPanel bodyPanel; //���˱������Ĳ��֣�����������left��right��bottom
	public static JPanel leftPanel; //�����б���
	public static JPanel rightPanel;//�Ҳ�ĸ�����
	public static JPanel bottompPanel;//�±ߵĲ�����
	//�����Ķ���
	public static JLabel myMusic;
	public static JLabel mySongSheet;
	public static JScrollPane sheetScrollPane;
	public static JPanel sheetPanel;
	public static IconPanel addSheet;
	
}
