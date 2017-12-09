package com.shishank.android;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * @author shishank
 */

public class APIAvailabilityTest {

    @Test
    public void testAvailability() throws Exception {
        URLConnection connection = new URL("https://api.themoviedb.org/3/discover/movie?api_key=0c594548fb5cfb6bc6f353b5b10b9fc4").openConnection();
        InputStream inputStream = connection.getInputStream();

        StringBuffer buffer = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                buffer.append(line);
            }
        }
        assert buffer.length() > 0;
    }
}
