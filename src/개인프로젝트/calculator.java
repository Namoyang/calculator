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

	calculator(){
		setTitle("Date Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		JLabel jl1 = new JLabel("연도");
		JTextField tf1 = new JTextField(4);
		JLabel jl2 = new JLabel("월");
		JTextField tf2 = new JTextField(2);
		JLabel jl3 = new JLabel("일");
		JTextField tf3 = new JTextField(2);
		JButton btn = new JButton("계산");
		cp.add(jl1);
		cp.add(tf1);
		cp.add(jl2);
		cp.add(tf2);
		cp.add(jl3);
		cp.add(tf3);
		cp.add(btn);
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String year = tf1.getText();
				for(int i=0;i<year.length();i++){
					char c = year.charAt(i);
					if(c<48 || c> 57){//숫자가 아닌 경우
						break;
					}
				}
				//출처 : http://appsnuri.tistory.com/80 [이야기앱 세상]
			}
		});
		setSize(800,600);
		setVisible(true);
	}

	void calculate (int a, int b, int c){
		Calendar cal = Calendar.getInstance();
		//[출처] [JAVA] Calendar (캘린더) 클래스 (추가: 날짜 계산 및 관련 함수, 날짜포맷;SimpleDateFormat)|작성자 자바킹
		int yr = cal.get(Calendar.YEAR);
		int yr1 = yr;
		int mn1 = cal.get(Calendar.MONTH);
		int mn2 = mn1;
		int dt = cal.get(Calendar.DATE);
		int md = 0;
		int d[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(year(a)){ 
			d[1] = 29;
		}
		else{
			d[1] = 28;
		};
		for(;yr<= a; yr++){
			if(mn1 == mn2 & yr == yr1){
				md = d[mn1-1] - dt; 
				mn1++;
				for(; mn1 <= 12; mn1++){
					md += d[mn1-1];   
				}
			}
			else{
				for(int i = 0; i < 12 ; i++){
					if(yr == a & mn1 == b) { md += c; break;}
					else md += d[i];
				}
			}
		}
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


