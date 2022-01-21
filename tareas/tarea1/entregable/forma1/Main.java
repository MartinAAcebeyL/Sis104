class Main{
	public static void main(String[] args){
        Ecua2 ecuacion = new Ecua2(3,-5,1);
        Ecua2.Interna interna = ecuacion.new Interna();
        
        System.out.println(interna.ecuacion_2do_grado());
		
	}
}