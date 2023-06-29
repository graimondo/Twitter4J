package twitter4j;

import twitter4j.v2.ManageTweetsResources;
import twitter4j.v2.Tweet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ManageTweetsResourceImpl extends APIResourceBase implements ManageTweetsResources {

    ManageTweetsResourceImpl(HttpClient http, ObjectFactory factory, String restBaseURL, Authorization auth, boolean mbeanEnabled, List<Consumer<RateLimitStatusEvent>> rateLimitStatusListeners, List<Consumer<RateLimitStatusEvent>> rateLimitReachedListeners) {
        super(http, factory, restBaseURL, auth, mbeanEnabled, null, "", rateLimitStatusListeners, rateLimitReachedListeners);
    }

    @Override
    public Tweet postTweet(String text) throws TwitterException {
        Map params=new HashMap();
        params.put("text",text);
        JSONObject obj=new JSONObject(params);
        Tweet response= factory.createTweet(post(restBaseURL + "/tweets", new HttpParameter(obj)));
        return response;
    }
}
