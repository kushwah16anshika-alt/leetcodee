import java.util.*;

class RandomizedSet
{
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random random;

    public RandomizedSet()
    {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val)
    {
        if (map.containsKey(val))
        {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val)
    {
        if (!map.containsKey(val))
        {
            return false;
        }

        int idx = map.get(val);

        int lastelement = list.get(list.size() - 1);

        // Move last element to idx
        list.set(idx, lastelement);

        // Update index of last element
        map.put(lastelement, idx);

        // Remove last element
        list.remove(list.size() - 1);

        // Remove val from map
        map.remove(val);

        return true;
    }

    public int getRandom()
    {
        int randomindx = random.nextInt(list.size());

        return list.get(randomindx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */