package mateacademy.homework.homework_8;

public class Main {

    public static void main(String[] args) {

        MyArrayList<String> temp = new MyArrayList();
        temp.add("one");
        temp.add("two");
        temp.add("three");
        System.out.println("\n add test:\n");
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
        MyArrayList<String> str = new MyArrayList();
        str.add("four");
        str.add("five");
        str.add("six");
        str.add("seven");
        temp.addAll(str);
        System.out.println("\n addAll test:\n");
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
        System.out.println("\n size = " + temp.size());
        System.out.println("\n remove test [five]: \n");
        temp.remove("five");
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
        System.out.println("\n size = " + temp.size());
        System.out.println("\n set test [five]: \n");
        temp.set("set", 2);
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
        System.out.println("\n size = " + temp.size());
        System.out.println("\n add test [value, index]: \n");
        temp.add("new", 2);
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
        System.out.println("\n size = " + temp.size());
    }
}
