import java.util.List;
import java.util.Random;

public class test<E> {
    List<E> items;
    Random random;

    public test(List<E> i) {
        items = i;
        random = new Random();
    }

    public E returnShuffled() {
        return items.remove(random.nextInt(items.size()));
    }

    public E nextText(E item) throws Exception {
        if(item == null) {
            throw new Exception("Something is wrong");
        }
        else {
            return item;
        }
    }
}