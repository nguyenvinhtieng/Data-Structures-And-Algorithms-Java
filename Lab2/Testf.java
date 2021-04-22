public class Testf {
	public static void main(String[] args)
	{
		MyLinkedList <Fraction> list = new MyLinkedList <Fraction>();
		list.addFirst(new Fraction(2,3));
		list.addLast(new Fraction(3,4));
		list.print();
	}
}