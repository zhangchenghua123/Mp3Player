package Mp3Player.control.action;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.filechooser.FileNameExtensionFilter;

import Mp3Player.control.file.MySongList;
import Mp3Player.model.Components;
import Mp3Player.model.OurValue;
import Mp3Player.view.Toast;



public class PullMenuOnTitleBar extends JPopupMenu{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JMenuItem openFile;
	JMenuItem openFolder;
	public  PullMenuOnTitleBar() {
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
				returnType=fileDialog.showOpenDialog(Mp3Player.model.Components.frame);//0表示选择并确定  1取消或关闭
				System.out.println(returnType);
//				
				if(returnType==0)
				{
					String fileName=fileDialog.getSelectedFile().toString();
					System.out.println(fileName);
					if(MySongList.addSongToList("本地歌曲", fileName)){
						MySongList.addSongToList("播放历史", fileName);
						if(OurValue.getLastActiveLabel().getId()==1||OurValue.getLastActiveLabel().getId()==2)
						{
							Vector<String> vector=new Vector<String>();
							vector.add(fileName);
							vector.add(new File(fileName).getName());
							vector.add(fileName.substring(fileName.lastIndexOf(".")+1));
							vector.add("5:20");
							vector.add("wo");
							Components.songList.add(vector);
							Components.songsListTable.repaint();
						}
						
						new Toast(Components.frame, "文件已添加至本地歌曲列表", 1000,Toast.success).start();
					}
					else 
						new Toast(Components.frame, "文件已存在，不能重复添加", 1000,Toast.error).start();
						
					
					
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
					//ѡ���ļ��У����ļ����е������ļ�������б?���һ����û�У�����ʾһ���û��ɡ�
					
					
				}
				
			}
		});
	}
}
