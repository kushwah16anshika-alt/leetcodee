class LRUCache 
{
    LinkedList<Integer> dll;
    HashMap<Integer, Integer> cache;
    int capacity;
    public LRUCache(int capacity) 
    {
        this.capacity=capacity;
        cache=new HashMap<>();
        dll=new LinkedList<>();
    }
    public void makeMRU(int key)
    {
        dll.remove(Integer.valueOf(key));
        dll.addFirst(key);
    }
    public int get(int key) 
    {
        if(!cache.containsKey(key))
        {
            return -1;
        }
        makeMRU(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) 
    {
        if (cache.containsKey(key))
        {
            cache.put(key,value);
            makeMRU(key);
        }else
        {
            if(dll.size()==capacity)
            {
                int lru=dll.removeLast();
                cache.remove(lru);
            }
            dll.addFirst(key);
            cache.put(key,value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */