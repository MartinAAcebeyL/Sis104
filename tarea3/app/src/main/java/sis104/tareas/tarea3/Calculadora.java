package sis104.tareas.tarea3;

public class Calculadora {
    private float num1,num2;

    Calculadora(float num1, float num2){
        this.num1 = num1;
        this.num2 = num2;
    }

    public float suma(){
        return this.num1 + this.num2;
    }

    public float resta(){
        return this.num1 - this.num2;
    }

    public float producto(){
        return this.num1 * this.num2;
    }

    public float division(){
        return this.num1 / this.num2;
    }
}