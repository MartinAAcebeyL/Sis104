class MainConfig{
    public static void main(String[] args){
	System.out.println("IP: "+ Config.getInstancia().getIP());
	System.out.println("Data Base "+Config.getInstancia().getDataBase());
    }
}