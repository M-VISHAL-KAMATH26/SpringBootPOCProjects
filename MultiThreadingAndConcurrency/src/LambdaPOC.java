import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Book{
    public String title;
    public String author;
    public int pages;
    public Book(){};
    public Book(String title,String author,int pages){
        this.title=title;
        this.author=author;
        this.pages=pages;
    }
}

@FunctionalInterface
interface FiDemo{
     public abstract void printing();
}
public class LambdaPOC {
public static void printBooksMatching(List<Book> books, Predicate<Book> condition){
    for(Book b:books){
        if(condition.test(b)){
            System.out.println(b.title);
        }
    }
}


public static void printTransformed(List<Book> books, Function<Book,String> transformer){
    for(Book b:books){
        System.out.println(transformer.apply(b));
    }
}

public static void processBokks(List<Book> books, Consumer<Book> action){
    for(Book b:books){
        action.accept(b);
    }
}

    public static Book getDefaultBook(Supplier<Book> supplier){
        return supplier.get();
    }
    public static void main(String[] args) {

    FiDemo f=()->System.out.println("hi");
f.printing();

        List<Book> bookList=new ArrayList<>();
        bookList.add(new Book("love you","vishal",500));
        bookList.add(new Book("half grilfriend","chethan",689));
        bookList.add(new Book("gaurav tiwari","gaurav",230));
        bookList.add(new Book(" majestic island","pankaj",160));
        bookList.add(new Book("ramayan","valmiki",700));

        System.out.println("-----predicate-----");
        printBooksMatching(bookList,b->b.pages>300);
        printBooksMatching(bookList,b->b.author.equals("vishal"));
        System.out.println("-----Function-----");
        printTransformed(bookList,b -> (b.title + " by " + b.author).toUpperCase());
        System.out.println("-----consumer-----");
        processBokks(bookList,b-> System.out.println("processing: "+b.title));
        System.out.println("-----supplier-----");
        Book defaultBook = getDefaultBook(() -> new Book("Unknown Book", "Unknown Author", 0));
        System.out.println(defaultBook.title + " - " + defaultBook.pages + " pages");
    }
}
