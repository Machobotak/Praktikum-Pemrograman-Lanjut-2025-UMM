package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MainTest {
    @Test
    void skenario1(){
        int hasil = Main.findmin(1,2,3);
        assertEquals(1,hasil,"Min(1,2,3) harus 1");
    }
    @Test
    void skenario2(){
        int hasil = Main.findmin(-1,-2,-3);
        assertEquals(-3,hasil,"Min(-1,-2,-3) harus -3");

    }
    @Test
    void skenario3(){
        int hasil = Main.findmin(0,0,1);
        assertEquals(0,hasil,"Min(0,0,1) harus 0");
    }
}