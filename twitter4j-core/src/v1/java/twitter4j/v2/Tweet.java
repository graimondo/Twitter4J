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

import twitter4j.TwitterResponse;
import twitter4j.v1.*;

import java.time.LocalDateTime;

/**
 * A data interface representing one Tweet.
 * (e.g. https://developer.twitter.com/en/docs/twitter-api/tweets/lookup/api-reference/get-tweets-id)
 *
 * @author Gaetano Raimond - gaetano.raimondo at gmail.com
 */
@SuppressWarnings("unused")
public interface Tweet extends Comparable<Tweet>, TwitterResponse,
        java.io.Serializable {


    /**
     * Returns the unique identifier of this Tweet
     *
     * @return the id (e.g. 210462857140252672)
     */
    long getId();

    /**
     * Returns the content of the Tweet
     *
     * @return the text (e.g. Along with our new #Twitterbird, we've also updated our Display Guidelines: https://t.co/Ed4omjYs  ^JC)
     */
    String getText();

    /**
     * Returns the list of unique identifiers indicating all versions of an edited Tweet
     *
     * @return array of unique identifiers indicating all versions of an edited Tweet - null if tweets has no edits
     * @since Twitter4j 4.2.0
     */
    String[] getEditHistoryTweetIds();
}
