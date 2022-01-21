class MainF{
	public static void main(String[] args){
		F f = new F("Perez");
		F.P p = f.new P();
		System.out.println("Attribute main class: "+f.getAtributo());
		p.mostrar();
	}
}