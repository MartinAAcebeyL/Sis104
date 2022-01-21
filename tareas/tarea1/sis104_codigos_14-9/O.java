class O{
	private int x;
	private int y;
	
	public O(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void mostrar(){
		R r = new R();
		System.out.println("Calculo: "+ r.operacion());
	}
	
	private class R{
		private int operacion(){
			return x*x+y*y;
		}
	}
}