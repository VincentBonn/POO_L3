package exercice2;

public enum Liquid
{
	Eau(10),
	Vin(15),
	Huile(9);
	
	
	private int temperature;
	Liquid(int temperature)
	{
		this.temperature = temperature;
	}
    public int getTemperature()
    {
       return temperature;
    }
}
