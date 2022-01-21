class I{
	private int m;
	private int n;

	public I(int m, int n){
		this.m = m;
		this.n = n;
	}
	
	public void mostrar(){
		A a = new A(){
			public int operacion(){
				return 2*m+3*n;
			}
		};
		System.out.println("Result: "+a.operacion());
	}
}