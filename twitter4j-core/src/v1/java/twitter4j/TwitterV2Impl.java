package twitter4j;

import twitter4j.v2.ManageTweetsResources;
import twitter4j.v2.TwitterV2;

import java.util.List;
import java.util.function.Consumer;

public class TwitterV2Impl implements TwitterV2 {

    private ManageTweetsResources manageTweetsResources;

    TwitterV2Impl(HttpClient http, ObjectFactory factory, String restBaseURL,
                  Authorization auth, boolean mbeanEnabled,
                  List<Consumer<RateLimitStatusEvent>> rateLimitStatusListeners,
                  List<Consumer<RateLimitStatusEvent>> rateLimitReachedListeners){
        manageTweetsResources=new ManageTweetsResourceImpl(http,factory,restBaseURL,auth,mbeanEnabled,
                rateLimitStatusListeners,rateLimitReachedListeners);

    }
    @Override
    public ManageTweetsResources manageTweets() {
        return manageTweetsResources;
    }
}
