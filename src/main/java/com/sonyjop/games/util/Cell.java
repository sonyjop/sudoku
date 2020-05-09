package com.sonyjop.games.util;

import java.util.HashSet;
import java.util.Set;

public class Cell {
    
    private int value;

    private Set<Integer> exclusion;

    private Set<Integer> inclusion;

    public Cell(int value) {
      if(value > 0 && value <= 9) {
           this.value = value;
       }
       
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Set<Integer> getExclusion() {
        return exclusion;
    }

    public void addExclusion(Integer item) {
        if(item == 0) return;
        if(this.exclusion == null) this.exclusion = new HashSet<Integer>();
        this.exclusion.add(item);
    }

    public Set<Integer> getInclusion() {
        return inclusion;
    }

    public void addInclusion(Integer item) {
        if(item == 0) return;
        if(this.inclusion == null) this.inclusion = new HashSet<Integer>();
        this.inclusion.add(item);
    }

    
}