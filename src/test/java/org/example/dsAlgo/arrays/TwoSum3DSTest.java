package org.example.dsAlgo.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TwoSum3DSTest {
    
    @Test
    void test_functionality() {
        TwoSum3DS x = new TwoSum3DS();
        x.add(1);
        x.add(3);
        x.add(5);

        Assertions.assertThat(x.printList()).isEqualTo("[1, 3, 5]");
        Assertions.assertThat(x.find(4)).isTrue();
        Assertions.assertThat(x.find(7)).isFalse();
    }
}
