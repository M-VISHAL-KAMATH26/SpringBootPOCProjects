import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIs {

    public static void main(String[] args) {
//        Given a list of strings, convert all of them to uppercase and collect the result into a List<String>.
        System.out.println("-----------------------------------");

        List<String> names=new ArrayList<>(List.of("Vishal","guru","Delson","PraDosh"));

        List<String> uppercaseNames=names.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(uppercaseNames);

        System.out.println("-----------------------------------");
//        Given a list of integers, filter out only the even numbers, then square each of them, and collect into a List<Integer>.
        List<Integer> integers=new ArrayList<>(List.of(33,4,22,42,56,98,78,77));
        List<Integer> resultOfIntgers=integers.stream().filter(n->n%2==0).map(n->n*n).collect(Collectors.toList());

        System.out.println(resultOfIntgers);
        System.out.println("-----------------------------------");


//        Given a list of strings, group them by their length. Return a Map<Integer, List<String>> where the key is the string length and the value is the list of strings with that length.

        List<String> words = List.of("cat", "dog", "bird", "fish", "ox", "hen");
// expected output: {2=[ox], 3=[cat, dog, hen], 4=[bird, fish]}
        Map<Integer, List<String>> byLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(byLength);
        System.out.println("-----------------------------------");

//        Given a list of strings, partition them into two groups: those with length greater than 3, and those with length 3 or less. Return a Map<Boolean, List<String>>.

        List<String> animals = List.of("cat", "dog", "bird", "fish", "ox", "hen");
        Map<Boolean, List<String>>aimalRes=animals.stream().collect(Collectors.partitioningBy(n->(n.length())>3));
        System.out.println(aimalRes);

        System.out.println("-----------------------------------");

//        Given a list of strings, group them by their length, but instead of getting the list of strings per group, just get the count of strings per group.
        List<String> animals2 = List.of("cat", "dog", "bird", "fish", "ox", "hen");
// expected output: {2=1, 3=3, 4=2}

        Map<Integer,Long> mappingAnimals=animals2.stream().collect(Collectors.groupingBy(String::length,Collectors.counting()));
        System.out.println(mappingAnimals);
        System.out.println("-----------------------------------");

//        Given a list of integers, find the sum of all numbers greater than 10.
        List<Integer> nums = List.of(5, 12, 8, 20, 3, 15);
int res=nums.stream().filter(n->n>10).mapToInt(n->n).sum();
        System.out.println(res);

        System.out.println("-----------------------------------");

//given the list of strings find the largest string

        List<String> zoo = List.of("cat", "elephant", "dog", "hippopotamus", "ox");
Optional<String> zooLongest=zoo.stream().max(Comparator.comparingInt(String::length));
        zooLongest.ifPresent(n-> System.out.println(n));

        System.out.println("-----------------------------------");

//        Given a list of integers, remove duplicates and sort them in descending order.

        List<Integer> nums2 = List.of(5, 3, 8, 3, 9, 5, 1, 8);
        nums2.stream().distinct().sorted(Comparator.reverseOrder()).forEach(n-> System.out.println(n));
        System.out.println("-----------------------------------");


    }
}
