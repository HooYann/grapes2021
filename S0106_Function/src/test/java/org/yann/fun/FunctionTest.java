package org.yann.fun;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class FunctionTest {

    @Nested
    @DisplayName("Function")
    class FunctionFamily{
        @Test
        void function0() {
            //apply
            Function<Integer, String> fun = x -> "\"" + x + "\"";
            System.out.println(fun.apply(0));

            //compose
            Function<Integer, Integer> before = x -> x*x;
            System.out.println(before.apply(3));
            System.out.println(fun.compose(before).apply(3));

            //Function<Integer, String> composeFun = fun.compose(before);
            //System.out.println(composeFun);

            //andThen
            Function<String, String> after = x -> x + " end.";
            System.out.println(fun.andThen(after).apply(3));

            //all
            System.out.println(fun.compose(before).andThen(after).apply(3));
        }

        @Test
        void biFunction0() {
            BiFunction<Integer, Integer, String> biFun = (x, y) -> Integer.toString(x+y);
            System.out.println(biFun.apply(1, 2));

            //andThen
            Function<String, String> after = x -> x + " end.";
            System.out.println(biFun.andThen(after).apply(1, 2));
        }

    }

    @Nested
    @DisplayName("Supplier")
    class SupplierFamily {
        @Test
        void supplier0() {
            Supplier<String> supplier = String::new;
            System.out.println(supplier.get().length());

            Integer i = new Integer(1);
            Supplier<String> supplier1 = i::toString;
            System.out.println(supplier1.get());
        }

    }

    @Nested
    @DisplayName("Consumer")
    class ConsumerFamily {
        @Test
        void consumer0() {
            Consumer<Integer> consumer = x -> {x = x+1;System.out.println(x);};
            consumer.accept(11);

            List<Integer> list = new ArrayList<>();
            Consumer<Integer> consumer2 = x -> list.add(x);
            consumer2.accept(1);
            consumer2.accept(2);
            consumer2.accept(3);
            System.out.println(list);
            list.forEach(/**This is consumer**/x -> { System.out.println(x); });

            Consumer<Integer> after = x -> {x = x-1;System.out.println(x);};
            consumer.andThen(after).accept(11);
        }
    }


    @Nested
    @DisplayName("Predicate")
    class PredicateFamily {
        @Test
        void predicate0() {
            Predicate<Integer> predicate = x -> x%2 == 0;
            System.out.println(predicate.test(1));

            //negate
            System.out.println(predicate.negate().test(1));

            //and
            Predicate<Integer> predicate1 = x -> x > 0;
            System.out.println(predicate.and(predicate1).test(2));
            System.out.println(predicate.and(predicate1).negate().test(2));

            //or
            System.out.println(predicate.or(predicate1).test(-2));
            System.out.println();

            Integer i0 = new Integer(1);
            Integer i1 = new Integer(1);
            System.out.println(i0==i1);
            System.out.println(Predicate.isEqual(i0).test(i1));
        }

        @Test
        void biPredict0() {
            BiPredicate<Integer, Integer> biPredicate = (x, y) -> x > 2*y;
            System.out.println(biPredicate.test(5, 3));

            BiPredicate<Integer, String> biPredicate1 = (x, y) -> x == Integer.parseInt(y);
            System.out.println(biPredicate1.test(1, "1"));
        }
    }

    @Nested
    @DisplayName("Comparator")
    class ComparatorFamily {
        @Test
        void comparator0() {
            Comparator<Integer> comparator = (x, y) -> x - y;
            System.out.println(comparator.compare(1, 2));

            //thenComparing
            //在之前比较的结果排序的基础上，然后再按照xx比较。
        }
    }

    @Nested
    @DisplayName("Stream")
    class InStreamOperate {
        List<Integer> getList() {
            List<Integer> list =  Arrays.asList(0, 1, 2, 3, 4);
            System.out.println("Origin List：" + list);
            System.out.println();
            return list;
        }

        @Test
        @DisplayName("过滤")
        void filter() {
            List<Integer> list = getList();
            List<Integer> afterFilter = list.stream().filter(e -> e > 0).collect(Collectors.toList());
            System.out.println(afterFilter);
        }

        @Test
        @DisplayName("映射")
        void map() {
            List<Integer> list = getList();
            List<String> afterMap = list.stream().map(e -> Integer.toString(e)).collect(Collectors.toList());
            System.out.println(afterMap);

        }

        @Test
        @DisplayName("扁平化映射")
        void flatMap() {
            List<Integer> list0 = getList();
            List<Integer> list1 = getList();
            List<List<Integer>> list = Arrays.asList(list0, list1);

            List newList = list.stream().map(e -> e).collect(Collectors.toList());
            System.out.println(newList);

            List<Integer> newList2 = list.stream().flatMap(e -> e.stream()).map(e -> e).collect(Collectors.toList());
            System.out.println(newList2);

        }

        @Test
        @DisplayName("扁平化映射为int,count")
        void flatMapToInt() {
            List<Integer> list = getList();
            long count = list.stream().flatMapToInt(e -> IntStream.of(e)).count();
            System.out.println(count);
        }

        @Test
        @DisplayName("去重")
        void distinct() {
            //distinct
            List<Integer> list0 = getList();
            List<Integer> list1 = getList();
            List<Integer> list = new ArrayList<>();
            list.addAll(list0);
            list.addAll(list1);
            System.out.println(list);
            List<Integer> newList = list0.stream().distinct().collect(Collectors.toList());
            System.out.println(newList);
        }

        @Test
        @DisplayName("排序")
        void sort() {
            List<Integer> list = Arrays.asList(4, 3, 2, 1, 0);
            System.out.println(list);
            System.out.println();
            List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
            System.out.println(sortedList);
        }

        @Test
        @DisplayName("指定排序")
        void sortedWithComparator() {
            List<Integer> list = getList();
            List<Integer> sortedList = list.stream().sorted((x, y) -> y - x).collect(Collectors.toList());
            System.out.println(sortedList);
        }

        //This method exists mainly to support debugging,
        //where you want to see the elements as they flow past a certain point in a pipeline
        @Test
        void peek() {
            Stream.of("one", "two", "three", "four")
                    .filter(e -> e.length() > 3)
                    .peek(e -> System.out.println("filtered value：" + e))
                    .map(String::toUpperCase)
                    .peek(e -> System.out.println("mapped value：" + e))
                    .collect(Collectors.toList());
            System.out.println();

            List<Integer> list = getList();
            List<Integer> newList = list.stream().peek(e -> e = e * 2).collect(Collectors.toList());
            System.out.println(newList);

        }

        @Test
        void reduce() {
            List<Integer> list = getList();

            Optional<Integer> sumResultOptional = list.parallelStream().reduce((acc, item) -> acc + item);
            Integer sumResult = sumResultOptional.get();
            System.out.println(sumResult);
            System.out.println(sumResultOptional.orElse(0));
            System.out.println();

            int identity = 100;
            list.stream()
                    .reduce(identity, (acc, item) -> {
                        System.out.println(acc + item);
                        return acc + item;
                    });
            System.out.println();
            list.parallelStream()
                    .reduce(identity, (acc, item) -> {
                        System.out.println(acc + item);
                        return acc + item;
                    });

            System.out.println();
            System.out.println();

            String result = list.stream()
                    .reduce(
                            "No",
                            (acc, item) -> {
                                System.out.println("first：" + (acc + item));
                                return acc + item;
                            },
                            (acc, item) -> null
                    );
            System.out.println(result);

            String parallelResult = list.parallelStream()
                    .reduce(
                            "No",
                            (acc, item) -> {
                                return acc + item;
                            },
                            (acc, item) -> {
                                return acc + item;
                            });
            System.out.println(parallelResult);
        }

        @Test
        void skip() {
            List<Integer> list = getList();
            List<Integer> newList = list.stream().skip(1).collect(Collectors.toList());
            System.out.println(newList);

            newList = list.stream().skip(9).collect(Collectors.toList());
            System.out.println(newList);

            newList = list.stream().skip(-1).collect(Collectors.toList());
        }

        @Test
        void limit() {
            List<Integer> list = getList();
            List<Integer> newList = list.stream().limit(1).collect(Collectors.toList());
            System.out.println(newList);
        }

        @Test
        void min() {
            Integer result = getList().stream().min((x, y) -> x - y).get();
            System.out.println(result);
            result = getList().stream().min((x, y) -> y - x).get();
            System.out.println(result);

            result = getList().stream().min(Comparator.comparing(Integer::intValue)).get();
            System.out.println(result);
        }

        @Test
        void anyMatch() {
            System.out.println(getList().stream().anyMatch(e -> e > 0));
        }

        @Test
        void findAny() {
            // one
            getList().stream().findAny().ifPresent(System.out::println);
        }

    }

}