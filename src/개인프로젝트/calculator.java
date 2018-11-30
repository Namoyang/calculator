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
	JTextField tf4 = new JTextField(2);
	JLabel jl5 = new JLabel("요일");
	JTextField tf5 = new JTextField(2);
	calculator(){
		setTitle("Date Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		//
		setContentPane(new JLabel(new ImageIcon("Main1.jpg")));
		//컴퓨터프로그래밍 8강 발표
		jl1.setLocation(420,150);
		tf1.setLocation(470,150);
		jl2.setLocation(420,200);
		tf2.setLocation(470,200);
		jl3.setLocation(420,250);
		tf3.setLocation(470,250);
		btn.setLocation(450,300);
		tf4.setLocation(470,350);
		jl5.setLocation(430,400);
		tf5.setLocation(470,400);
		jl1.setSize(30,30);
		tf1.setSize(80,30);
		jl2.setSize(30,30);
		tf2.setSize(80,30);
		jl3.setSize(30,30);
		tf3.setSize(80,30);
		btn.setSize(60,30);
		tf4.setSize(60,30);
		jl5.setSize(30,30);
		tf5.setSize(60,30);
		add(jl1);
		add(tf1);
		add(jl2);
		add(tf2);
		add(jl3);
		add(tf3);
		add(btn);
		add(tf4);
		add(jl5);
		add(tf5);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int mesa = 0;
				String year = tf1.getText();
				String month = tf2.getText();
				String date = tf3.getText();
				int b,c,d;
				try {
				b = Integer.parseInt(year);
				} catch(NumberFormatException nfe) {
					b=0;
					JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
				} 
				try {
					c = Integer.parseInt(month);
					} catch(NumberFormatException nfe) {
						c=0;
						JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
					} 
				try {
					d = Integer.parseInt(date);
				} catch(NumberFormatException nfe) {
						d=0;
						JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
				} 
				switch(c) {
				case 1:case 3:case 5:case 7:case 8:case 10:case 12:
					if(b == 0|c<1 || c>12 | d<1 | d>31 & mesa ==0){
						JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
						mesa++; 
					}break;
				case 2:	if(b == 0|c<1 || c>12 | d<1 | d>28 & mesa ==0){
					JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
					mesa++; 
				}break;
				case 4:case 6:case 9:case 11:if(b == 0|c<1 || c>12 | d<1 | d>30 & mesa ==0){
					JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
					mesa++; 
				}break;
				default:
					JOptionPane.showMessageDialog(null, "다시 입력해주세요", "Message", JOptionPane.ERROR_MESSAGE);
					mesa++; break;
				}
				if(mesa == 0) {
					int kg = calculate(b,c,d);
					String kfc = Integer.toString(kg);
					if(kg>=0)
					tf4.setText("D-" + kfc);
					else {
						kg = -kg;
						tf5.setText("D+" + Integer.toString(kg));
					}
				}
			}
		});
		setSize(1000,563);
		setVisible(true);
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
	public static void main(String[] args){
		new calculator();
	}
}


