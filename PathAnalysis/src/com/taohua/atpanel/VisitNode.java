package com.taohua.atpanel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VisitNode {

	/**
	 * @param args
	 */
	
	String url;
	String time;
	String refer_pre;
	VisitNode parent = null;
	List<VisitNode> childList = null;
	public VisitNode(String url,String time,String refer_pre){
		this.url = url; this.time = time; this.refer_pre = refer_pre;
	};
	public static VisitNode logTupleListToVisitForest(List<LogTuple> list){
		
		return null;
	}
	
	public static void printVisitNode(VisitNode vn){
		System.out.println("url=" + vn.url + " " + "time=" + vn.time + "refer_pre=" + vn.refer_pre);
		for(VisitNode cn : vn.childList)
			printVisitNode(cn);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fn = "/home/hadoop/path_analysis/long.txt";
		List<LogTuple > logList = LogTupleParserTester.newInstance().loadFromFile(fn);
		for(LogTuple t : logList){
			if(t.refer_pre==null) System.out.println("got it");
			//System.out.println(t.refer_pre);
		}
	}

}
