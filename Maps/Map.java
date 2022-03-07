package Maps;

import java.util.ArrayList;

public class Map<K,V> {
    ArrayList<MapNode<K,V>> buckets;
    int size;
    int numBuckets;

    public Map(){
        numBuckets = 20;
        buckets = new ArrayList<>();
        for(int i = 0;i < 20; i++){
            buckets.add(null);
        }
    }

    private int getBucketIndex(K key){
        int hashCode = key.hashCode();
        return hashCode%numBuckets;
    }

    public void insert(K key, V value){
        int BucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(BucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = buckets.get(BucketIndex);
        MapNode<K,V> newElementNdoe = new MapNode<>(key, value);
        newElementNdoe = head;
        buckets.set(BucketIndex, newElementNdoe);
    }
}