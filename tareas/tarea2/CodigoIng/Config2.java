class Config2{
    private String IP;
    private String DataBase;

    private static Config2 config2;

    private Config2(String IP, String DataBase){
	this.IP = IP;
	this.DataBase = DataBase;
    }

    public static final Config2 setInstancia(String IP, String DataBase){
	
	config2 = new Config2(IP,DataBase);

	return config2;
    }

    public static Config2 getInstancia(){
	return config2;
    }

    public String getIP(){ return this.IP; }
    public String getDataBAse(){ return this.DataBase; }
}