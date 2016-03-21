package staxRSS;

import staxRSS.Feed;
import staxRSS.FeedMessage;
import staxRSS.RSSFeedParser;

public class staxTest {
  public static void main(String[] args) {
    RSSFeedParser parser = new RSSFeedParser("https://mah.se/Nyheter/RSS/Kalender-fran-Malmo-hogskola/");
    Feed feed = parser.readFeed();
    System.out.println(feed);
    for (FeedMessage message : feed.getMessages()) {
      System.out.println(message);

    }

  }
} 
