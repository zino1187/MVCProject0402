/*
�������������� ��ȭ Ŭ���̾�Ʈ�� �ڹٽ��� ����!!
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
		ch.add("ĸƾ����");
		ch.add("��");
		ch.add("��������");
		bt = new JButton("�Ǵ� ��û");
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
		//���� ���ϱ�
		String movie=ch.getSelectedItem();
		String msg=advisor.getAdvice(movie);
		JOptionPane.showMessageDialog(this, msg);
	}
	public static void main(String[] args) {
		new MovieForm();
	}
}








