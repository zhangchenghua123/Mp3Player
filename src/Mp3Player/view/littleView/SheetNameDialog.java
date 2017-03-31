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

import Mp3Player.model.Components;
import Mp3Player.model.OurValue;
/**
 * 添加列表时出现的对话框
 * @author Berry
 *
 */
public class SheetNameDialog extends JDialog {
	JPanel panel;
	JLabel label;
	JTextField nameField;
	JLabel showinfoLabel;
	JButton yesbButton;
	JButton cancelButton;
	boolean isright;
	public static final int add=1;
	public static final int rename=2;
	public SheetNameDialog(Frame owner,final int type){
		super(owner,"添加新列表");
		if(type==rename)
			setTitle("修改列表名");
		isright=false;
		setBounds(Mp3Player.model.Components.frame.getX()+300,
				Mp3Player.model.Components.frame.getY()+ 200, 300, 200);
		setModal(true);
		setResizable(false);
		panel=new JPanel();
		panel.setLayout(null);
		label=new JLabel();
		label.setBounds(20,30,200,30);
		label.setFont(OurValue.getFont());
		nameField=new JTextField();
		nameField.setBounds(45, 65, 150, 30);
		nameField.setColumns(20);
		yesbButton=new JButton("确定");
		yesbButton.setBounds(25, 100, 80, 30);
		cancelButton=new JButton("取消");
		cancelButton.setBounds(130, 100, 80, 30);
		showinfoLabel=new JLabel("");
		showinfoLabel.setBounds(200, 125, 200, 30);
		showinfoLabel.setForeground(new Color(255,0,0));
		
		
		switch(type){
		case add:
			label.setText("请填写列表名：");
			break;
		case rename:
			label.setText("请填写新名称：");
			break;
		}
		panel.add(nameField);
		panel.add(label);
		panel.add(yesbButton);
		panel.add(cancelButton);
		panel.add(showinfoLabel);
		setContentPane(panel);
		/**
		 * 点击确定按钮
		 */
		yesbButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(nameField.getText().equals("")){
					showinfoLabel.setText("名称不能为空！");
					showinfoLabel.repaint();
				}
				else {
					/**
					 * 
					 * 判断是否有重复
					 * 如果有，showinfolabel提示错误
					 * 如果没有，添加成功
					 */
					int i=0;
					if(nameField.getText().equals("我喜欢")
							||nameField.getText().equals("播放历史")
							||nameField.getText().equals("本地歌曲"))
					{
						showinfoLabel.setText("该列表已存在！");
						showinfoLabel.repaint();
						return;
					}
					
					for(;i<Components.mySongSheetsNameList.size();i++){
						if(Components.mySongSheetsNameList.get(i).equals(nameField.getText())
								&&(type==add||(type==rename&&i!=OurValue.getLastActiveLabel().getId()))){
							showinfoLabel.setText("该列表已存在！");
							showinfoLabel.repaint();
							return;
						}
					}
					//没有找到重复的
					isright=true;
					getthis().setVisible(false);
				}
			}
		});
		/**
		 * 点击取消按钮
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
	 * 对话框关闭（setvisible（false））后，调用此函数返回结果
	 * 取消或关闭对话框，返回“”
	 * 确定，返回不是空
	 */
	public String getName(){
		return nameField.getText();
	}
	public boolean isRight(){
		return isright;
	}
	
}
