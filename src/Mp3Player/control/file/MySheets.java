package Mp3Player.control.file;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;


import javax.sound.midi.VoiceStatus;
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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Mp3Player.model.Components;

/**
 * 对保存创建列表的文件mySheets.xml的操作
 * 文件保存在D盘根目录
 * 文件格式
 * <?xml version="1.0" encoding="UTF-8"?>
 * <sheets>
 *    <sheet name="欢乐"/>
 *    .
 *    .
 *    .
 * </sheets>
 * 
 * @author Berry
 *
 */
public class MySheets {
	
	private static DocumentBuilderFactory factory=null;
	private static DocumentBuilder builder = null;
	private static Document document = null;
	
	/**
	 * 获取所有的sheet
	 */
	public static void getAllSheets(){
		try {
			document = builder.parse(new File("d:\\mySheets.xml"));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root=document.getDocumentElement();
		NodeList list=root.getElementsByTagName("sheet");
		for(int i=0;i<list.getLength();i++){
			Components.mySongSheetList.add(((Element)(list.item(i))).getAttribute("name"));
			System.out.println("aaaa"+Components.mySongSheetList.get(i));
		}
	}
	/**
	 * 添加一个列表名
	 * @param name
	 */
	public static void AddSheet(String name){
		try {
			document = builder.parse(new File("d:\\mySheets.xml"));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element root=document.getDocumentElement();
		Element newElement=document.createElement("sheet");
		newElement.setAttribute("name",name);
		Components.mySongSheetList.add(name);
		root.appendChild(newElement);
		updateLocalFile(document, "d:\\mySheets.xml");
	}
	/**
	 * 删除一个列表名
	 */
	public static void deleteSheet(String name){
		
	}
	/**
	 * 更新一个列表名
	 */
	public static void updateSheet(String oldName,String newName){
		
	}
	/**
	 * 创建一个不含子节点的xml文件
	 */
	private static void createFile() {
		document = builder.newDocument();
		Element root = document.createElement("sheets");
		document.appendChild(root);
        updateLocalFile(document, "d:\\mySheets.xml");
	}
	/**
	 * 判断文件是不是存在
	 */
	private static boolean isFileExist(){
		File file=new File("d:\\mySheets.xml");
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
