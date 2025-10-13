package edu.fatec.praticaTDD.triangle;

public class Triangle {

    private int sizeA;
    private int sizeB;
    private int sizeC;

    public Triangle() {
    }

    public String identifyTriangle(int sizeA, int sizeB, int sizeC){
        if(sizeA < 0 || sizeB < 0 || sizeC < 0){
            return "Negative size";
        }

        if (sizeA == 0 && sizeB == 0 && sizeC == 0) {
            return "Zero size";
        }

        if (sizeA + sizeB <= sizeC || sizeA + sizeC <= sizeB || sizeB + sizeC <= sizeA) {
            return "Invalid size";
        }
        

        if(sizeA == sizeB && sizeB == sizeC){
            return "Equilateral";
        } else if(sizeA == sizeB || sizeB == sizeC || sizeA == sizeC){
            return "Isosceles";
        } else {
            return "Scalene";
        }
    }

    public int getSizeA() {
        return sizeA;
    }

    public int getSizeB() {
        return sizeB;
    }

    public int getSizeC() {
        return sizeC;
    }

    public void setSizeA(int sizeA) {
        this.sizeA = sizeA;
    }

    public void setSizeB(int sizeB) {
        this.sizeB = sizeB;
    }

    public void setSizeC(int sizeC) {
        this.sizeC = sizeC;
    }

}
