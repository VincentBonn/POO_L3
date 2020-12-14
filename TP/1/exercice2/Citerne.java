package exercice2;

import java.time.LocalDate;

public class Citerne
{
	public final static int MAX_VOLUME = 20000;
	protected static int nombreTotalCiterne = 0;
	protected static enum liquide {Eau, Vin, Huile};
	protected final int numeroCiterne; 
	protected int volumeTotal;
	protected int volumeActuel;
	protected LocalDate dateCreation;
	protected Liquid actualLiquid;
	protected boolean isClean;

	public Citerne(int volumeTotal) throws IllegalArgumentException
	{
		setVolume(volumeTotal);
		dateCreation = LocalDate.now();
		nombreTotalCiterne++;
		numeroCiterne = nombreTotalCiterne;
		isClean = true;
		volumeActuel = 0;
		
	}
	
	protected void setVolume(int volume) throws IllegalArgumentException
	{
		if(volume <= 0 || volume > MAX_VOLUME)
		{
			throw new IllegalArgumentException("Volume de création de citerne invalide");
		}
		else
		{
			this.volumeTotal = volume;
		}
	}
	public static int getNombreTotalCiterne()
	{
		return nombreTotalCiterne;
	}
	
	public void ajouterLiquide(Liquid liquid,int amount) throws LogisticErrorException,IllegalArgumentException
	{
		if(this.actualLiquid == liquid)
		{
			tryAjouterLiquide(amount);
		}
		else if(this.actualLiquid == null && isClean)
		{
			throw new LogisticErrorException("Aucun liquide n'a été assigné à cette cuve propre");
		}
		else if(this.actualLiquid == null && isClean == false)
		{
			throw new LogisticErrorException("La cuve n'est pas propre");
		}
		else
		{
			throw new IllegalArgumentException("Le mélange de volume implique deux liquides différents");
		}
	}
	protected void tryAjouterLiquide(int amount) throws IllegalArgumentException
	{
		if(amount + volumeActuel <= volumeTotal)
		{
			volumeActuel += amount;
		}
		else
		{
			throw new IllegalArgumentException("Le volume ajouté est trop élevé d'un montant de "+Math.abs(volumeTotal-(amount + volumeActuel))+"m3");
		}
	}
	public void ajouterLiquide(Liquid liquid,float percentage) throws LogisticErrorException,IllegalArgumentException
	{
		ajouterLiquide(liquid,(int)(percentage*100)*(volumeTotal/100));
	}
	
	public void enleverLiquide(int amount) throws LogisticErrorException
	{
		if(this.actualLiquid != null)
		{
			tryEnleverLiquide(amount);
		}
		else
		{
			throw new LogisticErrorException("Aucun liquide dans la cuve");
		}
	}
	protected void tryEnleverLiquide(int amount) throws IllegalArgumentException
	{
		if(volumeActuel - amount >= 0)
		{
			volumeActuel -= amount;
		}
		else
		{
			volumeActuel = 0;
			throw new IllegalArgumentException("Le volume enlevé est trop élevé d'un montant de "+(Math.abs(volumeActuel-amount))+"m3");
		}
	}
	public void enleverLiquide(float percentage) throws LogisticErrorException
	{
		enleverLiquide((int)(percentage*100)*(volumeTotal/100));
	}
	
	public LocalDate getDateCreation()
	{
		return dateCreation;
	}
	
	public LocalDate plusAncienne(Citerne c)
	{
		LocalDate date;
		if(c != null && this != null)
		{
			if(dateCreation.isBefore(c.getDateCreation()))
			{
				date = dateCreation;
			}
			else
			{
				date = c.getDateCreation();
			}
		}
		else
		{
			throw new NullPointerException();
		}
		return date;
	}
	public String toString()
	{
		return "Citerne n°"+ numeroCiterne +", "+actualLiquid+", Capacité : "+ volumeTotal +" m3, Mise en service : "+dateCreation.toString()+", volume occupé: "+volumeActuel+", Est propre :"+isClean;
	}
	public Liquid getActualLiquid()
	{
		return actualLiquid;
	}
	public void trySetLiquid(Liquid newLiquid) throws LogisticErrorException
	{
		if(actualLiquid != null && actualLiquid != newLiquid)
		{
			throw new LogisticErrorException("Un autre liquide est déjà défini, videz et nettoyez la cuve avant");
		}
		else if(actualLiquid == null && isClean == false)
		{
			throw new LogisticErrorException("La cuve n'est pas propre, impossible de définir un liquide");
		}
		else
		{
			actualLiquid = newLiquid;
			isClean = false;
		}
	}
	public int getVolumeTotal()
	{
		return volumeTotal;
	}
	public int getVolumeActuel()
	{
		return volumeActuel;
	}
	public boolean equals(Object o)
	{
		boolean result = false;
		if(o != null && o instanceof Citerne)
		{
			Citerne temp =(Citerne) o;
			if(temp.dateCreation.getYear() == dateCreation.getYear() && temp.dateCreation.getDayOfYear() == dateCreation.getDayOfYear() && temp.volumeActuel == volumeActuel && temp.getActualLiquid() == actualLiquid  && temp.getVolumeTotal() == volumeTotal)
			{
				result = true;
			}
		}
		return result;
	}
	public void cleanCiterne()
	{
		volumeActuel = 0;
		actualLiquid = null;
		isClean = true;
	}

	public boolean getIsClean()
	{
		return isClean;
	}
}
