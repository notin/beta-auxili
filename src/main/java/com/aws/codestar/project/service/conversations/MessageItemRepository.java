package com.aws.codestar.project.service.conversations;

import com.aws.codestar.project.pojos.conversation.MessagesItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MessageItemRepository extends CrudRepository<MessagesItem, String> {
}
