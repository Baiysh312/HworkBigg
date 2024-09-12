import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
//        List<Integer> arr= new ArrayList<>();
//        arr.add(12);
//        arr.add(5);
//        arr.add(22);
//        arr.add(8);
//        arr.add(1);
//        List<Integer>arr1 = arr.stream().sorted((a,z) -> z - a).collect(Collectors.toList());
//        System.out.println(arr1);

        List<String> strArr= new ArrayList<>();
        strArr.add("aple");
        strArr.add("Potato");
        strArr.add("fresh");
        strArr.add("Tomato");
        strArr.add("Banana");
        strArr.add("fruits");
        Predicate<String> predicate= new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if(s.length()>5){return true;}
                return false;
            }
        };
        List<String>strA = strArr.stream().filter(n->predicate.test(n)).collect(Collectors.toList());
        System.out.println(strA);

        List<Double> db= new ArrayList<>();
        db.add(12.5);
        db.add(8.3);
        db.add(5.2);
        db.add(2.9);
        db.add(6.6);
        Double srDb= db.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        System.out.println(srDb);

        MyClass myClass= new MyClass(12,2.2);
        MyClass myClass1= new MyClass(13,1.2);
        MyClass myClass2= new MyClass(14,3.2);
        MyClass myClass3= new MyClass(15,4.2);
        List<MyClass> myClasses= new ArrayList<>();
        myClasses.add(myClass);
        myClasses.add(myClass1);
        myClasses.add(myClass2);
        myClasses.add(myClass3);

        MyClass max= myClasses.stream().max(new Comparator<MyClass>(){
            @Override
            public int compare(MyClass o1, MyClass o2) {
                return Double.compare(o1.getaDouble(), o2.getaDouble());
            }
        } ).orElse(null);
        System.out.println(max.getaDouble());

        Double dbSr= myClasses.stream().mapToDouble(MyClass::getaDouble).max().orElse(0.0);
        System.out.println(dbSr);

        List<Integer> integers= new ArrayList<>();
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);

        List<Integer> integers1 = integers.stream().map(n->n*2).collect(Collectors.toList());
        System.out.println(integers1);
    }
}
