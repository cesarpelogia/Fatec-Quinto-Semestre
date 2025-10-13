package edu.fatec.praticaTDD.triangle;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TriangleTest {

    
    @Test
    public void scaleneValid() {
        Triangle t = new Triangle();
        assertEquals("Scalene", t.identifyTriangle(2,3,4));
    }

    @Test
    public void equilateralValid() {
        Triangle t = new Triangle();
        assertEquals("Equilateral", t.identifyTriangle(4,4,4));
    }

    @Test
    public void isoscelesValid1() {
        Triangle t = new Triangle();
        assertEquals("Isosceles", t.identifyTriangle(5,5,3));
    }
    
    @Test
    public void isoscelesValid2() {
        Triangle t = new Triangle();
        assertEquals("Isosceles", t.identifyTriangle(5,3,5));
    }

    @Test
    public void isoscelesValid3() {
        Triangle t = new Triangle();
        assertEquals("Isosceles", t.identifyTriangle(3,5,5));
    }

    @Test
    public void zeroValue() {
        Triangle t = new Triangle();
        assertEquals("Invalid size", t.identifyTriangle(0,4,5));
    }

    @Test
    public void negativeValue() {
        Triangle t = new Triangle();
        assertEquals("Negative size", t.identifyTriangle(-1,4,5));
    }
    @Test
    public void sumEquals1() {
        Triangle t = new Triangle();
        assertEquals("Invalid size", t.identifyTriangle(1,2,3));
    }

    @Test
    public void sumEquals2() {
        Triangle t = new Triangle();
        assertEquals("Invalid size", t.identifyTriangle(1,3,2));
    }

    @Test
    public void sumEquals3() {
        Triangle t = new Triangle();
        assertEquals("Invalid size", t.identifyTriangle(3,1,2));
    }

    @Test
    public void sumLess1() {
        Triangle t = new Triangle();
        assertEquals("Invalid size", t.identifyTriangle(1,2,4));
    }

    @Test
    public void sumLess2() {
        Triangle t = new Triangle();
        assertEquals("Invalid size", t.identifyTriangle(2,4,1));
    }

    @Test
    public void sumLess3() {
        Triangle t = new Triangle();
        assertEquals("Invalid size", t.identifyTriangle(4,1,2));
    }

    @Test
    public void allZeros() {
        Triangle t = new Triangle();
        assertEquals("Zero size", t.identifyTriangle(0,0,0));
    }
}