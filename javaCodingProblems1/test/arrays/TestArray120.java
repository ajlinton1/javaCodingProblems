package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TestArray120 {
    
    @Test
    public void testFilterByList() {
        Collection<Melon> melons = new ArrayList<>();
        melons.add(new Melon(20));
        melons.add(new Melon(30));
        melons.add(new Melon(40));
        melons.add(new Melon(50));

        List<Integer> desired = new ArrayList<>();
        desired.add(30);
        desired.add(40);
        
        Collection<Melon> filtered = new ArrayList<>();
        for (var melon: melons) {
            boolean match = false;
            for (var d: desired) {
                if (melon.getWeight()==d) {
                    match=true;
                    break;
                }
            }
            if (match) {
                filtered.add(melon);
            }
        }

        Assert.assertEquals(2, filtered.size());
    }

    @Test
    public void testFilterByList1() {
        Collection<Melon> melons = new ArrayList<>();
        melons.add(new Melon(20));
        melons.add(new Melon(30));
        melons.add(new Melon(40));
        melons.add(new Melon(50));

        List<Integer> desired = new ArrayList<>();
        desired.add(30);
        desired.add(40);

        var filtered = melons.stream().filter((m)->{
            return desired.contains(m.getWeight());
        }).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        Assert.assertEquals(2, filtered.size());
    }
}
