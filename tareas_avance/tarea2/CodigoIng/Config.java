class Config{
    private String IP;
    private String DataBase;
    
    private static final Config config = new Config("192.168.1.10","DataBaseSIS104");
    
    private Config(String IP, String DataBase){
	this.IP = IP;
	this.DataBase = DataBase; 
    }

    public static Config getInstancia(){
	return config;
    }

    public String getIP(){ return this.IP; }
    public String getDataBase(){ return this.DataBase; } 
}