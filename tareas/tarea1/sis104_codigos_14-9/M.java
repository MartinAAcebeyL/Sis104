class M{
	private int p;
	private int q;
	
	public M(int p, int q){
		this.p = p;
		this.q = q;
	}
	
	public void mostrar(){
		class SI{
			private int operacion(){
				return p*p*p+q*q*q;
			}
		}
		SI si = new SI();
		int r = si.operacion();
		System.out.println("Operation: "+r);
	}
}