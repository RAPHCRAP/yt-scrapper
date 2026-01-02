package com.raph;

import com.raph.api.YouTubeApiClient;
import com.raph.extract.ContactExtractor;
import com.raph.model.ChannelInfo;
import com.raph.scrape.ChannelScraper;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== YT Scraper workflow starting ===");

        // 1️⃣ Discover channels (STUB)
        YouTubeApiClient apiClient = new YouTubeApiClient();
        List<ChannelInfo> channels = apiClient.searchChannels("gaming");

        System.out.println("Found " + channels.size() + " channels");

        // 2️⃣ Scrape each channel
        ChannelScraper scraper = new ChannelScraper();
        ContactExtractor extractor = new ContactExtractor();

        for (ChannelInfo channel : channels) {

            System.out.println("\nProcessing channel: " + channel);

            // 3️⃣ Fetch rendered About page (STUB)
            String html = scraper.fetchAboutPageHtml(channel);

            // 4️⃣ Extract emails & socials (STUB)
            extractor.extractContacts(channel, html);
        }

        System.out.println("\n=== Workflow complete ===");
    }
}
