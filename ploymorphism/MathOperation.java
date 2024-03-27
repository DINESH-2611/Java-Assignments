package ploymorphism;

public class MathOperation {
    public int add(int a,int b){
        return a+b;
    }
    public long add(int a,long b){
        return a+b;
    }
    public double add(long a,double b){
        return a+b;
    }
    public int sub(int a,int b){
        return a-b;
    }
    public long sub(int a,long b){
        return a-b;
    }
    public double sub(long a,double b){
        return a-b;
    }
    public int multiply(int a,int b){
        return a*b;
    }
    public long multiply(int a,long b){
        return a*b;
    }
    public double multiply(long a,double b){
        return a*b;
    }
    public int divide(int a,int b){
        if(b==0)
            throw new ArithmeticException();
        return a/b;
    }
    public long divide(int a,long b){
        if(b==0)
            throw new ArithmeticException();
        return a/b;
    }
    public double divide(long a,double b){
        if(b==0)
            throw new ArithmeticException();
        return a/b;
    }
}
