package problem535;

public class Codec {

    // Encodes a URL to a shortened URL.
    
    int cnt = 0;
    Map<String, String> map = new HashMap();
    
    public String encode(String longUrl) {
        map.put(Integer.toString(cnt), longUrl);
        return Integer.toString(cnt++);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.getOrDefault(shortUrl, null);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));