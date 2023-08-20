package com.lazyprogrammer.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.lazyprogrammer.notificationservice.events.Notification;

@SpringBootApplication
public class NotificationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationserviceApplication.class, args);
	}

	@KafkaListener(topics = "item-created") 
	public void listen(Notification item){
		System.out.println("item created:" + item.getId().toString());
	}
}
