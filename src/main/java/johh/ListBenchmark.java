package johh;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class ListBenchmark
{
    @Benchmark
    public void testArrayList(ArrayState state) {
        state.list.add(state.size / 2, state.size);
        state.size++;
    }

    @Benchmark
    public void testLinkedList(LinkedState state) {
        state.list.add(state.size / 2, state.size);
        state.size++;
    }

    @State(Scope.Thread)
    public static class ArrayState
    {
        int size = 0;
        List<Integer> list = new ArrayList<>();
    }

    @State(Scope.Thread)
    public static class LinkedState
    {
        int size = 0;
        List<Integer> list = new LinkedList<>();
    }
}
