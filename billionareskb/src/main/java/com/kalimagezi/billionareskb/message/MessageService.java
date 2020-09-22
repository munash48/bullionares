package com.kalimagezi.billionareskb.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.message.Message;
import com.kalimagezi.billionareskb.message.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;

	public void addMessage(Message message) {

		messageRepository.save(message);
	}

	public Optional<Message> getMessage(int id) {

		return messageRepository.findById(id);

	}

	public List<Message> getAllMessages() {

		List<Message> messages = new ArrayList<>();
		messageRepository.findAll().forEach(messages::add);
		return messages;

	}

	public void updateMessage(Message message) {

		messageRepository.save(message);
	}

	public void deleteMessage(int id) {
		messageRepository.deleteById(id);

	}
	public List<Message> getAllMessagesByUid(int uid) {
		// TODO Auto-generated method stub
		return messageRepository.findAllByUid(uid);
	}

	public List<Message> getMessageByCatid(int catid) {
		// TODO Auto-generated method stub
		return messageRepository.findTop10ByChatid(catid);
	}

	public List<Message> getMessageWuid(int id) {
		// TODO Auto-generated method stub
		return messageRepository.findTop5ByWuid(id);
	}


}
