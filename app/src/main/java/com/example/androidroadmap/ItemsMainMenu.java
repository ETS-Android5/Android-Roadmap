package com.example.androidroadmap;

public class ItemsMainMenu {

    private String topic;
    private int imagePath;
    private String description;
    private boolean isExpanded;
    public ItemsMainMenu(String topic, int imagePath, String description) {
        this.topic = topic;
        this.imagePath = imagePath;
        this.description = description;
        isExpanded = false;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ItemsMainMenu{" +
                "topic='" + topic + '\'' +
                ", imagePath=" + imagePath +
                ", description='" + description + '\'' +
                '}';
    }
}
