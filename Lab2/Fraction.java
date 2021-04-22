import java.util.*;
public class Fraction{
	private int numer;
	private int demon;
	
	public Fraction(int numer, int demon)
	{
		this.numer = numer;
		this.demon = demon;
	}
	
	public Fraction (Fraction f)
	{
		this.numer = f.numer;
		this.demon = f.demon;
	}
	
	public String toString()
	{
		return this.numer+"/"+this.demon;
	}
	
	public boolean equals(Fraction f)
	{
		return (this.numer/this.demon) == (f.numer/f.demon);
	}
}
	