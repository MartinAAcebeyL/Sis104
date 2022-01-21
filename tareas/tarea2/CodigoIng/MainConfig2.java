class MainConfig2{
    public static void main(String[] args){
	Config2 config2 = Config2.setInstancia("192.168.1.10","SIS104DataBase");
	Config2 config3 = Config2.setInstancia("192.168.1.20","xyz");
	System.out.println("IP: "+config2.getIP());
	System.out.println("IP: "+config3.getIP());
	System.out.println("IP: "+config2.getInstancia().getIP());
	System.out.println("IP: "+config3.getInstancia().getIP());
    }
}