package Mp3Player.model;

import javax.swing.table.AbstractTableModel;

public class TableValues extends AbstractTableModel{
	 public final static int NAME = 0;
     public final static int GENDER = 1;
     public final static String[] columnNames = {"文件名", "类型","时长","歌手"};

     public int getColumnCount() {
               return 4;
     }
     public int getRowCount() {
               return Components.songList.size();
     }
     public Object getValueAt(int rowIndex, int columnIndex) {
               return Components.songList.get(rowIndex).get(columnIndex+1);
     }
     /**
      * 设置列名
      */
     public String getColumnName(int column){
               return columnNames[column];
     }
}
