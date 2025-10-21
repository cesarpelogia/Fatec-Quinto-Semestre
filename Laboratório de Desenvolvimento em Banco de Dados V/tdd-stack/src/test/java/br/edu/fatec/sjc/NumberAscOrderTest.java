package br.edu.fatec.sjc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class NumberAscOrderTest {

    @Mock
    CalculableStrategy<Integer> calculableStrategy;

    private CustomStack<Integer> stack6positions;
    private CustomStack<Integer> emptyStack;

    @BeforeEach
    public void setup() {
        stack6positions = new CustomStack<>(6, calculableStrategy);
        emptyStack = new CustomStack<>(6, calculableStrategy);
    }

    @Test
    public void sortSixNumbers_SortedList() throws Exception {

        Mockito.when(calculableStrategy.calculateValue(Mockito.anyInt()))
                .thenAnswer(invocation -> invocation.getArgument(0));

        stack6positions.push(45);
        stack6positions.push(2);
        stack6positions.push(30);
        stack6positions.push(10);
        stack6positions.push(6);
        stack6positions.push(18);

        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(stack6positions);

        List<Integer> sorted = sorter.sort();

        assertEquals(6, sorted.size());
        assertEquals(List.of(2,6,10,18,30,45), sorted);
    }

    @Test
    public void sortEmptyStack_EmptyList() throws Exception {
        NumberAscOrder<Integer> sorter = new NumberAscOrder<>(emptyStack);
        List<Integer> sorted = sorter.sort();
        assertNotNull(sorted);
        assertTrue(sorted.isEmpty());
    }
}
