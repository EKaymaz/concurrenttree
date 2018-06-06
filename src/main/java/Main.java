import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int max_t = 10;
        BinarySearchTree tree = new BinarySearchTree();

        Runnable producer = new Producer(tree, 800);
        Runnable consumer_1 = new Consumer(tree, 1000);
        Runnable consumer_2 = new Consumer(tree, 5000);
        Runnable consumer_3 = new Consumer(tree, 1000);
        Runnable consumer_4 = new Consumer(tree, 2000);
        Runnable consumer_5 = new Consumer(tree, 3000);
        Runnable consumer_6 = new Consumer(tree, 4000);

        ExecutorService pool = Executors.newFixedThreadPool(max_t); // initializing thread pool

        pool.execute(producer);
        pool.execute(consumer_1);
        pool.execute(consumer_2);
        pool.execute(consumer_3);
        pool.execute(consumer_4);
        pool.execute(consumer_5);
        pool.execute(consumer_6);

        pool.shutdown();
    }
}




