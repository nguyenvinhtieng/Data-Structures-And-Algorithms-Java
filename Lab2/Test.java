public class Test {
	public static void main(String[] args)
	{
		MyLinkedList <Integer > list = new MyLinkedList <Integer>();
		list.addFirst(new Integer(1));
		list.addLast(new Integer(2));
		list.addLast(new Integer(3));
		list.addLast(new Integer(5));
		list.addLast(new Integer(4));
		list.print();
		Bai3 b3 = new Bai3();
        System.out.println(b3.findMax(list));
	}
}