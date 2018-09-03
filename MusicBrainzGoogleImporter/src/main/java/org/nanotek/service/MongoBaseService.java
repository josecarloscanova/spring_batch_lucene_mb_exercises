package org.nanotek.service;

import java.util.Optional;

import org.nanotek.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandlingException;
import org.springframework.messaging.support.MessageBuilder;

/**
 * Proposito, conjunto de operacoes mongodb baseadas no padrao Service Activator, 
 * 
 * @author jose.canova
 *
 */
@MessageEndpoint
public class MongoBaseService {

	public static final String DOCUMENT_ID = "document_id";

	@Autowired
	private MongoOperations mongoOperations;

	public MongoBaseService() {}

	@ServiceActivator(inputChannel="mongoInputChannel" , outputChannel="mongoOutputChannel")
	public  <T extends Base<String>> Message<T> baseInsertGateway(final Message<T> requestMessage) { 
		T payload = requestMessage.getPayload();
		if(!Optional.ofNullable(payload.getId()).orElse("").isEmpty()) { 
			save(payload);
		}else {
			insert(payload);
		}
		return MessageBuilder
				.withPayload(payload)
				.copyHeaders(requestMessage.getHeaders())
				.setHeader(DOCUMENT_ID, payload.getId())
				.build();
	}


	@ServiceActivator(inputChannel="httpAbisErrorMessageHandlerChannel" , outputChannel="errorHandlerOutputChannel")
	public <T extends Base<String>> Message<T> errorMessageGateway(final Message<MessageHandlingException> requestMessage){ 
		MessageHandlingException payload = requestMessage.getPayload();
		Message<?> originalMessage = payload.getFailedMessage();
		String documentId = originalMessage.getHeaders().get(DOCUMENT_ID).toString();
		T agreementPayload = findAndRemoveMessage(documentId);
		return MessageBuilder
				.withPayload(agreementPayload)
				.copyHeaders(originalMessage.getHeaders())
				.build();
	}

	
	public <T extends Base<String>> void insert(T document) { 
		mongoOperations.insert(document);
	}
	
	public <T extends Base<String>> void save (T document) { 
		mongoOperations.save(document);
	}
	
	public  <T extends Base<String>> T findById(final String documentId , Class<T> clazz){ 
		return mongoOperations.findById(documentId, clazz);
	}

	public AgreementRequest findAndRemoveMessage(String documentId){
		AgreementRequest message = findById(documentId);
		removeMessageFromDb(message);
		return message;
	}

	public <T extends AgreementRequest> void removeMessageFromDb(T document) {
		mongoOperations.remove(document);
	}
	
	public void removeMessageFromDb(String documentId){
		AgreementRequest message = findById(documentId);
		if (message !=null) {
			removeMessageFromDb(message);
		}
	}

}
