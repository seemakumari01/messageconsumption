package com.messageconsumption.service;

import com.messageconsumption.db.model.MessageConsumer;
import com.messageconsumption.db.repositories.MessageConsumerRepository;
import com.messageconsumption.rest.request.MessageConsumerUserDTO;
import com.messageconsumption.rest.response.APIResponse;

import java.util.List;

/**
 * @author Seema
 */
public interface MessageConsumerService extends Service<MessageConsumer, MessageConsumerRepository> {
    APIResponse<MessageConsumer> createMessageConsumer(final MessageConsumer messageConsumer);

    APIResponse<List<MessageConsumer>> getAllMessageConsumers();

    APIResponse<List<MessageConsumer>> getAllMessageConsumerByUserId(final MessageConsumerUserDTO messageConsumerUserDTO);
}
