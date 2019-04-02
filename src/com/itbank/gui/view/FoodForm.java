/*
웹브라우저에서의 영화 클라이언트의 자바스윙 버전!!
*/
package com.itbank.gui.view;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itbank.model.FoodAdvisor;
import com.itbank.model.MovieAdvisor;

public class FoodForm extends JFrame{
	Choice ch;
	JButton bt;
	FoodAdvisor advisor;
	
	public FoodForm() {
		setLayout(new FlowLayout());
		ch = new Choice();
		ch.add("스파게티");
		ch.add("김치찌게");
		ch.add("초밥");
		bt = new JButton("판단 요청");
		advisor = new FoodAdvisor();
		
		add(ch);
		add(bt);
		setSize(300,400);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				send();
			}
		});
	}
	public void send() {
		//조언 구하기
		String movie=ch.getSelectedItem();
		String msg=advisor.getAdvice(movie);
		JOptionPane.showMessageDialog(this, msg);
	}
	public static void main(String[] args) {
		new FoodForm();
	}
}








