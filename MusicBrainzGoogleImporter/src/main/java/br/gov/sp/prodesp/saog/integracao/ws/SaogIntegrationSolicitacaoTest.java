package br.gov.sp.prodesp.saog.integracao.ws;
/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.integration.support.channel.BeanFactoryChannelResolver;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.core.DestinationResolver;


/**
 *
 * @author Canova
 */
public class SaogIntegrationSolicitacaoTest implements ApplicationContextAware {

	private static final Logger log = LoggerFactory.getLogger(SaogIntegrationSolicitacaoTest.class);
	
	private DynamicPeriodicTrigger trigger;
	
	public DynamicPeriodicTrigger getTrigger() {
		return trigger;
	}


	public void setTrigger(DynamicPeriodicTrigger trigger) {
		this.trigger = trigger;
	}

	private ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context =
			new ClassPathXmlApplicationContext("/META-INF/spring/ws-solicitacao-msg000-request.xml");
		
		SaogIntegrationSolicitacaoTest app = context.getBean("app" , SaogIntegrationSolicitacaoTest.class );
		
	}


	public void sendMessage()
	{ 
		
		DestinationResolver<MessageChannel> channelResolver = new BeanFactoryChannelResolver(applicationContext);
		String requestXml = 
				"<saog xmlns=\"http://saog.prodesp.sp.gov.br/solicitacao/\">" +
						"<operadora>0</operadora>" +
				"</saog>";

		// Create the Message object
		Message<String> message = MessageBuilder.withPayload(requestXml).build();

		// Send the Message to the handler's input channel
		MessageChannel channel = channelResolver.resolveDestination("bootChannel");
		channel.send(message);
		
		
	}

	public void sendMessageIncidente()
	{ 
		
		DestinationResolver<MessageChannel> channelResolver = new BeanFactoryChannelResolver(applicationContext);
		String requestXml = 
				"<saog xmlns=\"http://saog.prodesp.sp.gov.br/incidente/\">" +
						"<operadora>0</operadora>" +
				"</saog>";

		// Create the Message object
		Message<String> message = MessageBuilder.withPayload(requestXml).build();

		// Send the Message to the handler's input channel
		MessageChannel channel = channelResolver.resolveDestination("bootIncidenteChannel");
		channel.send(message);
		
		
	}
	
	public String requestMessage()
	{
		 return new SimpleDateFormat ("hh:mm:ss.SSS").format(new Date());
				/*"<saog xmlns=\"http://saog.prodesp.sp.gov.br/solicitacao/\">" +
						"<operadora>0</operadora>" +
				"</saog>";*/
	}
	
	public String requestMessageIncidente()
	{ 
		 return 
				"<saog xmlns=\"http://saog.prodesp.sp.gov.br/incidente/\">" +
						"<operadora>0</operadora>" +
				"</saog>";
	}
	
	public void checkMessagePayload(Message<?> message)
	{ 
		log.debug("Checking messagePayload" );
		log.debug(message.getPayload().toString());
		log.debug(message.getHeaders().toString());
		log.debug("End Checking messagePayload" );
	}
	
	public void dispatchMessageElement(Message<?> message) 
	{ 
		Message<?> messageToDispach = null; 
		
		messageToDispach = MessageBuilder.withPayload( message.getPayload()).copyHeaders(message.getHeaders()).build();
		
		DestinationResolver<MessageChannel> channelResolver = new BeanFactoryChannelResolver(applicationContext);
		
		MessageChannel channel = channelResolver.resolveDestination((String)message.getHeaders().get("outputChannel"));
		
		channel.send(message);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
}