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

package twitter4j;

import twitter4j.v1.*;
import twitter4j.v2.Tweet;

import java.time.LocalDateTime;
import java.util.Arrays;

import static twitter4j.ParseUtil.getDate;

/**
 * A data class representing one single status of a user.
 *
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
/*package*/ final class TweetJSONImpl extends TwitterResponseImpl implements Tweet, java.io.Serializable {


    private long id;
    private String text;



    private String[] editHistoryTweetIds;

    /*package*/TweetJSONImpl(HttpResponse res, boolean jsonStoreEnabled) throws TwitterException {
        super(res);
        JSONObject json = res.asJSONObject();
        JSONObject data=json.getJSONObject("data");
        init(data);
        if (jsonStoreEnabled) {
            TwitterObjectFactory.clearThreadLocalMap();
            TwitterObjectFactory.registerJSONObject(this, json);
        }
    }

    /*package*/TweetJSONImpl(JSONObject json, boolean jsonStoreEnabled) throws TwitterException {
        super();
        init(json);
        if (jsonStoreEnabled) {
            TwitterObjectFactory.registerJSONObject(this, json);
        }
    }

    /*package*/ TweetJSONImpl(JSONObject json) throws TwitterException {
        super();
        init(json);
    }

    /* Only for serialization purposes. */
    /*package*/ TweetJSONImpl() {

    }

    private void init(JSONObject json) throws TwitterException {
        id = ParseUtil.getLong("id", json);
        try {

            if (!json.isNull("text")) {
                text = HTMLEntity.unescape(json.getString("text"));
            }
            if (!json.isNull("edit_history_tweet_ids")) {
                JSONArray withheld_in_countries = json.getJSONArray("edit_history_tweet_ids");
                int length = withheld_in_countries.length();
                editHistoryTweetIds = new String[length];
                for (int i = 0; i < length; i++) {
                    editHistoryTweetIds[i] = withheld_in_countries.getString(i);
                }
            }
        } catch (JSONException jsone) {
            throw new TwitterException(jsone);
        }
    }


    @Override
    public int compareTo(Tweet that) {
        long delta = this.id - that.getId();
        if (delta < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (delta > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) delta;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getText() {
        return this.text;
    }
    @Override
    public int hashCode() {
        return (int) id;
    }

    @Override
    public String[] getEditHistoryTweetIds() {
        return editHistoryTweetIds;
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj instanceof Status && ((Status) obj).getId() == this.id;
    }

    @Override
    public String toString() {
        return "TweetJSONImpl{" +
                ", id=" + id +
                ", text='" + text + '\'' +
                ", editHistoryTweetIds=" + Arrays.toString(editHistoryTweetIds) +
                '}';
    }
}
