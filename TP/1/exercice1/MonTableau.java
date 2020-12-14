/**
 * 
 */
package exercice1;

/**
 * @author Vincent Bonnemayre
 *
 */
public class MonTableau implements EstComparable
{
	private int[] values;
	
	/**
	 * Constructeur de MonTableau
	 * @param a -- tableau d'entier qui sera attribué à cette instance de MonTableau (deepcopy)
	 */
	public MonTableau(int[] a)
	{
		values = a.clone();
	}
	/**
	 * Constructeur de MonTableau
	 * Initialise le tableau sans valeur
	 */
	public MonTableau()
	{
		this(new int[] {});
	}
	
	/**
	 * Fonction de l'interface EstComparable.
	 * Compare la somme du tableau d'entier de cette instance et celle de celui entré en paramètre
	 * @param o - Tableau que l'on veut comparer
	 * @return retourne -1 si cette instance à une somme inferieure, 0 si égale, 1 sinon.
	 * Peut lever des exceptions.
	 */
	@Override
	public int compareA(Object o) throws Exception
	{
		int result = 1;
		if(o instanceof MonTableau)
		{
			MonTableau temp = (MonTableau) o;
			int sumOfThis = this.doSum();
			int sumOfO = temp.doSum();
			if(sumOfThis < sumOfO)
			{
				result = -1;
			}
			else if (sumOfThis == sumOfO)
			{
				result = 0;
			}
		}
		else
		{
			if(o == null)
			{
				throw new NullPointerException();
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
		return result;
	}
	
	/**
	 * Calcule la somme du tableau d'entier.
	 * @return la somme du tableau d'entier.
	 */
	public int doSum()
	{
		int val = 0;
		for (int i: values)
		{
			val +=i ;
		}
		return val;
	}
}
