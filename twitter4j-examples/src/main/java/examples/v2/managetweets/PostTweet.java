/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package examples.v2.managetweets;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.v1.Status;
import twitter4j.v2.Tweet;

import java.util.HashMap;
import java.util.Map;

/**
 * Example application that uses OAuth method to acquire access to your account.<br>
 * This application illustrates how to use OAuth method with Twitter4J for posting tweet using api v2.<br>
 *
 * @author Gaetano Raimondo - gaetano.raimondo at gmail.com
 */
public final class PostTweet {
    /**
     * Usage: java twitter4j.examples.v2.managetweets.PostTweet [text]
     *
     * @param args message
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java twitter4j.examples.v2.managetweets.PostTweet [text]");
            System.exit(-1);
        }
        try {
            Tweet status = Twitter.getInstance().v2().manageTweets().postTweet(args[0]);
            System.out.println("Successfully created tweet with text [" + status.getText() + "] and id ["+status.getId()+"].");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to create tweet: " + te.getMessage());
            System.exit(-1);
        }
    }
}
