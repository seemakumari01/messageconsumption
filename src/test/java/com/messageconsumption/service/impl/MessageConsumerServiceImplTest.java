package com.messageconsumption.service.impl;

import com.messageconsumption.db.model.MessageConsumer;
import com.messageconsumption.db.repositories.MessageConsumerRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class MessageConsumerServiceImplTest {

    private MessageConsumerServiceImpl messageConsumerService;
    private MessageConsumerRepository messageConsumerRepository;

    @Before
    public void setUp() throws Exception {
        messageConsumerRepository = mock(MessageConsumerRepository.class);
        messageConsumerService = spy(new MessageConsumerServiceImpl(messageConsumerRepository));
    }

    @Test
    public void createMessageConsumer() throws Exception {
        MessageConsumer messageConsumer = mock(MessageConsumer.class);
        messageConsumerService.createMessageConsumer(messageConsumer);
        verify(messageConsumerService).createMessageConsumer(messageConsumer);
    }

    @Test
    public void getAllMessageConsumerByUserId() throws Exception {
    }

    @Test
    public void getAllMessageConsumers() throws Exception {
    }

}