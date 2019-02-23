package com.aws.codestar.project.controller;

import com.aws.codestar.project.pojos.conversation.Conversation;
import com.aws.codestar.project.service.conversations.ConversationService;
import com.aws.codestar.project.util.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Basic Spring web service controller that handles all GET requests.
 */
@RestController
@RequestMapping("/conversation")
public class ConversationController
{

    @Autowired
    private ConversationService conversationService;

    @CrossOrigin
    @RequestMapping( method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public Conversation receive(@RequestBody  Conversation conversation)
    {
        Logger.getAnonymousLogger().info(conversation.toString());
        conversationService.saveConversation(conversation);
        return conversation;
    }

    @CrossOrigin
    @RequestMapping( method = RequestMethod.GET, produces = "application/json")
    public Conversation send(@RequestParam String id)
    {
        Conversation conversation = null;
        if(id !=null & !id.equalsIgnoreCase("") & !id.equalsIgnoreCase("null"))
        {
            conversation = conversationService.findConversationByID(id);
            return conversation;
        }
        else
        {
           conversation = Conversation.builder().build();
            //noinspection SimplifyStreamApiCallChains
            conversation.getMessageItem().stream().forEachOrdered(x->x.setTimestamps(Helper.getCurrentLocalDateTimeStamp()));
        }
        Logger.getAnonymousLogger().info(conversation.toString());
        return conversation;
    }
}
