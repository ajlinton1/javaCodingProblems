package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class testCollections122 {

    @Test
    public void testThreadSafeCollection() {
        Collection<String> collection = new ArrayList<>();
        collection.add("a");
        collection.add("b");
        collection.add("c");

        var collectionSync = Collections.synchronizedCollection(collection);
        Assert.assertNotNull(collectionSync);
        for (var s:collectionSync) {
            Assert.assertNotNull(s);
        }
    }


}
