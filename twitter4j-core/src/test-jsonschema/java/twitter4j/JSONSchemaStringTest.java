package twitter4j;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JSONSchemaStringTest {
    @Test
    void string() {
        var extract = JSONSchema.extract("#/", """
                {
                  "TweetID" : {
                         "type" : "string",
                         "description" : "Unique identifier of this Tweet. This is returned as a string in order to avoid complications with languages and tools that cannot handle large integers.",
                         "pattern" : "^[0-9]{1,19}$",
                         "example" : "120897978112909812"
                       }
                 
                }""");
        assertEquals(1, extract.size());
        JSONSchema tweetId = extract.get("TweetID");
        assertEquals("@Nullable\nprivate final String tweetID;",
                tweetId.asFieldDeclaration(false));
        assertEquals("@NotNull\nprivate final String tweetID;",
                tweetId.asFieldDeclaration(true));
        assertEquals("""
                        this.tweetID = json.has("TweetID") ? json.getString("TweetID") : null;
                        """,
                tweetId.asConstructorAssignment(false));
        assertEquals("""
                        this.tweetID = json.getString("TweetID");
                        """,
                tweetId.asConstructorAssignment(true));
        assertEquals("""
                        @Nullable
                        @Override
                        public String getTweetID() {
                            return tweetID;
                        }
                        """,
                tweetId.asGetterImplementation(false));

        assertThrows(UnsupportedOperationException.class, () -> tweetId.asJavaImpl("twitter4j", "twitter4j.v2"));
        assertThrows(UnsupportedOperationException.class, () -> tweetId.asInterface("twitter4j.v2"));
    }

    @Test
    void datetime() {
        var extract = JSONSchema.extract("#/", """
                {
                  "end_datetime" : {
                    "type" : "string",
                    "format" : "date-time"
                  }
                }""");
        assertEquals(1, extract.size());
        JSONSchema tweetId = extract.get("end_datetime");
        assertEquals("@Nullable\nprivate final LocalDateTime endDatetime;",
                tweetId.asFieldDeclaration(false));
        assertEquals("@NotNull\nprivate final LocalDateTime endDatetime;",
                tweetId.asFieldDeclaration(true));
        assertEquals("""
                        this.endDatetime = json.has("end_datetime") ? json.getLocalDateTime("end_datetime") : null;
                        """,
                tweetId.asConstructorAssignment(false));
        assertEquals("""
                        this.endDatetime = json.getLocalDateTime("end_datetime");
                        """,
                tweetId.asConstructorAssignment(true));
        assertEquals("""
                        @Nullable
                        @Override
                        public LocalDateTime getEndDatetime() {
                            return endDatetime;
                        }
                        """,
                tweetId.asGetterImplementation(false));

        assertThrows(UnsupportedOperationException.class, () -> tweetId.asJavaImpl("twitter4j", "twitter4j.v2"));
        assertThrows(UnsupportedOperationException.class, () -> tweetId.asInterface("twitter4j.v2"));
    }

}
