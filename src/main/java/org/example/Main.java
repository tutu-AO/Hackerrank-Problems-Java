package org.example;

import java.util.*;

public class Main {

    /**
     * The process of initiating an action on a server is done through HTTP requests which are
     * messages sent by the client. The two most commonly used HTTP requests are GET and POST.
     * This task involves validating requests and parsing URL parameters as a comma-separated
     * string. Authentication tokens for both GET and POST requests are sent as a URL parameter
     * named "token". For validation of authentication, the tokens must be in a set of valid
     * authentication tokens. In the case of a POST request, a CSRF(cross-site-request forgery)
     * token must also be provided. A POST request is considered valid if its authentication
     * token is valid and its CSRF token is alphanumeric value consisting only of lowercase
     * letters and/or numbers with a minimum length of 8. Once a request is validated, the URL
     * parameters must be parsed as a comma-separated string
     *
     * URL parameters are identified by the portion of the URL that comes after a question mark(?)
     * They consist of key and a value, separated by an equal sign(=).
     * Multiple parameters are separated by an ampersand(&)
     *
     * Implementation a request parser prototype. Given an array of strings, valid_auth_tokens,
     * representing the valid authentication tokens and
     * 2D array of strings, requests, representing the request types and URLs, for each request,
     * return the request status
     * ("VALID" or "INVALID"). if VALID, include a comma-separated string of parameters. i.e.
     * "VALID, <param1_key>,<param1_value>,<param2_key>,<param2_value>"
     *
     * EXAMPLE:
     * input:
     * tokens = ["ah37j2ha483u", "safh34ywb0p5", "ba34wyi8t902"]
     * requests = [
     *                 ["GET", "https://example.com/?token=safh34yw783u&name=alex"],
     *                 ["GET", "https://example.com/?token=ah37j2ha483u&name=sam"],
     *                 ["POST", "https://example.com/?token=ba34wyi8t902&name=alex"],
     *                 ["POST", "https://example.com/?token=ba34wyi8t902&csrf=ak2sh32y&name=chris"]
     *            ]
     * output:
     * ["INVALID", "VALID,name,sam", "INVALID", "VALID,name,chris"]
     **/
    public static String[] parse_request(String[] tokens, String[][] requests){
        String[] res = new String[requests.length];
        int i = 0;
        Set<String> distinctToken = new HashSet<>(Arrays.asList(tokens));

        for(String[] request: requests){
            String requestType = request[0];
            String reqString = request[1];
            String[] parameters = reqString.split("\\?")[1].split("&");

            Map<String, String> paramMap = new HashMap<>();
            for(String param : parameters){
                String[] keyValue = param.split("=");
                paramMap.put(keyValue[0], keyValue[1]);
            }

            String token = paramMap.get("token");
            if(distinctToken.contains(token)){
                if(requestType.equals("GET")){
                    String validReq = "VALID," + "name," + paramMap.get("name");
                    res[i] = validReq;
                    i += 1;
                }

                if(requestType.equals("POST")){
                    String csrfToken = paramMap.get("csrf");
                    if(csrfToken != null && csrfToken.matches("[a-z0-9]{8,}")){
                        String validReq = "VALID,"+"name,"+paramMap.get("name");
                        res[i] = validReq;
                        i += 1;
                    }else{
                        res[i] = "INVALID";
                        i += 1;
                    }
                }
            }else{
                res[i] = "INVALID";
                i += 1;
            }
        }
        return res;
    }

    /**
     * A Domain Name System(DNS) translates domain names to IP addresses which are then used by browsers
     * to load internet resources. For quicker DNS lookups, browsers often store a number of recent DNS
     * queries in a DNS cache. Retrieving data from the cache is often faster than retrieving it from a
     * DNS server. This task aims to simulate DNS resolution and determine the time taken to process different
     * URLs.
     *
     * Assume that the DNS cache can store a maximum of the cache_size most recent DNS requests
     * i.e. URL-IP mappings, cache is initially empty. It takes cache_time units to fetch data from the
     * DNS cache, and server_time units of time to fetch data from the DNS server.
     *
     * Given a list of n URLs visited as an array of strings, urls, determine the minimum time taken to resolve
     * each DNS request
     *
     * Note: New DNS requests are dynamically added to the cache, and the cache stores mappings according to the
     * order in which the request were made
     *
     *
     * Example:
     * Suppose cache_size=3, cache_time=2, server_time=5, urls=[
     *                                                          "http://www.hackerrank.com",
     *                                                          "http://www.goggle.com",
     *                                                          "http://www.yahoo.com",
     *                                                          "http://www.gmail.com",
     *                                                          "http://www.yahoo.com",
     *                                                          "http://www.hackerrank.com",
     *                                                          "http://www.gmail.com"
     *                                                          ]
     *
     * output: [5, 5, 5, 5, 2, 5, 2]*/
    public static Integer[] dns_request(int cache_size, int cache_time, int server_time, String[] urls){
        Integer[] requestTime = new Integer[urls.length];

        HashMap<Integer, String> curCache = new HashMap<>();
        int i = 0;
        int j = 0;

        for(String url : urls){
            if(curCache.size() < cache_size){
                curCache.put(j, url);
                j += 1;
            }
            else{
                Integer oldestKey = 0;
                int minKey = Integer.MAX_VALUE;
                for (Map.Entry<Integer, String> entry : curCache.entrySet()) {
                    if(curCache.get(entry.getKey()) == url){
                        requestTime[i] = cache_time;
                        if(i == urls.length - 1){
                            break;
                        }
                        i += 1;
                    }else{
                        requestTime[i] = server_time;
                        if(i < urls.length - 1){
                            i += 1;
                        }
                    }

                    if(oldestKey < minKey && curCache.get(entry.getKey()).equals(url)){
                        oldestKey = entry.getKey();
                        minKey = entry.getKey();
                    }
                }

                if (oldestKey != null) {
                    curCache.remove(oldestKey);
                    curCache.put(j, url);
                    j += 1;
                }
            }
        }

        return requestTime;
    }

    public static void main(String[] args) {

        /**
            Arrays.toString(arrayName) - for printing 1D arrays
            Arrays.deepToString(arrayName) - for printing 2D arrays
         */

        /*########################################################################################################################################*/

        String[] tokens = {"ah37j2ha483u", "safh34ywb0p5", "ba34wyi8t902", "ba34wyi8t902"};
        String[][] requests = {
                {"GET", "https://example.com/?token=safh34yw783u&name=alex"},
                {"GET", "https://example.com/?token=ah37j2ha483u&name=sam"},
                {"POST", "https://example.com/?token=ba34wyi8t902&name=alex"},
                {"POST", "https://example.com/?token=ba34wyi8t902&csrf=ak2sh32y&name=chris"}
        };
        String[] stringArray = parse_request(tokens, requests);
        System.out.println(Arrays.toString(stringArray));

        /*########################################################################################################################################*/
        int cache_size = 3;
        int cache_time = 2;
        int server_time = 5;
        String[] urls = {"http://www.hackerrank.com", "http://www.hackerrank.com", "http://www.gmail.com", "http://www.yahoo.com","http://www.hackerrank.com",
                "http://www.gmail.com"};

        Integer[] output = dns_request(cache_size, cache_time, server_time, urls);

        System.out.println(Arrays.toString(output));
        /*########################################################################################################################################*/
    }
}

