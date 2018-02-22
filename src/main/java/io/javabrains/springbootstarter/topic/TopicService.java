package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("Spring", "Spring Framework", "Spring Framework Description"),
			new Topic("java", "Core Java", " Core Java description"),
			new Topic("javascript", "javaScript", "JavaScript Description")
				));

	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(a -> a.getId().equals(id)).findAny().get();
	}

	public boolean addTopic(Topic topic) {
		return topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		topics.stream().filter(a -> a.getId().equals(id)).
		findAny().
		ifPresent(a -> { a.setId(topic.getId());
						 a.setName(topic.getName());
						 a.setDescription(topic.getDescription());
						});
	}

	public void deleteTopic(String id) {
		topics.removeIf(a -> a.getId().equals(id));
		
	}
	
	

}
