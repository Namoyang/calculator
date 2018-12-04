//
package 개인프로젝트;

import java.util.Scanner;
//
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//[출처] [JAVA] Calendar (캘린더) 클래스 (추가: 날짜 계산 및 관련 함수, 날짜포맷;SimpleDateFormat)|작성자 자바킹

public class calculator extends JFrame{
	JLabel jl1 = new JLabel("연도");
	JTextField tf1 = new JTextField(4);
	JLabel jl2 = new JLabel("월");
	JTextField tf2 = new JTextField(2);
	JLabel jl3 = new JLabel("일");
	JTextField tf3 = new JTextField(2);
	JButton btn = new JButton("계산");
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField(2);
	JLabel jl4 = new JLabel("요일");
	JTextField tf6 = new JTextField("+는 기원후, -는 기원전, 0년은 없습니다.");
	calculator(){
		setTitle("Date Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		//
		setContentPane(new JLabel(new ImageIcon("Main1.jpg")));
		//컴퓨터프로그래밍 8강 발표
		//
		tf4.setEditable(false);
		tf5.setEditable(false);
		tf6.setEditable(false);
		//출처 : http://dreamzelkova.tistory.com/entry/Java-26LabelTextField-%EC%BB%B4%ED%8F%AC%EB%84%8C%ED%8A%B8
		//
		tf4.setHorizontalAlignment(JTextField.CENTER);
		tf5.setHorizontalAlignment(JTextField.CENTER);
		//출처 : https://m.blog.naver.com/PostView.nhn?blogId=idwook80&logNo=150030820034&proxyReferer=https%3A%2F%2Fwww.google.co.kr%2F
		jl1.setLocation(420,150);
		tf6.setLocation(560,150);
		tf1.setLocation(470,150);
		jl2.setLocation(420,200);
		tf2.setLocation(470,200);
		jl3.setLocation(420,250);
		tf3.setLocation(470,250);
		btn.setLocation(450,300);
		tf4.setLocation(440,350);
		tf5.setLocation(460,400);
		jl4.setLocation(495,400);
		jl1.setSize(30,30);
		tf1.setSize(80,30);
		tf6.setSize(205,30);
		jl2.setSize(30,30);
		tf2.setSize(80,30);
		jl3.setSize(30,30);
		tf3.setSize(80,30);
		btn.setSize(60,30);
		tf4.setSize(100,30);
		tf5.setSize(30,30);
		jl4.setSize(30,30);
		add(jl1);
		add(tf1);
		add(tf6);
		add(jl2);
		add(tf2);
		add(jl3);
		add(tf3);
		add(btn);
		add(tf4);
		add(tf5);
		add(jl4);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int mesa = 0;
				String year = tf1.getText();
				String month = tf2.getText();
				String date = tf3.getText();
				tf4.setText("");
				tf5.setText("");
				int b,c,d;
				try {
				b = Integer.parseInt(year);
				} catch(NumberFormatException nfe) {
					b=0;
				} 
				try {
					c = Integer.parseInt(month);
					} catch(NumberFormatException nfe) {
						c=0;
					} 
				try {
					d = Integer.parseInt(date);
				} catch(NumberFormatException nfe) {
						d=0;
				} 
				if(b>0 & b<=1000000) {
				switch(c) {
				case 1:case 3:case 5:case 7:case 8:case 10:case 12:
					if(b == 0|c<1 | c>12 | d<1 | d>31 & mesa ==0){
						JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
						mesa++; 
					}break;
				case 2:	if(b == 0|c<1 | c>12 | d<1 | d>28 & mesa ==0 & !year(b)){
					JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
					mesa++; 
				}
				else if(b == 0|c<1 | c>12 | d<1 | d>29 & mesa ==0 & year(b)) {
					JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
					mesa++;
				}break;
				case 4:case 6:case 9:case 11:if(b == 0|c<1 | c>12 | d<1 | d>30 & mesa ==0){
					JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
					mesa++; 
				}break;
				default:JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
					    mesa++; 
					    break;
				}
				}
				else if(b<0 & b>=-1000001) {
					switch(c) {
					case 1:case 3:case 5:case 7:case 8:case 10:case 12:
						if(b == 0|c<1 | c>12 | d<1 | d>31 & mesa ==0){
							JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
							mesa++; 
						}break;
					case 2:	if(b == 0|c<1 | c>12 | d<1 | d>28 & mesa ==0 & !bcyear(b)){
						JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
						mesa++; 
					}
					else if(b == 0|c<1 | c>12 | d<1 | d>29 & mesa ==0 & bcyear(b)) {
						JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
						mesa++;
					}break;
					case 4:case 6:case 9:case 11:if(b == 0|c<1 | c>12 | d<1 | d>30 & mesa ==0){
						JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
						mesa++; 
					}break;
					default:JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
						    mesa++; 
						    break;
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "연도는 0년을 제외한 -1000001년(기원전 1000001년)부터 1000000년 사이까지만 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
				    mesa++; 
				}
				if(mesa == 0) {
					int kg = calculate(b,c,d);
					String kfc = Integer.toString(kg);
					if(kg>0) {
					tf4.setText("D-" + kfc);
					tf5.setText(day(kg));
					}
					else if(kg==0) {
						tf4.setText("D-Day!");
						tf5.setText(day(kg));
					}
					else {
						int kj = -kg;
						tf4.setText("D+" + Integer.toString(kj));
						tf5.setText(day(kg));
					}
			       
				}
			}
		});
		setSize(1000,563);
		setVisible(true);
	}
    String day(int a) {
    	//
    	Calendar cal= Calendar.getInstance ( );
    	int day_of_week = cal.get ( Calendar.DAY_OF_WEEK );
    	//[출처] [JAVA] Calendar (캘린더) 클래스 (추가: 날짜 계산 및 관련 함수, 날짜포맷;SimpleDateFormat)|작성자 자바킹
    	int cv = a % 7;
    	String m_week = null;
    	if(a>=0) {
    	   cv += day_of_week;
    	   if(cv>7) cv = cv % 7;
    	   switch(cv) {
    	   case 1: m_week = "일"; break;
    	   case 2: m_week = "월"; break;
    	   case 3: m_week = "화"; break;
    	   case 4: m_week = "수"; break;
    	   case 5: m_week = "목"; break;
    	   case 6: m_week = "금"; break;
    	   case 7: m_week = "토"; break;
    	   }
    	}
    	else {
    	   cv += day_of_week;
     	   if(cv<-7) cv = cv % 7;
     	   switch(cv) {
     	   case -6:case 1: m_week = "일"; break;
     	   case -5:case 2: m_week = "월"; break;
     	   case -4:case 3: m_week = "화"; break;
     	   case -3:case 4: m_week = "수"; break;
     	   case -2:case 5: m_week = "목"; break;
     	   case -1:case 6: m_week = "금"; break;
     	   case 0:case 7: m_week = "토"; break;
     	   }
    	}
        return m_week;
    }
	
	int calculate (int a, int b, int c){
		//
		Calendar cal = Calendar.getInstance();
		int yr = cal.get(Calendar.YEAR);
		int mn = cal.get(Calendar.MONTH)+1;
		int dt = cal.get(Calendar.DATE);
		//[출처] [JAVA] Calendar (캘린더) 클래스 (추가: 날짜 계산 및 관련 함수, 날짜포맷;SimpleDateFormat)|작성자 자바킹
		int y1 = yr;
		int m1 = mn;
		int d1 = dt;
		int md = 0;
		int d[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(a > yr) {
			for(y1=yr;y1<=a;y1++) {
				if(year(y1)) d[1] = 29;
				else d[1] = 28;
				if(y1==yr) {
					for(int i = mn-1; i<12; i++) {
						if(i==mn-1) md = md + (d[i] - dt);
						else md+=d[i];
					}
				}
				else {
					if(y1==a) {
						for(int i =0; i<b; i++) {
							if(i==b-1) md += c;
							else md+=d[i];
						}
					}
					else {
						for(int i =0;i<12;i++) {
							md += d[i];
						}
					}
				}
			}
		}
		else if (a == yr) {
			if(year(a)) d[1] = 29;
			else d[1] = 28;
			if(b>mn) {
				for(int i=mn-1;i<b;i++) {
					if(i==b-1) md += c;
					else md += d[i];
				}
			}
			else if(b==mn) {
				 md = md + (c - dt);
			}
			else {
				for(int i=mn-1;i>=b-1;i--) {
					if(i==mn-1) md -= dt;
					else if(i==b-1) md = md - (d[i]-c);
					else md -= d[i];
				}
			}
		}
		 return md;
	}
	boolean year(int x){
		if(x%4 == 0){
			if(x%100 == 0){
				if(x%400 == 0){
					return true;
				}
				else return false;
			}
			else return true;
		}
		else return false;
	}
	boolean bcyear(int x){
		if(x%4 == -1){
			if(x%100 == -1){
				if(x%400 == -1){
					return true;
				}
				else return false;
			}
			else return true;
		}
		else return false;
	}
	public static void main(String[] args){
		new calculator();
	}
}
//자바 에센셜 코드 응용해서 만듦

