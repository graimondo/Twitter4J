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

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.function.Consumer;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 */
@SuppressWarnings({"UnusedReturnValue", "unused", "unchecked", "rawtypes"})
class Configuration<T2 extends Configuration> {
    List<Consumer<RateLimitStatusEvent>> rateLimitStatusListeners = new ArrayList<>(0);
    List<Consumer<RateLimitStatusEvent>> rateLimitReachedListeners = new ArrayList<>(0);

    String user = null;
    String password = null;

    // HttpConf fields
    String httpProxyHost = null;
    String httpProxyUser = null;
    String httpProxyPassword = null;
    boolean httpProxySocks = false;
    int httpProxyPort = -1;
    int httpConnectionTimeout = 20000;
    int httpReadTimeout = 120000;
    boolean prettyDebug = false;
    boolean gzipEnabled = true;


    private int httpStreamingReadTimeout = 40 * 1000;
    int httpRetryCount = 0;
    int httpRetryIntervalSeconds = 5;

    String oAuthConsumerKey = null;
    String oAuthConsumerSecret = null;
    String oAuthAccessToken = null;
    String oAuthAccessTokenSecret = null;
    String oAuthRealm = null;
    String oAuth2TokenType;
    String oAuth2AccessToken;
    String oAuth2Scope;
    String oAuthRequestTokenURL = "https://api.twitter.com/oauth/request_token";
    String oAuthAuthorizationURL = "https://api.twitter.com/oauth/authorize";
    String oAuthAccessTokenURL = "https://api.twitter.com/oauth/access_token";
    String oAuthAuthenticationURL = "https://api.twitter.com/oauth/authenticate";
    String oAuthInvalidateTokenURL = "https://api.twitter.com/1.1/oauth/invalidate_token";
    String oAuth2TokenURL = "https://api.twitter.com/oauth2/token";
    String oAuth2InvalidateTokenURL = "https://api.twitter.com/oauth2/invalidate_token";

    String restBaseURL = "https://api.twitter.com/1.1/";

    String restV2BaseURL = "https://api.twitter.com/2";
    String streamBaseURL = "https://stream.twitter.com/1.1/";
    String uploadBaseURL = "https://upload.twitter.com/1.1/";

    long contributingTo = -1L;

    boolean includeEntitiesEnabled = true;
    boolean trimUserEnabled = false;
    boolean includeExtAltTextEnabled = true;
    boolean tweetModeExtended = true;
    boolean jsonStoreEnabled = false;

    boolean mbeanEnabled = false;

    boolean stallWarningsEnabled = true;

    boolean applicationOnlyAuthEnabled = false;

    String streamThreadName = "";

    Configuration() {
        PropertyConfiguration.loadDefaultProperties(this);
    }

    Authorization auth;
    HttpClient http;

