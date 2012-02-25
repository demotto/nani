package com.taohua.atpanel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class LogTuple{
	String url;
	String time;
	String refer_pre;
	LogTuple(String url ,String time,String refer_pre){
		this.url = url;
		this.time = time;
		this.refer_pre = refer_pre;
	}
	public void printMe(){
		System.out.println("url=" + url + " " + "time=" + time + "refer_pre=" + refer_pre);
	}
	public static List<LogTuple>  strToLogList(String line){
		String  []logItem =line.split("<yoshi>"); 
		List<LogTuple > list = new ArrayList<LogTuple>();
		
		
				
		for (String item : logItem){
			String []subItem = item.split("<nani>");
			if(subItem.length==2)
				list.add(new LogTuple(subItem[0],subItem[1],null));
			else list.add(new LogTuple(subItem[0],subItem[1],subItem[2]));
		}
		return list;
	}
}

class LogTupleParserTester{
	protected LogTupleParserTester(){}
	static LogTupleParserTester newInstance(){
		return new LogTupleParserTester();
	}
	public List<LogTuple>  loadFromFile(String fn) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(fn))); 
	    String line=br.readLine();
	    List<LogTuple > list = LogTuple.strToLogList(line);
		return list;
	}
}


public class LogTupleParser {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String fn = "/home/hadoop/test/log";
		List<LogTuple > logList = LogTupleParserTester.newInstance().loadFromFile(fn);
		for(LogTuple t : logList){
			t.printMe();
		} 
		//System.out.println(new ArrayList<LogTuple>().size()==0);
	}

}
