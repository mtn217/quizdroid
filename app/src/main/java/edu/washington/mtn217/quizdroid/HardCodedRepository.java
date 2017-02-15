package edu.washington.mtn217.quizdroid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 2/12/2017.
 */

public class HardCodedRepository implements TopicRepository {
    private List<Topic> topics;
    private static HardCodedRepository instance;

    public HardCodedRepository() {
        topics = new ArrayList<Topic>();
    }

    public static HardCodedRepository getInstance() {
        if (instance == null) {
            instance = new HardCodedRepository();
        }
        return instance;
    }

    public void addTopic(Topic newTop) {
        topics.add(newTop);
    }

    public void addAllTopics(List<Topic> topicList) {
        for (Topic current : topicList) {
            topics.add(current);
        }
    }

    public List<Topic> getAllTopics() {
        return topics;
    }

    public List<String> getTopicNames() {
        List<String> result = new ArrayList<String>();
        for (Topic current : topics) {
            result.add(current.getTitle());
        }
        return result;
    }

    public void removeTopic(Topic topicToRemove) {
        topics.remove(topicToRemove);
    }
}
