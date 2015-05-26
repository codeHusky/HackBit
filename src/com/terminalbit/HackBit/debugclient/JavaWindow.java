package com.terminalbit.HackBit.debugclient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.terminalbit.HackBit.HackBit;

public class JavaWindow extends JFrame implements ActionListener {
	JButton submit = new JButton("submit");
	JTextArea requestType = new JTextArea(10,10);
	JTextArea requestData = new JTextArea(10,10);
	public JavaWindow() {
		super("Data Control Panel");
		setSize(400,400);
		JPanel pane = new JPanel();
		submit.addActionListener(this);
		pane.add(requestType);
		pane.add(requestData);
		pane.add(submit);
		add(pane);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent evt){
		System.out.println(HackBit.hbsession.post(requestType.getText(),requestData.getText()).get());
	}
}
