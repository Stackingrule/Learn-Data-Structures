package LinkedList;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new SingleLinkedList<Integer>();
        list.add(0);
        list.add(1);
        list.add(2);

        //System.out.println(list.get(1));
        System.out.println(list.toString());

        System.out.println("ArrayList");
    }

}
