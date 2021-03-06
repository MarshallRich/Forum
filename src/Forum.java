import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MacLap on 2/11/16.
 */
public class Forum {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();

        //read all the posts into memory
        File f = new File("posts.txt");
        Scanner fileScanner = new Scanner(f);
        while (fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            Post post = new Post(Integer.valueOf(columns[0]), columns[1], columns [2]);
            posts.add(post);
        }

        Scanner consoleScanner = new Scanner(System.in);

        int replyId = -1;
        while (true) {
            //loop over posts and print the ones with the correct reply ID
            int id = 0;
            for (Post post : posts) {
                if (post.replyId == replyId) {
                    System.out.printf("");
                }
                id++;
            }
            //asking the user to type a new reply ID
            System.out.println("Type the id you want to see replies to:");
            replyId = Integer.valueOf(consoleScanner.nextLine());
        }
    }
}
