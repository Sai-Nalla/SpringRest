package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.sender.ActiveMQMessageSender;

@Component
public class TestMessageRunner implements CommandLineRunner {
	@Autowired
	private ActiveMQMessageSender sender;

	@Override
	public void run(String... args) throws Exception {
	sender.send();

	}

}
