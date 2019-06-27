package ct.virtusa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVReader {

    private static final String COMMA_DELIMITER = ",";

    private static Scanner inputScanner = new Scanner(System.in);

    private List<String> headers;

    public static void main(String[] args) {
        CSVReader csvReader = new CSVReader();
        try {
            System.out.println("Please provide file path for processing, eg: D:/test/test.csv");
            String filePath = inputScanner.nextLine();
            List<List<String>> contents = csvReader.readContentsFromCsv(filePath);
            System.out.println("Please enter line number");
            int line = inputScanner.nextInt();

            System.out.println("Please enter element you want");

            String element = inputScanner.next();

            System.out.println("Element data: " + contents.get(line-1).get(csvReader.headers.indexOf(element.toUpperCase())));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("There is a exception while reading CSV");
        }

    }


    private List<List<String>> readContentsFromCsv(String filePath) throws IOException {
        List<List<String>> records;

        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            records = lines.map(str -> {

                if (headers == null) {
                    String[] headerLine = str.split(COMMA_DELIMITER);
                    headers = new ArrayList<>(headerLine.length);
                    headers.addAll(Arrays.asList(headerLine));
                    return null;
                } else {
                    return Arrays.asList(str.split(COMMA_DELIMITER));
                }

            }).skip(1).collect(Collectors.toList());
        }

        return records;
    }

}
