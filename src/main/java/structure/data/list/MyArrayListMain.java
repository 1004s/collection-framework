package structure.data.list;

public class MyArrayListMain {
    public static void main(String[] args) {
        System.out.println("### list1 ###");

        MyList<String> list  = new MyArrayList<>();
        list.add("red");
        list.add("green");
        list.set(0,"white");
        list.add("blue");
        list.add("white");
        list.add("white");
        list.add("white");

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }


        System.out.println("### remove white element ###");
        list.remove(0);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }


        System.out.println("### contains red element");
        System.out.println( list.contains("red") );

    }
}