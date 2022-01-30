class Ecua2 {
    private int a;
    private int b;
    private int c;
    
    public Ecua2(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String resultado(){
        InterfaceEcuacion interfaceE = new InterfaceEcuacion(){
            @Override
            public float discriminante(){ return b*b-4*a*c; }
            @Override
            public String ecuacion_2do_grado(){
                if (discriminante() == 0){
                    double r1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
                    return "resultado: "+r1;
                }else if(discriminante() > 0){
                    double r1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
                    double r2 = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
                    return "resultado 1: "+r1+" resultado 2: "+r2;
                }else
                    return "Resultados imaginarios";
            }
        };
        
        return interfaceE.ecuacion_2do_grado();
    }
}