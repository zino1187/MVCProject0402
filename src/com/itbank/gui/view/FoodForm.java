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

import com.itbank.model.FoodAdvisor;
import com.itbank.model.MovieAdvisor;

public class FoodForm extends JFrame{
	Choice ch;
	JButton bt;
	FoodAdvisor advisor;
	
	public FoodForm() {
		setLayout(new FlowLayout());
		ch = new Choice();
		ch.add("���İ�Ƽ");
		ch.add("��ġ���");
		ch.add("�ʹ�");
		bt = new JButton("�Ǵ� ��û");
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
		//���� ���ϱ�
		String movie=ch.getSelectedItem();
		String msg=advisor.getAdvice(movie);
		JOptionPane.showMessageDialog(this, msg);
	}
	public static void main(String[] args) {
		new FoodForm();
	}
}








