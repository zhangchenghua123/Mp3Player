package Mp3Player.view.littleView;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Mp3Player.model.OurValue;
/**
 * ����б�ʱ���ֵĶԻ���
 * @author Berry
 *
 */
public class AddSheetDialog extends JDialog {
	JPanel panel;
	JLabel label;
	JTextField nameField;
	JLabel showinfoLabel;
	JButton yesbButton;
	JButton cancelButton;
	public AddSheetDialog(Frame owner, String title){
		super(owner,title);
		setBounds(Mp3Player.model.Components.frame.getX()+300,
				Mp3Player.model.Components.frame.getY()+ 200, 300, 200);
		setModal(true);
		setResizable(false);
		panel=new JPanel();
		panel.setLayout(null);
		label=new JLabel("����д�б�����");
		label.setBounds(20,30,200,30);
		label.setFont(OurValue.getFont());
		nameField=new JTextField();
		nameField.setBounds(45, 65, 150, 30);
		nameField.setColumns(20);
		yesbButton=new JButton("ȷ��");
		yesbButton.setBounds(25, 100, 80, 30);
		cancelButton=new JButton("ȡ��");
		cancelButton.setBounds(130, 100, 80, 30);
		showinfoLabel=new JLabel("");
		showinfoLabel.setBounds(200, 125, 200, 30);
		showinfoLabel.setForeground(new Color(255,0,0));
		panel.add(nameField);
		panel.add(label);
		panel.add(yesbButton);
		panel.add(cancelButton);
		panel.add(showinfoLabel);
//		panel.setPreferredSize(new Dimension(300, 200));
		setContentPane(panel);
		/**
		 * ���ȷ����ť
		 */
		yesbButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(nameField.getText().equals("")){
					showinfoLabel.setText("���Ʋ���Ϊ�գ�");
					showinfoLabel.repaint();
				}
				else {
					/**
					 * 
					 * �ж��Ƿ����ظ�
					 * ����У�showinfolabel��ʾ����
					 * ���û�У���ӳɹ�
					 */
					
					
				}
			}
		});
		/**
		 * ���ȡ����ť
		 */
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				getthis().setVisible(false);
			}
		});
	}
	public JDialog getthis(){
		return this;
	}
	/**
	 * �Ի���رգ�setvisible��false�����󣬵��ô˺������ؽ��
	 * ȡ����رնԻ��򣬷��ء���
	 * ȷ�������ز��ǿ�
	 */
	public String getName(){
		return nameField.getText();
	}
}
