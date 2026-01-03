package com.raph;

import java.util.List;

import com.raph.api.YouTubeApiClient;
import com.raph.extract.ContactExtractor;
import com.raph.model.ChannelInfo;
import com.raph.scrape.ChannelScraper;

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


// <?xml version="1.0" encoding="UTF-8"?>
// <project xmlns="http://maven.apache.org/POM/4.0.0"
//          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//          xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
//     <modelVersion>4.0.0</modelVersion>

//     <groupId>com.raph</groupId>
//     <artifactId>ytscrapper</artifactId>
//     <version>1.0-SNAPSHOT</version>

//     <properties>
//         <maven.compiler.source>17</maven.compiler.source>
//         <maven.compiler.target>17</maven.compiler.target>
//     </properties>


//     <dependencies>

//     <!-- Playwright -->
//     <dependency>
//         <groupId>com.microsoft.playwright</groupId>
//         <artifactId>playwright</artifactId>
//         <version>1.43.0</version>
//     </dependency>

//     <!-- JSON parsing -->
//     <dependency>
//         <groupId>com.fasterxml.jackson.core</groupId>
//         <artifactId>jackson-databind</artifactId>
//         <version>2.17.1</version>
//     </dependency>

// </dependencies>


// <build>
//     <plugins>
//         <plugin>
//             <groupId>org.codehaus.mojo</groupId>
//             <artifactId>exec-maven-plugin</artifactId>
//             <version>3.1.0</version>
//             <configuration>
//                 <mainClass>com.raph.Main</mainClass>
//             </configuration>
//         </plugin>

//         <plugin>
//             <groupId>com.microsoft.playwright</groupId>
//             <artifactId>playwright-maven-plugin</artifactId>
//             <version>1.43.0</version>
//             <executions>
//                 <execution>
//                     <id>install-browsers</id>
//                     <goals>
//                         <goal>install</goal>
//                     </goals>
//                 </execution>
//             </executions>
//         </plugin>

//     </plugins>

    
// </build>





// </project>