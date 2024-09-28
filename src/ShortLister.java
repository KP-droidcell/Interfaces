import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringTokenizer;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedfile;
        StringTokenizer tokenizer;
        String rec = "";
        String word = "";
        ShortWordFilter filter = new ShortWordFilter();

        try
        {
            File workingDirecory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirecory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedfile = chooser.getSelectedFile();
                Path file = selectedfile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                int line = 0;
                while (reader.ready())
                {
                    rec = reader.readLine();
                    line++;
                    tokenizer = new StringTokenizer(rec);
                    while (tokenizer.hasMoreTokens())
                    {
                        word = tokenizer.nextToken();
                        if (filter.accept(word))
                        {
                            System.out.println(word);
                        }
                    }

                }
                reader.close();
                System.out.println("\n\nData file read!");
            } else
            {
                System.out.println("No file selected!!!... exiting.\nRun the program again and select a file.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