    ObjectFactory factory;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Configuration<?> that = (Configuration<?>) o;
        return httpProxySocks == that.httpProxySocks && httpProxyPort == that.httpProxyPort && httpConnectionTimeout == that.httpConnectionTimeout && httpReadTimeout == that.httpReadTimeout && prettyDebug == that.prettyDebug && gzipEnabled == that.gzipEnabled && httpStreamingReadTimeout == that.httpStreamingReadTimeout && httpRetryCount == that.httpRetryCount && httpRetryIntervalSeconds == that.httpRetryIntervalSeconds && contributingTo == that.contributingTo && includeEntitiesEnabled == that.includeEntitiesEnabled && trimUserEnabled == that.trimUserEnabled && includeExtAltTextEnabled == that.includeExtAltTextEnabled && tweetModeExtended == that.tweetModeExtended && jsonStoreEnabled == that.jsonStoreEnabled && mbeanEnabled == that.mbeanEnabled && stallWarningsEnabled == that.stallWarningsEnabled && applicationOnlyAuthEnabled == that.applicationOnlyAuthEnabled && Objects.equals(rateLimitStatusListeners, that.rateLimitStatusListeners) && Objects.equals(rateLimitReachedListeners, that.rateLimitReachedListeners) && Objects.equals(user, that.user) && Objects.equals(password, that.password) && Objects.equals(httpProxyHost, that.httpProxyHost) && Objects.equals(httpProxyUser, that.httpProxyUser) && Objects.equals(httpProxyPassword, that.httpProxyPassword) && Objects.equals(oAuthConsumerKey, that.oAuthConsumerKey) && Objects.equals(oAuthConsumerSecret, that.oAuthConsumerSecret) && Objects.equals(oAuthAccessToken, that.oAuthAccessToken) && Objects.equals(oAuthAccessTokenSecret, that.oAuthAccessTokenSecret) && Objects.equals(oAuthRealm, that.oAuthRealm) && Objects.equals(oAuth2TokenType, that.oAuth2TokenType) && Objects.equals(oAuth2AccessToken, that.oAuth2AccessToken) && Objects.equals(oAuth2Scope, that.oAuth2Scope) && Objects.equals(oAuthRequestTokenURL, that.oAuthRequestTokenURL) && Objects.equals(oAuthAuthorizationURL, that.oAuthAuthorizationURL) && Objects.equals(oAuthAccessTokenURL, that.oAuthAccessTokenURL) && Objects.equals(oAuthAuthenticationURL, that.oAuthAuthenticationURL) && Objects.equals(oAuthInvalidateTokenURL, that.oAuthInvalidateTokenURL) && Objects.equals(oAuth2TokenURL, that.oAuth2TokenURL) && Objects.equals(oAuth2InvalidateTokenURL, that.oAuth2InvalidateTokenURL) && Objects.equals(restBaseURL, that.restBaseURL) && Objects.equals(streamBaseURL, that.streamBaseURL) && Objects.equals(uploadBaseURL, that.uploadBaseURL) && Objects.equals(streamThreadName, that.streamThreadName) && Objects.equals(auth, that.auth) && Objects.equals(http, that.http) && Objects.equals(factory, that.factory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rateLimitStatusListeners, rateLimitReachedListeners, user, password, httpProxyHost, httpProxyUser, httpProxyPassword, httpProxySocks, httpProxyPort, httpConnectionTimeout, httpReadTimeout, prettyDebug, gzipEnabled, httpStreamingReadTimeout, httpRetryCount, httpRetryIntervalSeconds, oAuthConsumerKey, oAuthConsumerSecret, oAuthAccessToken, oAuthAccessTokenSecret, oAuthRealm, oAuth2TokenType, oAuth2AccessToken, oAuth2Scope, oAuthRequestTokenURL, oAuthAuthorizationURL, oAuthAccessTokenURL, oAuthAuthenticationURL, oAuthInvalidateTokenURL, oAuth2TokenURL, oAuth2InvalidateTokenURL, restBaseURL, streamBaseURL, uploadBaseURL, contributingTo, includeEntitiesEnabled, trimUserEnabled, includeExtAltTextEnabled, tweetModeExtended, jsonStoreEnabled, mbeanEnabled, stallWarningsEnabled, applicationOnlyAuthEnabled, streamThreadName, auth, http, factory);
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", httpProxyHost='" + httpProxyHost + '\'' +
                ", httpProxyUser='" + httpProxyUser + '\'' +
                ", httpProxyPassword='" + httpProxyPassword + '\'' +
                ", httpProxySocks=" + httpProxySocks +
                ", httpProxyPort=" + httpProxyPort +
                ", httpConnectionTimeout=" + httpConnectionTimeout +
                ", httpReadTimeout=" + httpReadTimeout +
                ", prettyDebug=" + prettyDebug +
                ", gzipEnabled=" + gzipEnabled +
                ", httpStreamingReadTimeout=" + httpStreamingReadTimeout +
                ", httpRetryCount=" + httpRetryCount +
                ", httpRetryIntervalSeconds=" + httpRetryIntervalSeconds +
                ", oAuthConsumerKey='" + oAuthConsumerKey + '\'' +
                ", oAuthConsumerSecret='" + mask(oAuthConsumerSecret) + '\'' +
                ", oAuth2AccessToken='" + mask(oAuth2AccessToken) + '\'' +
                ", oAuthAccessTokenSecret='" + mask(oAuthAccessTokenSecret) + '\'' +
                ", oAuth2TokenType='" + oAuth2TokenType + '\'' +
                ", oAuth2AccessToken='" + mask(oAuth2AccessToken) + '\'' +
                ", oAuth2Scope='" + oAuth2Scope + '\'' +
                ", oAuthRequestTokenURL='" + oAuthRequestTokenURL + '\'' +
                ", oAuthAuthorizationURL='" + oAuthAuthorizationURL + '\'' +
                ", oAuthAccessTokenURL='" + oAuthAccessTokenURL + '\'' +
                ", oAuthAuthenticationURL='" + oAuthAuthenticationURL + '\'' +
                ", oAuthInvalidateTokenURL='" + oAuthInvalidateTokenURL + '\'' +
                ", oAuth2TokenURL='" + oAuth2TokenURL + '\'' +
                ", oAuth2InvalidateTokenURL='" + oAuth2InvalidateTokenURL + '\'' +
                ", restBaseURL='" + restBaseURL + '\'' +
                ", streamBaseURL='" + streamBaseURL + '\'' +
                ", uploadBaseURL='" + uploadBaseURL + '\'' +
                ", contributingTo=" + contributingTo +
                ", includeEntitiesEnabled=" + includeEntitiesEnabled +
                ", trimUserEnabled=" + trimUserEnabled +
                ", includeExtAltTextEnabled=" + includeExtAltTextEnabled +
                ", tweetModeExtended=" + tweetModeExtended +
                ", jsonStoreEnabled=" + jsonStoreEnabled +
                ", mbeanEnabled=" + mbeanEnabled +
                ", stallWarningsEnabled=" + stallWarningsEnabled +
                ", applicationOnlyAuthEnabled=" + applicationOnlyAuthEnabled +
                ", streamThreadName='" + streamThreadName + '\'' +
                '}';
    }

    String mask(@Nullable String strToMask) {
        if (strToMask == null) {
            return "(null)";
        }
        //noinspection SuspiciousRegexArgument
        return strToMask.replaceAll(".", "*");
    }

    /**
     * @param prettyDebugEnabled enabled
     * @return this instance
     */
    public T2 prettyDebugEnabled(boolean prettyDebugEnabled) {
        this.prettyDebug = prettyDebugEnabled;
        return (T2) this;
    }

    /**
     * @param gzipEnabled enabled
     * @return this instance
     */
    public T2 gzipEnabled(boolean gzipEnabled) {
        this.gzipEnabled = gzipEnabled;
        return (T2) this;
    }

    /**
     * @param applicationOnlyAuthEnabled applicationOnlyAuthEnabled
     * @return this instance
     */
    public T2 applicationOnlyAuthEnabled(boolean applicationOnlyAuthEnabled) {
        this.applicationOnlyAuthEnabled = applicationOnlyAuthEnabled;
        return (T2) this;
    }

    /**
     * @param props props
     * @return this instance
     */
    public T2 load(Properties props) {
        PropertyConfiguration.load(this, props);
        return (T2) this;
    }

    /**
     * @param httpProxyHost http proxy host
     * @return this instance
     */
    public T2 httpProxyHost(String httpProxyHost) {
        this.httpProxyHost = httpProxyHost;
        return (T2) this;
    }

    /**
     * @param httpProxyUser http proxy user
     * @return this instance
     */
    public T2 httpProxyUser(String httpProxyUser) {
        this.httpProxyUser = httpProxyUser;
        return (T2) this;
    }

    /**
     * @param httpProxyPassword http proxy password
     * @return this instance
     */
    public T2 httpProxyPassword(String httpProxyPassword) {
        this.httpProxyPassword = httpProxyPassword;
        return (T2) this;
    }

    /**
     * @param httpProxyPort http proxy port
     * @return this instance
     */
    public T2 httpProxyPort(int httpProxyPort) {
        this.httpProxyPort = httpProxyPort;
        return (T2) this;
    }

    /**
     * @param httpProxySocks http proxy socks
     * @return this instance
     */
    public T2 httpProxySocks(boolean httpProxySocks) {
        this.httpProxySocks = httpProxySocks;
        return (T2) this;
    }

    /**
     * @param httpConnectionTimeout http connection timeout in milliseconds
     * @return this instance
     */
    public T2 httpConnectionTimeout(int httpConnectionTimeout) {
        this.httpConnectionTimeout = httpConnectionTimeout;
        return (T2) this;
    }

    /**
     * @param httpReadTimeout http read timeout in milliseconds
     * @return this instance
     */
    public T2 httpReadTimeout(int httpReadTimeout) {
        this.httpReadTimeout = httpReadTimeout;
        return (T2) this;
    }

    /**
     * @param httpStreamingReadTimeout http streaming timeout in milliseconds
     * @return this instance
     */
    public T2 httpStreamingReadTimeout(int httpStreamingReadTimeout) {
        this.httpStreamingReadTimeout = httpStreamingReadTimeout;
        return (T2) this;
    }

    /**
     * @param httpRetryCount http retry count
     * @return this instance
     */
    public T2 httpRetryCount(int httpRetryCount) {
        this.httpRetryCount = httpRetryCount;
        return (T2) this;
    }

    /**
     * @param httpRetryIntervalSeconds http retry interval in seconds
     * @return this instance
     */
    public T2 httpRetryIntervalSeconds(int httpRetryIntervalSeconds) {
        this.httpRetryIntervalSeconds = httpRetryIntervalSeconds;
        return (T2) this;
    }

    /**
     * @param oAuthConsumerKey OAuth consumer key
     * @param oAuthConsumerSecret OAuth consumer secret
     * @return this instance
     */
    public T2 oAuthConsumer(String oAuthConsumerKey, String oAuthConsumerSecret) {
        this.oAuthConsumerKey = oAuthConsumerKey;
        this.oAuthConsumerSecret = oAuthConsumerSecret;
        return (T2) this;
    }

    /**
     * @param oAuthAccessToken OAuth access token
     * @param oAuthAccessTokenSecret OAuth access token secret
     * @return this instance
     */
    public T2 oAuthAccessToken(String oAuthAccessToken, String oAuthAccessTokenSecret) {
        this.oAuthAccessToken = oAuthAccessToken;
        this.oAuthAccessTokenSecret = oAuthAccessTokenSecret;
        return (T2) this;
    }

    /**
     * @param accessToken access token
     * @return this instance
     */
    public T2 oAuthAccessToken(AccessToken accessToken) {
        this.oAuthAccessToken = accessToken.getToken();
        this.oAuthAccessTokenSecret = accessToken.getTokenSecret();
        return (T2) this;
    }

    /**
     * @param oAuth2TokenType OAuth2 token type
     * @param oAuth2AccessToken OAuth2 access token
     * @return this instance
     */
    public T2 oAuth2Token(String oAuth2TokenType, String oAuth2AccessToken) {
        this.oAuth2TokenType = oAuth2TokenType;
        this.oAuth2AccessToken = oAuth2AccessToken;
        return (T2) this;
    }

    /**
     * @param oAuth2Token OAuth2 token
     * @return this instance
     */
    public T2 oAuth2Token(OAuth2Token oAuth2Token) {
        this.oAuth2TokenType = oAuth2Token.getTokenType();
        this.oAuth2AccessToken = oAuth2Token.getAccessToken();
        return (T2) this;
    }

    /**
     * @param oAuth2Scope OAuth2 scope
     * @return this instance
     */
    public T2 oAuth2Scope(String oAuth2Scope) {
        this.oAuth2Scope = oAuth2Scope;
        return (T2) this;
    }

    /**
     * @param contributingTo contributing to user id
     * @return this instance
     */
    public T2 contributingTo(long contributingTo) {
        this.contributingTo = contributingTo;
        return (T2) this;
    }

    /**
     * @param enabled trim user enabled
     * @return this instance
     */
    public T2 trimUserEnabled(boolean enabled) {
        this.trimUserEnabled = enabled;
        return (T2) this;
    }

    /**
     * @param enabled include ext alt text enabled
     * @return this instance
     */
    public T2 includeExtAltTextEnabled(boolean enabled) {
        this.includeExtAltTextEnabled = enabled;
        return (T2) this;
    }

    /**
     * @param enabled tweet mode extended
     * @return this instance
     */
    public T2 tweetModeExtended(boolean enabled) {
        this.tweetModeExtended = enabled;
        return (T2) this;
    }

    /**
     * @param enabled enabled
     * @return this instance
     */
    public T2 includeEntitiesEnabled(boolean enabled) {
        this.includeEntitiesEnabled = enabled;
        return (T2) this;
    }

    /**
     * @param enabled enabled
     * @return this instance
     */
    public T2 jsonStoreEnabled(boolean enabled) {
        this.jsonStoreEnabled = enabled;
        return (T2) this;
    }

    /**
     * @param enabled mbean enabled
     * @return this instance
     */
    public T2 mBeanEnabled(boolean enabled) {
        this.mbeanEnabled = enabled;
        return (T2) this;
    }

    /**
     * Registers a lambda action for account associated rate limits
     *
     * @param action the action to be added
     * @see <a href="https://dev.twitter.com/docs/rate-limiting">Rate Limiting | Twitter Developers</a>
     * @since Twitter4J 4.0.4
     * @return this instance
     */
    public T2 onRateLimitStatus(final Consumer<RateLimitStatusEvent> action) {
        rateLimitStatusListeners.add(action);
        return (T2) this;
    }

    /**
     * Registers a RateLimitStatusListener for account associated rate limits
     *
     * @param action the action to be added
     * @see <a href="https://dev.twitter.com/docs/rate-limiting">Rate Limiting | Twitter Developers</a>
     * @since Twitter4J 4.0.4
     * @return this instance
     */
    public T2 onRateLimitReached(final Consumer<RateLimitStatusEvent> action) {
        rateLimitReachedListeners.add(action);
        return (T2) this;
    }

    T2 buildConfiguration() {
        factory = new JSONImplFactory(this.jsonStoreEnabled);
        http = new HttpClient(httpProxyHost
                , httpProxyPort, httpProxyUser, httpProxyPassword, httpProxySocks, httpRetryCount
                , httpRetryIntervalSeconds, httpConnectionTimeout, httpReadTimeout, prettyDebug
                ,
                gzipEnabled);
        String consumerKey = this.oAuthConsumerKey;
        String consumerSecret = this.oAuthConsumerSecret;

        if (consumerKey != null && consumerSecret != null) {
            if (this.applicationOnlyAuthEnabled) {
                auth = new OAuth2Authorization(this);
            } else {
                auth = new OAuthAuthorization(this);
            }
        }
        if (null == auth) {
            auth = NullAuthorization.getInstance();
        }
        return (T2) this;
    }

    private static final String WWW_DETAILS = "See https://twitter4j.org/en/configuration.html for details. See and register at https://apps.twitter.com/";

    void ensureAuthorizationEnabled() {
        if (!auth.isEnabled()) {
            throw new IllegalStateException(
                    "Authentication credentials are missing. " + WWW_DETAILS);
        }
    }

}
