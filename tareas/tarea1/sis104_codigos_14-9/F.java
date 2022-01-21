class F{
	private String atributo;
	public F(String atributo){
		this.atributo = atributo;
	}
	public String getAtributo(){ return this.atributo; }
	
	class P{
		public void mostrar(){
			System.out.println("Attirbute: " + atributo);
		}
	}
}