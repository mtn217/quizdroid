package edu.washington.mtn217.quizdroid;

import java.util.List;

/**
 * Created by Michael on 2/12/2017.
 */

public interface TopicRepository {
    public List<Topic> getAllTopics();

    public List<String> getTopicNames();

    public void addTopic(Topic newTop);

    public void addAlltopics(List<Topic> topicList);

    public void removeTopic(Topic topicToRemove);
}