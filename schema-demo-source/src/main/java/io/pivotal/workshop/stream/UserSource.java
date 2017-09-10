package io.pivotal.workshop.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.schema.client.EnableSchemaRegistryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import io.pivotal.workshop.domain.User;

@EnableBinding(Source.class)
@EnableSchemaRegistryClient
public class UserSource {

	@Bean
	@InboundChannelAdapter(channel=Source.OUTPUT,poller={@Poller(fixedRate="3000")})
	public MessageSource<User> sendUser(){
		return () -> new GenericMessage<>(users.get(rand.nextInt(users.size())));
		
	}
	
	private Random rand = new Random();
	private List<User> users = Arrays.asList(
			new User("John","john@email.com"),
			new User("Carl","carl@email.com"),
			new User("Mark","mark@email.com"),
			new User("Mike","mike@email.com"));
}
