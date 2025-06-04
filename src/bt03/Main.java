package bt03;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import java.util.zip.DataFormatException;


public class Main {
    public static void main(String[] args) {
        List<Message>senderList = new ArrayList<>();
        do {
            Scanner scanner = new Scanner(System.in);
            Message sender = new Message();
            System.out.println("Nhập tên người gửi hoặc exit: ");
            String inputName = scanner.nextLine();
            if(inputName.equals("exit")){
                System.exit(0);
            }
            sender.setSender(inputName);
            System.out.print("Nhập nội dung tin nhắn");
            sender.setContent(scanner.nextLine());
            sender.setTimeStamp();
            senderList.add(sender);
            System.out.println("Nhập history để xem lịch sử, hoặc filter để lọc tin nhắn theo người gửi, hoặc date để lọc theo ngày");
            inputName = scanner.nextLine();
            switch (inputName){
                case "history":
                    senderList.stream().forEach(System.out::println);
                    break;
                case "filter":
                    System.out.println("Nhập tên người cần filter");
                    String filterName = scanner.nextLine();
                    senderList.stream()
                            .filter(msg -> msg.getSender().equalsIgnoreCase(filterName))
                            .forEach(System.out::println);
                    break;
                case "date":

                    try {
                        System.out.println("Nhập dd-mm-yyyy");
                        String inputDate = scanner.nextLine();
                        DateTimeFormatter formatter  = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        LocalDate coverDate = LocalDate.parse(inputDate, formatter);
                        senderList.stream().filter(msg -> msg.getTimeStamp().toLocalDate().equals(coverDate))
                                .forEach(System.out::println);

                    } catch (Exception e) {
                        System.out.println("Ngày không đúng định dạng! Vui lòng nhập lại.");
                    }
            }


        }while (true);

    }
}
