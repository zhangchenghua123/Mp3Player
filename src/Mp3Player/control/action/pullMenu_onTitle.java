package Mp3Player.control.action;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.filechooser.FileNameExtensionFilter;

import Mp3Player.model.OurValue;



public class pullMenu_onTitle extends JPopupMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuItem openFile;
	JMenuItem openFolder;
	public  pullMenu_onTitle() {
		JMenu open=new JMenu("打开");
		open.setFont(OurValue.getFont());
		openFile=new JMenuItem("文件");
		openFile.setFont(OurValue.getFont());
		openFolder=new JMenuItem("文件夹");
		openFolder.setFont(OurValue.getFont());
		open.add(openFile);
		open.add(openFolder);
		this.add(open);
		addAction();
		
	}

	private void addAction() {
		// TODO Auto-generated method stub
		openFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileDialog=new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
				        "music files", "mp3", "wma","wav");
				fileDialog.setAcceptAllFileFilterUsed(false);
				fileDialog.setFileFilter(filter);
				int returnType=-4;
				returnType=fileDialog.showOpenDialog(Mp3Player.model.Components.frame);//0：选择了文件  1：没有选择
				System.out.println(returnType);
				System.out.println(fileDialog.getSelectedFile().toString());
				if(returnType==1)
				{
					//获取选择的路径和文件名，添加文件到试听列表
				}
			}
		});
		openFolder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fileDialog=new JFileChooser();
				fileDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				if(fileDialog.showOpenDialog(null)==0)
				{
					//选择文件夹，将文件夹中的音乐文件输出到列表，如果一个都没有，就提示一下用户吧。
					
					
				}
				
			}
		});
	}
}
