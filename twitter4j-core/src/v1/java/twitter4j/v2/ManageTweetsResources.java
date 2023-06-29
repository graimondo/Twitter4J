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

package twitter4j.v2;

import twitter4j.TwitterException;
import twitter4j.v1.*;

/**
 * @author Gaetano Raimondo - gaetano.raimondo at gmail.com
 */
public interface ManageTweetsResources {

    /**
     * Creates a Tweet on behalf of an authenticated user.
     * <br>This method calls https://api.twitter.com/2.0/tweets
     *
     * @param text the text of tweet
     * @return the latest status
     * @throws TwitterException when Twitter service or network is unavailable
     * @see <a href="https://developer.twitter.com/en/docs/twitter-api/tweets/manage-tweets/api-reference/post-tweets">POST /2/tweets | Twitter Developers</a>
     * @since Twitter4J 4.2.0
     */
    Tweet postTweet(String text) throws TwitterException;
}
