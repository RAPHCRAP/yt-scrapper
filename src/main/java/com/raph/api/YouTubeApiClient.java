package com.raph.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.raph.model.ChannelInfo;
import com.raph.util.Config;

public class YouTubeApiClient {

    private static final String SEARCH_URL =
        "https://www.googleapis.com/youtube/v3/search";

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();

    public List<ChannelInfo> searchChannels(String query) {

        List<ChannelInfo> results = new ArrayList<>();

        try {
            String url = SEARCH_URL +
                "?part=snippet" +
                "&type=channel" +
                "&q=" + query +
                "&maxResults=" + Config.get("youtube.max.results") +
                "&key=" + Config.get("youtube.api.key");

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonNode root = mapper.readTree(response.body());
            JsonNode items = root.get("items");

            for (JsonNode item : items) {
                String channelId =
                    item.get("snippet").get("channelId").asText();

                String title =
                    item.get("snippet").get("channelTitle").asText();

                String aboutUrl =
                    "https://www.youtube.com/channel/" + channelId + "/about";

                results.add(new ChannelInfo(channelId, title, aboutUrl));
            }

        } catch (Exception e) {
            throw new RuntimeException("YT API failure", e);
        }

        return results;
    }
}
