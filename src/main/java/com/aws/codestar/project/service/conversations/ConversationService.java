package com.aws.codestar.project.service.conversations;

import com.aws.codestar.project.pojos.conversation.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConversationService {

    @Autowired
    ConversationRepository conversationRepository;

    @Autowired
    MessageItemRepository messageItemRepository;

    public void saveConversation( Conversation conversation)
    {
        messageItemRepository.saveAll(conversation.getMessageItem());
        conversationRepository.save(conversation);
    }

    public Conversation findConversationByID(String id)
    {
        Optional<Conversation> byId = conversationRepository.findById(id);
        return byId.get();
    }
}
