package com.user.view;

import com.chat.view.ChatFrame;
import com.entity.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnListener implements ActionListener {
	LoginFrame loginFrame;
	public BtnListener(LoginFrame loginFrame){
		this.loginFrame=loginFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String qqNum=loginFrame.txtQqNum.getText();
		String password=new String(loginFrame.txtPassword.getPassword());

		User user = new User();
		user.setQqnum(Integer.parseInt(qqNum));
		user.setNickName("adice");
		MainFrame mf=new MainFrame(user);
//		ChatFrame chatFrame = new ChatFrame(user, "a b");
		loginFrame.dispose();
		loginFrame=null;
	}
}
