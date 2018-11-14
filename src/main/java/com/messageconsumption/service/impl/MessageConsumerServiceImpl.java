package com.messageconsumption.service.impl;

import com.messageconsumption.db.model.MessageConsumer;
import com.messageconsumption.db.repositories.MessageConsumerRepository;
import com.messageconsumption.db.repositories.impl.BaseRepository;
import com.messageconsumption.rest.request.MessageConsumerUserDTO;
import com.messageconsumption.rest.response.APIResponse;
import com.messageconsumption.service.MessageConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Seema
 */
@Service
public class MessageConsumerServiceImpl extends BaseRepository<MessageConsumer> implements MessageConsumerService {
    private final MessageConsumerRepository messageConsumerRepository;

    @Autowired
    public MessageConsumerServiceImpl(MessageConsumerRepository messageConsumerRepository) {
        this.messageConsumerRepository = messageConsumerRepository;
    }

    @Override
    public APIResponse<MessageConsumer> createMessageConsumer(MessageConsumer messageConsumer) {
        APIResponse<MessageConsumer> apiResponse = new APIResponse<>();
        MessageConsumer dbMessageConsumer = messageConsumerRepository.save(messageConsumer);
        if(Objects.nonNull(dbMessageConsumer)) {
            apiResponse.setCode(HttpStatus.OK.value());
            apiResponse.setDesc(HttpStatus.OK.getReasonPhrase());
            apiResponse.setPayload(dbMessageConsumer);
        } else {
            apiResponse.setCode(HttpStatus.NOT_FOUND.value());
            apiResponse.setDesc(HttpStatus.NOT_FOUND.getReasonPhrase());
            apiResponse.setPayload(null);
        }
        return apiResponse;
    }

    @Override
    public APIResponse<List<MessageConsumer>> getAllMessageConsumerByUserId(MessageConsumerUserDTO messageConsumerUserDTO) {
        APIResponse<List<MessageConsumer>> apiResponse = new APIResponse<>();
        List<MessageConsumer> messageConsumers = findAllBy("userId", messageConsumerUserDTO.getUserId());
        if(Objects.isNull(messageConsumers)) {
            apiResponse.setCode(HttpStatus.NOT_FOUND.value());
            apiResponse.setDesc(HttpStatus.NOT_FOUND.getReasonPhrase());
            apiResponse.setPayload(null);
        } else {
            apiResponse.setCode(HttpStatus.OK.value());
            apiResponse.setDesc(HttpStatus.OK.getReasonPhrase());
            apiResponse.setPayload(messageConsumers);
        }
        return apiResponse;
    }

    @Override
    public APIResponse<List<MessageConsumer>> getAllMessageConsumers() {
        return null;
    }
}
