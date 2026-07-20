import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIs {


    public  static boolean containsA(String s){
        if (s.toLowerCase().contains("a")){
            return true;
        }else{
            return false;
        }
    }
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
//find second largest in the list
        List<Integer> nums4 = List.of(10, 25, 8, 25, 32, 17);
// expected output: 25
       Optional<Integer> ress= nums4.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();

       ress.ifPresent(System.out::println);
        System.out.println("-----------------------------------");

//        Given a list of words, find the frequency of each word (i.e., how many times each word appears). Return a Map<String, Long>.
//        javaList<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");

                List<String> smallList = List.of("apple", "banana", "apple", "orange", "banana", "apple");

                Map<String,Long> resmap=smallList.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));

        System.out.println(resmap);
// expected output: {banana=2, orange=1, apple=3}

        System.out.println("-----------------------------------");

//        Given a list of integers, find the average of all numbers that are greater than 5.
        List<Integer> nums5 = List.of(2, 8, 4, 12, 6, 3, 20);
// expected output: 11.5   (average of 8, 12, 6, 20)

OptionalDouble avg=nums5.stream().filter(n->n>5).mapToInt(n->n).average();
avg.ifPresent(System.out::println);
        System.out.println("-----------------------------------");


//        Given a list of strings, convert them to a Map<String, Integer> where the key is the string itself and the value is its length. Skip any string with length less than 3.
        List<String> languages = List.of("go", "java", "c", "python", "sql");
// expected output: {java=4, python=6, sql=3}
      Map<String,Integer> mapping=  languages.stream().filter(n->n.length()>=3).collect(Collectors.toMap(n->n,String::length));
        System.out.println(mapping);
        System.out.println("-----------------------------------");


//        Given a list of integers, check if all numbers in the list are positive.
                List<Integer> checkNums = List.of(4, 8, 12, 3, 9);

            boolean matchingRes=checkNums.stream().allMatch(n->n>=0);
        System.out.println(matchingRes);
// expected output: true

        List<Integer> checkNums2 = List.of(4, -8, 12, 3, 9);
        boolean matchingRes2=checkNums2.stream().allMatch(n->n>=0);
        System.out.println(matchingRes2);
// expected output: false

        System.out.println("-----------------------------------");
//        Given a list of strings representing numbers, convert them to integers and find the sum.
                List<String> numStrings = List.of("10", "25", "30", "15");
               int summ= numStrings.stream().map(n->Integer.parseInt(n)).mapToInt(n->n).sum();

        System.out.println(summ);
        System.out.println("-----------------------------------");
//        Given a list of employee salaries, find the highest salary and the total sum of all salaries — but do it in a single pass (one stream operation, not two separate stream calls).
                List<Integer> salaries = List.of(45000, 62000, 38000, 71000, 55000);
                IntSummaryStatistics stats=salaries.stream().collect(Collectors.summarizingInt(n->n));

        System.out.println("max = "+stats.getMax()+ " "+"sum ="+stats.getSum());
// expected: max = 71000, sum = 271000
        System.out.println("-----------------------------------");

//        Given a list of strings, find all strings that contain the letter 'a' (case-insensitive), convert them to uppercase, and sort them alphabetically.
                List<String> wordss = List.of("banana", "Cherry", "Apple", "kiwi", "Mango");
// expected output: [APPLE, BANANA, MANGO]

List<String> operatedString=wordss.stream().filter(n->containsA(n)).map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println(operatedString);


        //above stream can alos be written using the method reference
//        List<String> operatedString = wordss.stream()
//                .filter(Test::containsA)     // method reference — no lambda wrapper needed
//                .map(String::toUpperCase)
//                .sorted()
//                .collect(Collectors.toList());
        System.out.println("-----------------------------------");
//        Given a list of Integer ages, categorize people into "Minor" (under 18), "Adult" (18-59), and "Senior" (60+), and count how many fall into each category.
                List<Integer> ages = List.of(15, 25, 65, 17, 45, 70, 8, 30);
// expected output: {Minor=3, Adult=3, Senior=2}

        System.out.println("-----------------------------------");


        System.out.println("-----------------------------------");




    }
}
