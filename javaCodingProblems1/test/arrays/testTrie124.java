package arrays;

import org.junit.Assert;
import org.junit.Test;
import trie.*;

public class testTrie124 {

    @Test
    public void testCreateTrie() {
        String word = "cat";
        var trie = new Trie();
        trie.insert(word);
        var contains = trie.contains(word);

        Assert.assertTrue(contains);
    }

}
