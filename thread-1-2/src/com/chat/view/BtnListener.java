package com.chat.view;

import com.entity.Message;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class BtnListener implements ActionListener{

	ChatFrame chatFrame;
	public BtnListener(ChatFrame chatFrame) {
		this.chatFrame=chatFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//获取文本框值，
		String msg=chatFrame.txtMsg.getText();
		//实例化Message对象，并存入数据库
		Message message=new Message();
		message.setContent(msg);
		message.setSender(chatFrame.myself.getQqnum());
		message.setReceiver(chatFrame.another.getQqnum());
		message.setSendTime(new Date());
		message.setState(1);
		//数据库插入

		//开启新线程，发送消息

		//将消息放到多行文本框
		String content=chatFrame.txtList.getText();
		int size=chatFrame.txtList.getWidth()/4;
		int spaceSize=size-chatFrame.myself.getNickName().length()-msg.length()-1;
		if(spaceSize>0){
			for(int i=0;i<spaceSize;i++){
				content+=" ";
			}
		}
		content+=chatFrame.myself.getNickName()+":"+msg+"\n";
		chatFrame.txtList.setText(content);
	}

}
