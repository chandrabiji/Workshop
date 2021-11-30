package com.hexaware.MLP323.integration.test;

import java.net.URI;
import java.net.URISyntaxException;

public class CommonUtil {
    /**
     * takes host
     */
    public static final String host;
    /**
     * takes port
     */
    public static final String port;
    /**
     * takes url
     */
    public static final String webapp;
    /**
     * takes uri prefix
     */
    public static final String uri_prefix;
    /**
     * satic method
     */
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "18080");
        webapp = System.getProperty("service.webapp", "MLP323");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    /**
     *
     * @param path takes api path
     * @return created path
     * @throws URISyntaxException
     */
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

