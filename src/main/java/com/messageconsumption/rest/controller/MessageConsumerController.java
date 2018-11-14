package com.messageconsumption.rest.controller;

import com.messageconsumption.Constants;
import com.messageconsumption.db.model.MessageConsumer;
import com.messageconsumption.rest.request.MessageConsumerUserDTO;
import com.messageconsumption.rest.response.APIResponse;
import com.messageconsumption.service.MessageConsumerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Seema
 */
@RestController
@RequestMapping(value = Constants.BASE_API_URL)
public class MessageConsumerController {

    private final MessageConsumerService messageConsumerService;

    /**
     *
     * @param messageConsumerService : MessageConsumerService interface
     */
    public MessageConsumerController(MessageConsumerService messageConsumerService) {
        this.messageConsumerService = messageConsumerService;
    }

    /**
     *
     * @param messageConsumerUserDTO : MessageConsumerUserDTO class
     * @return MessageConsumer list
     */
    @PostMapping(value = "/messageConsumersByUserId")
    @ApiOperation(value = "Get All Message Consumers By User Id")
    public APIResponse<List<MessageConsumer>> getAllMessageConsumerByUserId(@Valid @RequestBody MessageConsumerUserDTO messageConsumerUserDTO) {
        return messageConsumerService.getAllMessageConsumerByUserId(messageConsumerUserDTO);
    }

    /**
     *
     * @param messageConsumer : MessageConsumer class
     * @return MessageConsumer object in API response
     */
    @PostMapping(value = "/messageConsumer")
    @ApiOperation(value = "Create Message Consumer")
    public APIResponse<MessageConsumer> createMessageConsumer(@Valid @RequestBody MessageConsumer messageConsumer) {
        return messageConsumerService.createMessageConsumer(messageConsumer);
    }

    /**
     *
     * @return MessageConsumer list
     */
    @GetMapping(value = "/allMessageConsumers")
    @ApiOperation(value = "Get All Message Consumers")
    public APIResponse<List<MessageConsumer>> getAllMessageConsumers(){
        return messageConsumerService.getAllMessageConsumers();
    }

}
