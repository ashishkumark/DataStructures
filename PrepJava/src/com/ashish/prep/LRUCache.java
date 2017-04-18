package com.ashish.prep;

import java.util.HashMap;

class LRUNode {
    int key;
    int value;
    LRUNode pre;
    LRUNode next;
 
    public LRUNode(int key, int value){
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString() {
    	return "[ "+ this.key + "," + this.value + " ]";
    }
}
public class LRUCache {
    int capacity;
    HashMap<Integer, LRUNode> map = new HashMap<Integer, LRUNode>();
    LRUNode head=null;
    LRUNode end=null;
 
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
 
    public int get(int key) {
        if(map.containsKey(key)){
            LRUNode n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
 
        return -1;
    }
 
    public void remove(LRUNode n){
        if(n.pre!=null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
 
        if(n.next!=null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
 
    }
 
    public void setHead(LRUNode n){
        n.next = head;
        n.pre = null;
 
        if(head!=null)
            head.pre = n;
 
        head = n;
 
        if(end ==null)
            end = head;
    }
 
    public void set(int key, int value) {
        if(map.containsKey(key)){
            LRUNode old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            LRUNode created = new LRUNode(key, value);
            if(map.size()>=capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
 
            }else{
                setHead(created);
            }    
 
            map.put(key, created);
        }
    }
    
    @Override
    public String toString() {
    	return map.toString();
    }
    
    public static void main(String args[]) {
    	LRUCache lru = new LRUCache(5);
    	lru.set(1, 1);
    	lru.set(2, 2);
    	lru.set(3, 3);
    	lru.set(4, 4);
    	lru.set(5, 5);
    	System.out.println(lru.toString());
    	lru.set(1, 11);
    	lru.set(8, 8);
    	System.out.println(lru.toString());
    	
    	LRUNode current = lru.head;
    	while(current != null) {
    		System.out.print("{ "+ current.key + "," + current.value + " }, ");
    		current = current.next;
    	}
    }
}