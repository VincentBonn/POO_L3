package Exo1;

public class GeneriqueClass<T,U>
{
	private T first;
	private U second;
	
	/**
	 * Constructor of GeneriqueClass
	 * @param first -- first object of type T
	 * @param second -- second object of type U
	 */
	public GeneriqueClass(T first,U second)
	{
		this.first = first; 
		this.second = second;
	}
	/**
	 * Getter of first
	 * @return first.
	 */
	public T getFirst()
	{
		return first;
	}
	/**
	 * Getter of second
	 * @return second.
	 */
	public U getSecond()
	{
		return second;
	}
	/**
	 * Setter of first
	 * @param first -- object which replace first in this instance.
	 */
	public void setFirst(T first)
	{
		this.first = first;
	}
	/**
	 * Setter of second
	 * @param second -- object which replace second in this instance.
	 */
	public void setSecond(U second)
	{
		this.second = second;
	}

}
