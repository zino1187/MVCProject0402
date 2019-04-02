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

import com.itbank.model.MovieAdvisor;

public class MovieForm extends JFrame{
	Choice ch;
	JButton bt;
	MovieAdvisor advisor;
	
	public MovieForm() {
		setLayout(new FlowLayout());
		ch = new Choice();
		ch.add("캡틴마블");
		ch.add("돈");
		ch.add("극한직업");
		bt = new JButton("판단 요청");
		advisor = new MovieAdvisor();
		
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
		new MovieForm();
	}
}








