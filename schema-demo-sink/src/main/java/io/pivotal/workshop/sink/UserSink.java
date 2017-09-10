package io.pivotal.workshop.sink;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.messaging.handler.annotation.Headers;

import io.pivotal.workshop.domain.User;

@EnableSchemaRegistryClient
@EnableBinding(Sink.class)
public class UserSink {

	Logger log = LoggerFactory.getLogger("MySink");
	
	@StreamListener(Sink.INPUT)
	public void log(User user,@Headers Map<String,String> map){
		log.info(">>> Received: " + user);
		log.info(">>>  Headers: " + map.toString());
	}
}
