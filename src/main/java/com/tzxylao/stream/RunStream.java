package com.tzxylao.stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 1. 所有操作是链式调用，一个元素只迭代一次
 * 2. 每一个中间操作返回一个新的流
 * 3. head -> nextStage -> nextStage ->...-> null
 * 4. 有状态操作会把无状态操作截断，单独处理
 * 5. 并行环境下，有状态的中间操作不一定能并行操作
 * 6. prarllel/sequetial这两个操作也是中间操作，但是他们不创建流，只修改并行标志
 * Created by laoliangliang on 18/9/4.
 */
public class RunStream {

    public static void main(String[] args) {
        Random random = new Random();

        Stream<Integer> stream = Stream.generate(() -> random.nextInt())
                .limit(500)
                //第一个无状态操作
                .peek(s -> System.out.println("peek " + s))
                //第二个无状态操作
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s > 1000000;
                });
        //终止操作
        stream.count();
    }
}
