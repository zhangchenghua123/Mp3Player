package Mp3Player.control.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Mp3Player.model.Components;

/**
 * 歌曲列表有我喜欢、播放历史、本地歌曲，还有动态创建的歌单
 * 我喜欢：用户通过点击喜欢按钮，添加本首歌的绝对路径到我喜欢的子节点中，歌曲不可重复
 * 播放历史：每播放一首歌，就将绝对路径添加到子节点中，歌曲
 *  文件格式
 * <?xml version="1.0" encoding="UTF-8"?>
 * <lists>
 *    <list name="我喜欢">
 *    	<item>文件路径</item>
 *    	.
 *    	.
 *    	.
 *    </list>
 *    .
 *    .
 *    .
 * </lists>
 * @author Berry
 *
 */
public class MySongList {
	private static DocumentBuilderFactory factory=null;
	private static DocumentBuilder builder = null;
	private static Document document = null;

	
	
	
	/**
	 * 
	 */
	public static void getsongsByListName(String listName){
		try {
			document = builder.parse(new File("d:\\mySongLists.xml"));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root=document.getDocumentElement();
		//先判断有没有name是listname的节点
		Element node = null;
		NodeList list=root.getElementsByTagName("list");
		boolean flag=false;
		for(int i=0;i<list.getLength()&&!flag;i++){
			node=(Element) list.item(i);
			if(((Element)(list.item(i))).getAttribute("name").equals(listName)){
				NodeList itemlist=node.getElementsByTagName("item");
				for(int j=0;j<itemlist.getLength();j++){
					Node itemNode=itemlist.item(j);
					File file=new File(itemNode.getTextContent());
					String fileName=file.getName();
					Vector<String> vector=new Vector<String>();
					
					vector.add(fileName);
					vector.add(fileName.substring(fileName.lastIndexOf(".")+1));
					vector.add("5:20");
					vector.add("wo");
					Components.songList.add(vector);
				}
				flag=true;
				break;
			}
		}
		
		
	}
	/**
	 * 添加一首歌的location到名称为listname的列表的子节点中
	 * @param listName
	 * @param songLocation
	 * @return
	 */
	public static boolean  addSongToList(String listName,String songLocation){
		try {
			document = builder.parse(new File("d:\\mySongLists.xml"));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root=document.getDocumentElement();
		//先判断有没有name是listname的节点
		NodeList list=root.getElementsByTagName("list");
		int i;
		Node node = null;
		for(i=0;i<list.getLength();i++){
			node=list.item(i);
			if(((Element)(list.item(i))).getAttribute("name").equals(listName)){
				break;
			}
		}
		if(i==list.getLength()){ //没有listname这个节点
			Element newElement=document.createElement("list");
			newElement.setAttribute("name",listName);
			root.appendChild(newElement);
			Element item=document.createElement("item");
			item.setTextContent(songLocation);
			newElement.appendChild(item);
			updateLocalFile(document, "d:\\mySongLists.xml");
		}
		else{  //有listname这个节点，先判断item是否存在，如果存在就不允许添加，否则直接把item添加进去
			NodeList itemList=node.getChildNodes();
			for(i=0;i<itemList.getLength();i++){
				if(itemList.item(i).getTextContent().equals(songLocation))
					return false;
			}
			Element item=document.createElement("item");
			item.setTextContent(songLocation);
			node.appendChild(item);
			updateLocalFile(document, "d:\\mySongLists.xml");
		}
		
		return true;
	}
	
	/**
	 * 创建一个不含子节点的xml文件
	 */
	private static void createFile() {
		document = builder.newDocument();
		Element root = document.createElement("lists");
		document.appendChild(root);
        updateLocalFile(document, "d:\\mySongLists.xml");
	}
	/**
	 * 判断文件是不是存在
	 */
	private static boolean isFileExist(){
		File file=new File("d:\\mySongLists.xml");
		if(file.exists())
			return true;
		else{
			return false;
		}
	}
	public static void init(){
		factory=DocumentBuilderFactory.newInstance();
		try {
			builder=factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!isFileExist())
			createFile();
	}
	/**
	 * 更新document后，只是更新了内存中缓存的数据，要更新文件中的数据，就是重写文件
	 * 这个方法是通用的，可以被file包的另外两个调用。
	 * @param document
	 * @param filename
	 */
	public static void updateLocalFile(Document document,String filename){
		TransformerFactory transformerFactory = TransformerFactory.newInstance();  
        Transformer transformer = null;
		try {
			transformer = transformerFactory.newTransformer();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		transformer.setOutputProperty("encoding", "UTF-8");  
        
        StringWriter writer = new StringWriter();  
        try {
			transformer.transform(new DOMSource(document), new StreamResult(writer));
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        try {
			transformer.transform(new DOMSource(document), new StreamResult(new File(filename)));
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
