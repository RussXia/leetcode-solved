package com.xzy.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import lombok.Data;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * User: RuzzZZ
 * Date: 2022/12/16
 * Time: 15:11
 */
public class OrderingDemo {

    @Data
    static class FeedDo {
        private Integer type;
        private String content;
        private Boolean isDeleted;
        private Long createdAt;
    }

    public static void main(String[] args) {
        Ordering<FeedDo> ordering = new Ordering<>() {
            @Override
            public int compare(@Nullable FeedDo left, @Nullable FeedDo right) {
                if (left == null || right == null) {
                    return left == null ? 1 : -1;
                }
                return ComparisonChain.start().compareFalseFirst(left.getIsDeleted(), right.getIsDeleted())
                        .compare(left.getType(), right.getType())
                        .compare(left.getCreatedAt(), right.getCreatedAt())
                        .result();
            }
        };


        List<FeedDo> feedDoList = Lists.newArrayList();
        {
            FeedDo feedDo = new FeedDo();
            feedDo.setIsDeleted(false);
            feedDo.setContent("ceshi-100001");
            feedDo.setCreatedAt(1671175211744L);
            feedDo.setType(1);
            feedDoList.add(feedDo);
        }
        {
            FeedDo feedDo = new FeedDo();
            feedDo.setIsDeleted(false);
            feedDo.setContent("ceshi-100002");
            feedDo.setCreatedAt(1671175511744L);
            feedDo.setType(1);
            feedDoList.add(feedDo);
        }
        {
            FeedDo feedDo = new FeedDo();
            feedDo.setIsDeleted(true);
            feedDo.setContent("ceshi-100003");
            feedDo.setCreatedAt(1671175213744L);
            feedDo.setType(2);
            feedDoList.add(feedDo);
        }
        {
            FeedDo feedDo = new FeedDo();
            feedDo.setIsDeleted(false);
            feedDo.setContent("ceshi-100004");
            feedDo.setCreatedAt(1671170211744L);
            feedDo.setType(1);
            feedDoList.add(feedDo);
        }
        {
            FeedDo feedDo = new FeedDo();
            feedDo.setIsDeleted(false);
            feedDo.setContent("ceshi-100005");
            feedDo.setCreatedAt(1672175211744L);
            feedDo.setType(3);
            feedDoList.add(feedDo);
        }
        {
            feedDoList.add(null);
        }

        List<FeedDo> sortedFeed = feedDoList.stream().sorted(ordering).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(sortedFeed));
    }
}
