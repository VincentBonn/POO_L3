package exercice2;

public class CiterneSecurisee extends Citerne 
{
	private Citerne citerneSecondaire;
	public CiterneSecurisee(int volumeTotal,Citerne c)
	{
		super(volumeTotal);
		trySetCiterneSecondaire(c);
	}
	
	@Override
	protected void tryAjouterLiquide(int amount) throws IllegalArgumentException
	{
		if(amount + volumeActuel <= volumeTotal)
		{
			volumeActuel += amount;
		}
		else
		{
			System.err.print("\nRemplissage dans la citerne de secours !\n");
			if(amount + volumeActuel +citerneSecondaire.getVolumeActuel()  <= volumeTotal + citerneSecondaire.getVolumeTotal())
			{
				amount -= volumeTotal - volumeActuel;
				volumeActuel = volumeTotal;
				try
				{
					citerneSecondaire.ajouterLiquide(actualLiquid,amount);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			else 
			{ 
				throw new IllegalArgumentException("Montant de volume ajouté trop élevé, il y aurait débordement du trop plein de"+Math.abs((amount + volumeActuel +citerneSecondaire.getVolumeActuel())-(volumeTotal + citerneSecondaire.getVolumeTotal()))+"m3");
			}
		}
	}
	private void trySetCiterneSecondaire(Citerne c)
	{
		if(c != null)
		{
			citerneSecondaire = c;
		}
		else
		{
			citerneSecondaire = new Citerne((int)volumeTotal/10);
		}
	}
	public Citerne getCiterneSecondaire()
	{
		return citerneSecondaire;
	}
	
	@Override
	public boolean equals(Object o)
	{
		boolean result = false;
		if(o instanceof CiterneSecurisee)
		{
			CiterneSecurisee temp =(CiterneSecurisee) o;
			boolean valtemp = temp.getCiterneSecondaire().equals(this.citerneSecondaire);
			Citerne temp2 =(Citerne) o;
			result = super.equals(temp2) && valtemp;
		}
		return result;
	}
	
	@Override
	public String toString()
	{
		return super.toString()+" \n|| Citerne trop plein :"+citerneSecondaire.toString();
	}
}
