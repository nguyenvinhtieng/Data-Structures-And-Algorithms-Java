import java.util.NoSuchElementException;
public class Bai3 {
    public int countEven (MyLinkedList<Integer> list) throws NoSuchElementException{
        if(list.getHead() == null){
            throw new NoSuchElementException("The list id empty");
        }
        else{
            int count = 0;
            for(Node <Integer> i = list.getHead();i.getNext() != null;i = i.getNext()){
                if(i.getData()%2==0){
                    count++;
                }
            }
            return count;
        }
    }
    
    public boolean checkPrime (Node<Integer> n){
        for(int i=2;i<n.getData()/2;i++){
            if(n.getData()%i==0){
                return false;
            }
        }
        return true;
    }
    
    public int countPrime(MyLinkedList <Integer> list){
        if(list.getHead() == null){
            throw new NoSuchElementException("The list id empty");
        }
        else{
            int count = 0;
            for(Node <Integer> i = list.getHead();i.getNext() != null;i = i.getNext()){
                boolean boo = checkPrime(i);
                if(boo){
                    count++;
                }
            }
            return count;
        }
    }
    
    public int addItem(MyLinkedList <Integer> list,Node<Integer> Item){
        if(list.getHead() == null){
            throw new NoSuchElementException("The list id empty");
        }
        else{
            for(Node <Integer> i = list.getHead();i.getNext() != null;i = i.getNext()){
                Node <Integer> temp = i.getNext();
                if(temp.getData()%2!=0){
                    Item.setNext(i.getNext());
                    i.setNext(Item);
                }
            }
            return Item.getData();
        }
    }
    
    public int findMax (MyLinkedList<Integer> list) throws NoSuchElementException{
        if(list.getHead() == null){
            throw new NoSuchElementException("The list id empty");
        }
        else{
            int Max = list.getHead().getData();
            for(Node<Integer> i=list.getHead().getNext();i.getNext()!=null;i=i.getNext()){
                if(i.getData()> Max){
                    Max = i.getData();
                }
            }
            return Max;
        }
    }
    
    public MyLinkedList<Integer> reverse (MyLinkedList<Integer> list)
        throws NoSuchElementException{
        if(list.getHead()==null){
            throw new NoSuchElementException("The list is empty");
        }
        else{
            Node<Integer> n1 = list.getHead();
            Node<Integer> n2 = n1.getNext();
            Node<Integer> n3 = n2.getNext();
            n1.setNext(null);
            while(n1==null&&n2==null&&n3==null){
                n2.setNext(n1);
                n1 = n3.getNext();
                n3.setNext(n2);
                n2=n1.getNext();
                n1.setNext(n3);
                n3=n2.getNext();
            }
            return list;
        }
    }
    
    public MyLinkedList<Integer> sortList(MyLinkedList<Integer> list){
        if(list.getHead()==null){
            throw new NoSuchElementException("The list is empty");
        }
        else{
            MyLinkedList<Integer> listOut = new MyLinkedList<Integer>();
            for(int i=0;i<list.size();i++){
                int max = list.getHead().getData();
                Node<Integer> temp = null;
                for(Node<Integer> j=list.getHead();j != null;j=j.getNext()){
                    if(j.getNext()==null){
                        break;
                    }
                    if(j.getNext().getData()>max){
                        temp = j;
                        max = j.getNext().getData();
                    }
                }
                if (temp.getNext()== null){
                    temp.setNext(null);
                    continue;
                }
                temp.setNext(temp.getNext().getNext());
                listOut.addFirst(max);
            }
        }
        return list;
    }
}
