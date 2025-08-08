package com.nt.sender;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;

@Component
public class ActiveMQMessageSender {
	
	@Autowired
	private JmsTemplate template;

	//@Scheduled(cron = "*/10 * * * * *")
	public void send() {
		// TODO Auto-generated method stub
		/*template.send("testmQ1", new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				return session.createTextMessage("From Sender "+new Date());
			}
		});*/

		// using Lamda Style inner class
		
		template.send("topic1",ses->{
			return ses.createTextMessage("From Sender "+new Date());
			
		}
		);
		System.out.println("Message Sent");
	}

}
