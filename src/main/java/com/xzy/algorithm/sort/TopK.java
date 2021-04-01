package com.xzy.algorithm.sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

/**
 * @author xiazhengyue
 * @since 2021-03-31
 */
public class TopK {
    private Map<String, Long> map;

    private List<String> list = new ArrayList<>();

    private PriorityQueue<Map.Entry<String, Long>> queue;

    TopK(List<String> values) {
        map = values.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        queue = new PriorityQueue<Map.Entry<String, Long>>(new Comparator<Map.Entry<String, Long>>() {
            @Override
            public int compare(Map.Entry<String, Long> v1, Map.Entry<String, Long> v2) {
                int result = v1.getKey().compareTo(v2.getKey());
                int result2 = v1.getValue().intValue() - v2.getValue().intValue();
                return v1.getValue().equals(v2.getValue()) ? result : result2;
            }
        });
        Set<Map.Entry<String, Long>> entries = map.entrySet();
        entries.forEach(record -> {
            queue.add(record);
        });
    }

    String getK(int k) {
        if (queue.isEmpty() || k < 0) {
            return null;
        }
        Iterator<Map.Entry<String, Long>> iterator = this.queue.iterator();
        Map.Entry<String, Long> next = null;
        while (k >= 0) {
            next = iterator.next();
        }
        return next.getKey();
    }

    public static void main(String[] args) {
    }
}
