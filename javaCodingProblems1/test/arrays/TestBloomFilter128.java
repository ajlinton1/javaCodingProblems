package arrays;

import org.junit.Assert;
import org.junit.Test;

public class TestBloomFilter128 {

    @Test
    public void testBloomFilter() {
        var bloomFilter = new BloomFilter<String>();
        var word = "test";
        bloomFilter.add(word);
        var result = bloomFilter.contains(word);
        Assert.assertTrue(result);
    }
}
