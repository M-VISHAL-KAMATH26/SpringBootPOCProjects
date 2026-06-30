import java.util.Optional;

class Address{
    public String city;

    public Address(){}
    public Address(String city){
        this.city=city;
    }
}

class Person{
    public String name;
    public Address address;
    public Person(){}
    public Person(String name,Address address){
        this.name=name;
        this.address=address;
    }

    public Optional<Address> getAddress(){
        return Optional.ofNullable(address);
    }
}


public class OptionalPOC {
public static String getCityIfLong(Person person){
    Optional<Person> personOpt = Optional.ofNullable(person);
    Optional<Address> adressOpt=personOpt.flatMap(g->g.getAddress());
    Optional<String> cityOpt=adressOpt.map(address -> address.city);
    Optional<String> city=cityOpt.filter(s->s.length()>5);
    Optional<String> toUCcity=city.map(String::toUpperCase);
    String res=toUCcity.orElse("UNKNOWN");
    return res;
}
    public static void main(String[] args) {
    Person p=new Person("vishal",new Address("Banglore"));
        Person p1=new Person("delosn",new Address("pune"));
        Person p2=new Person("sneha",null);

        String res1=getCityIfLong(p);
        String res2=getCityIfLong(p1);
        String res4=getCityIfLong(null);
       String res3= getCityIfLong(p2);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);





    }
}
