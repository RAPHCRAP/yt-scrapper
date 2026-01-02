package com.raph.model;

public class ChannelInfo {
    private String channelId;
    private String name;
    private String aboutUrl;

    public ChannelInfo(String channelId, String name, String aboutUrl) {
        this.channelId = channelId;
        this.name = name;
        this.aboutUrl = aboutUrl;
    }

    public String getChannelId() { return channelId; }
    public String getName() { return name; }
    public String getAboutUrl() { return aboutUrl; }

    @Override
    public String toString() {
        return name + " (" + channelId + ")";
    }
}
