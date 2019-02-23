package com.aws.codestar.project.controller;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.BeforeClass;

/**
 * Tests for {@link ConversationController}. Modify the tests in order to support your use case as you build your project.
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConversationController.class)
public class ConversationControllerTest
{

    @Autowired
    private ConversationController controller;

    @BeforeClass()
    public void setup()
    {
//        controller = new ConversationController();
    }
    /**
     * Initializing variables before we run the tests.
     * Use @BeforeAll for initializing static variables at the start of the test class execution.
     * Use @BeforeEach for initializing variables before each test is run.
     */
    /**
     * Basic test to verify the result obtained when calling post
     */
//    @Test
//    void testPostRequest()
//    {
//        Conversation conversation = Conversation.builder().build();
//        MessagesItem messageItem = MessagesItem.builder().build();
//        String message = "hola";
//        String user = "You";
//
//        messageItem.setMessage(message);
//        messageItem.setUser(user);
//        conversation.getMessageItem().add(messageItem);
//
//        Conversation conversationRetrieved = controller.receive(conversation);
//
//        List<MessagesItem> messageItem1 = conversationRetrieved.getMessageItem();
//        MessagesItem messagesItem = messageItem1.get(0);
//        MessagesItem originalMaessage = conversation.getMessageItem().get(0);
//
//        assertThat(conversationRetrieved.getId()).isEqualToIgnoringCase(conversation.getId());
//        assertThat(messagesItem.getId()).isEqualToIgnoringCase(originalMaessage.getId());
//        assertThat(messagesItem.getMessage()).isEqualToIgnoringCase(originalMaessage.getMessage());
//        assertThat(messagesItem.getUser()).isEqualToIgnoringCase(originalMaessage.getUser());
//    }

}
