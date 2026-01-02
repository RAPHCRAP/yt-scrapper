package com.raph.scrape;

import com.raph.model.ChannelInfo;

public class ChannelScraper {

    public String fetchAboutPageHtml(ChannelInfo channel) {

        System.out.println("[SCRAPER] Fetching About page: " + channel.getAboutUrl());

        // Fake HTML for now
        return """
            <html>
              <body>
                Contact us at test@gamingone.com
                <a href="https://instagram.com/gamingone">Instagram</a>
              </body>
            </html>
        """;
    }
}
