import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class KajetanBucholc 
{
    public static void main(String args[]) 
    {
        Scanner scan = new Scanner(System.in);
		zad1();
		System.out.println("Napisz coś:\n");
		String txt = scan.nextLine();
		zad2(txt);
		scan.close();
    }
    private static void zad1()
    {
        final List<Data> col = new ArrayList<>();
        final Random r = new Random();
        for (int i = 0; i < 10; i++)
        {
            col.add(new Data(LocalDate.now().plusDays(r.nextInt()), LocalDateTime.now().plusDays(r.nextInt())));
            col.forEach(System.out::println);
            System.out.println();
            col.stream().sorted(Comparator.comparing(a -> a.localdate)).forEach(System.out::println);
        }
    }
    private static int zad2(String pkt)
    {
        final Map<String, Integer> number = Map.of(
        "", 0,
        "aeinorswz", 1,
        "cdklmpty", 2,
        "bghjłu", 3,
        "ąęfóśż", 5,
        "ć", 6,
        "ń", 7,
        "ź", 9
        );

        int score = 0;
        for (char letter : pkt.toCharArray())
        {
            for (Map.Entry<String, Integer> i : number.entrySet())
            {
                if (i.getKey().contains(String.valueOf(letter)))
                {
                    score = score + i.getValue();
                    break;
                }
            }
        }
        return score;
    }
}
    

class Data 
{
    LocalDate localdate;
    LocalDateTime localdatetime;

    public Data(LocalDate a, LocalDateTime name) 
    {
        this.localdate =a;
        this.localdatetime=name;
    }
    @Override
    public String toString() 
    {
        return "data: " + "localData -->'" + localdate + '\'' + ", localFateTime -->" + localdatetime + '|';
    }
}