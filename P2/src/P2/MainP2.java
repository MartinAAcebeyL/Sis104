package P2;
import java.io.*;
import java.util.Scanner;

class Excepciones extends Exception {
    String errStr; 
    public Excepciones(String str) {
        errStr = str;
    }
    public String toString() {
        return errStr;
    }
}

class Analizador {
    final int NINGUNO = 0;
    final int DELIMITADOR = 1;
    final int VARIABLE = 2;
    final int NUMERO = 3;
    
    final String FINEXP = "\0";
    
    private String expresion_aritmetica; 
    private int indice; 
    private String token; 
    private int tipoToken; 
	

    public double evaluar(String cadenaExp) throws Excepciones{
        double resultado;
        expresion_aritmetica = cadenaExp;
        indice = 0;
        obtieneToken();
        if(token.equals(FINEXP)){
            error(); 
        } 
        
        resultado = evaluar_sum_res();
        if(!token.equals(FINEXP)){ 
            error();
        }
        return resultado;
    }

    private double evaluar_sum_res() throws Excepciones{
        char op;
        double resultado;
        double resultadoParcial;
        resultado = evaluar_multi_div_mod();
        while((op = token.charAt(0)) == '+' || op == '-') {
            obtieneToken();
            resultadoParcial = evaluar_multi_div_mod();
            switch(op) {
                case '-':
                    resultado = resultado - resultadoParcial;
                break;
                case '+':
                    resultado = resultado + resultadoParcial;
                break;
            } 
        }
        return resultado;
    }
    
    private double evaluar_multi_div_mod() throws Excepciones{
    char op;
    double resultado;
    double resultadoParcial;
    resultado = evaluar_mas_menos();
    while((op = token.charAt(0)) == '*' || op == '/' || op == '%'){
        obtieneToken();
        resultadoParcial = evaluar_mas_menos();
        switch(op) {
            case '*':
                resultado = resultado * resultadoParcial;
            break;
            case '/':
                if(resultadoParcial == 0.0){
                    error();
                }
                resultado = resultado / resultadoParcial;
            break;
            case '%':
                if(resultadoParcial == 0.0){
                    error();
                }
                resultado = resultado % resultadoParcial;
            break;
        }
    }
    return resultado;
  }

    private double evaluar_mas_menos() throws Excepciones{
        double resultado;
        String  op;
        op = "";
        if((tipoToken == DELIMITADOR) && token.equals("+") || token.equals("-")){
            op = token;
            obtieneToken();
        }
        resultado = evaluar_parentesis();
        if(op.equals("-")){
            resultado = -resultado;
        }
        return resultado;
    }

    private double evaluar_parentesis() throws Excepciones{
        double resultado;
        if(token.equals("(")) {
            obtieneToken();
            resultado = evaluar_sum_res();
            if(!token.equals(")")){
                error();
            }
            obtieneToken();
        }else{
            resultado = calculo();
        }
        return resultado;
    }

    private double calculo() throws Excepciones{
        double resultado = 0.0;
        switch(tipoToken){
            case NUMERO:
                try {
                  resultado = Double.parseDouble(token);
                } catch (NumberFormatException exc) {
                  error();
                }
                obtieneToken();
                break;
            default:
                error();
                break;
        }
        return resultado;
    }

    private void error() throws Excepciones{
        throw new Excepciones("Error");
    }

    private void obtieneToken(){
        tipoToken = NINGUNO;
        token = "";
        if(indice == expresion_aritmetica.length()){
            token = FINEXP;
            return;
        }

        while(indice < expresion_aritmetica.length() && Character.isWhitespace(expresion_aritmetica.charAt(indice))){
            ++indice;
        }

        if(indice == expresion_aritmetica.length()){
            token = FINEXP;
            return; 
        }

        if(esDelimitador(expresion_aritmetica.charAt(indice))){ 
            token += expresion_aritmetica.charAt(indice);
            indice++;
            tipoToken = DELIMITADOR;
        }else if(Character.isLetter(expresion_aritmetica.charAt(indice))) { 
            while(!esDelimitador(expresion_aritmetica.charAt(indice))){
                token += expresion_aritmetica.charAt(indice);
                indice++;
                if(indice >= expresion_aritmetica.length()){
                    break;
                }
            }
        tipoToken = VARIABLE;
        }else if(Character.isDigit(expresion_aritmetica.charAt(indice))){ 
            while(!esDelimitador(expresion_aritmetica.charAt(indice))){
                token += expresion_aritmetica.charAt(indice);
                indice++;
                if(indice >= expresion_aritmetica.length()){
                    break;
                }
            }
        tipoToken = NUMERO;
        }else{ 
            token = FINEXP;
            return;
        } 
    }

    private boolean esDelimitador(char c){
        return "+-/*^=%()".indexOf (c) != -1;
      }
}    



public class MainP2 { 
    public static void main(String args[])throws IOException{
        Scanner sc = new Scanner(System.in);
        
        Analizador analizador = new Analizador();
        System.out.println("DE UNA EXPRESION");
        String expresion = sc.nextLine();
        
        try {
            System.out.println(analizador.evaluar(expresion));
        }catch(Excepciones exc) {
            System.out.println(exc);
        }       
    }
}