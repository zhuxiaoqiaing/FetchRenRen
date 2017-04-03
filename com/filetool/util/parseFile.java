package com.filetool.util;

public class parseFile {
public static void parse(){
	String graphFilePath=Consts.INPUTFILE;
	 String[] graphContent = FileUtil.read(graphFilePath, null);
	String[] totalInfo=graphContent[0].split(" ");
	//网络节点数量 网络链路数量 消费节点数量
	int linkLength=Integer.valueOf(totalInfo[1]);
	//System.out.println(linkLength);
	int serverCost=Integer.valueOf(graphContent[2]);
	for(int i=4;i<4+linkLength;i++){
		System.out.println(graphContent[i]);
	}
	for(int i=5+linkLength;i<graphContent.length;i++){
		System.out.println(graphContent[i]);
	}
}
public static void main(String[]args){
	parse();
}
}
