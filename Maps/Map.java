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
        MapNode<K,V> newElementNode = new MapNode<>(key, value);
        newElementNode = head;
        buckets.set(BucketIndex, newElementNode);
    }
    
    public V getValue(K key){
        int BucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(BucketIndex);
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }
        return null;
    }
    
    public V removeKey(K key){
        int BucketIndex = getBucketIndex(key);
        MapNode<K,V> head = buckets.get(BucketIndex);
        MapNode<K,V> prev = null;
        while(head != null){
            if(head.key.equals(key)){
                if(prev == null){
                    buckets.set(BucketIndex,head.next); 
                }else{
                    prev.next = head.next;
                }
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    public int size(){
        return size;
    }
}