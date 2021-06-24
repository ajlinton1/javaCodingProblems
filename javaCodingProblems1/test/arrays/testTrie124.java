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

    @Test
    public void testCreateTrie1() {
        String word = "cat";
        var trie = new Trie();
        trie.insert(word);
        var contains = trie.contains(word);
        Assert.assertTrue(contains);

        var word1 = "catter";
        trie.insert(word1);
        Assert.assertTrue(trie.contains(word1));

        trie.delete(word);
        Assert.assertFalse(trie.contains(word));
        Assert.assertTrue(trie.contains(word1));
    }

}
