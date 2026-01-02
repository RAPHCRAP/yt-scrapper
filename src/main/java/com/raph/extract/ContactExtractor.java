package com.raph.extract;

import com.raph.model.ChannelInfo;

public class ContactExtractor {

    public void extractContacts(ChannelInfo channel, String html) {

        System.out.println("[EXTRACT] Extracting contacts from " + channel.getName());

        // Stub output
        if (html.contains("@")) {
            System.out.println("  Found email: test@gamingone.com");
        }

        if (html.contains("instagram")) {
            System.out.println("  Found Instagram link");
        }
    }
}
