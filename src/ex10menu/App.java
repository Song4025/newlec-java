package ex10menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // test score intro..
        {

        }
        
        while(true){
            FileInputStream fis = new FileInputStream("res/exams.csv");
            Scanner scan = new Scanner(fis);
            int menu;
            //test score list
            {
                
                clear();
                System.out.println("┌────────────────────────────────┐");
                System.out.println("│            Main menu           │");
                System.out.println("└────────────────────────────────┘");
                System.out.println("1. List");
                System.out.println("2. Input Score");
                System.out.println("3. Exit");
                
                scan = new Scanner(System.in);
                System.err.print(">");
                menu = Integer.parseInt(scan.nextLine());
            }
            //test score input
            if(menu == 1)
            {
                {
                    clear();
                    System.out.println("┌──────────────────────────────┐");
                    System.out.println("│        Test Score List       │");
                    System.out.println("└──────────────────────────────┘");
                    // 파일 데이터를 불러오려면?
                    scan = new Scanner(new File("res/exams.csv"));
                    if(scan.hasNextLine())
                        scan.nextLine();
                    
                    System.out.printf("%-4s %-4s %-4s %-4s %-6s %-6s\n", "NO", "KOR", "ENG", "MATH", "TOTAL", "AVG");

                    int index = 0;
                    while(scan.hasNextLine()){
                        String line = scan.nextLine();
                        String[] tokens = line.split(",");
                        int kor = Integer.parseInt(tokens[0]);
                        int eng = Integer.parseInt(tokens[1]);
                        int math = Integer.parseInt(tokens[2]);
                        int total = kor+eng+math;
                        double avg = total/3.0D;
                        
                        System.out.printf("%-4d %-4d %-4d %-4d %-6d %-6.2f\n", index+1, kor, eng, math, total, avg);
                        
                        index++;
                    }
                }
                {
                    System.out.println("──────────────────────────────");
                    System.out.println("Press any key to Contiue>");
                    scan = new Scanner(System.in);
                    scan.nextLine();
                }
            }
            // Test Score Input
            else if(menu ==2)
            {
                {
                    clear();
                    System.out.println("┌──────────────────────────────┐");
                    System.out.println("│   Please enter your grades   │");
                    System.out.println("└──────────────────────────────┘");
                    scan = new Scanner(System.in);
                    
                    int kor;
                    int eng;
                    int math;
                    do{
                        System.out.print("Korean grade: ");
                        kor = Integer.parseInt(scan.nextLine());
                        if(!(0<=kor && 100>=kor))
                            System.out.println("성적의 유효범위는 0~100입니다.");
                    }while(!(0<=kor && 100>=kor));
    
                    do{
                        System.out.print("English grade: ");
                        eng = Integer.parseInt(scan.nextLine());
                        if(!(0<=eng && 100>=eng))
                            System.out.println("성적의 유효범위는 0~100입니다.");
                    }while(!(0<=eng && 100>=eng));
                        
                    do{
                        System.out.print("Math grade: ");
                        math = Integer.parseInt(scan.nextLine());
                        if(!(0<=math && 100>=math))
                            System.out.println("성적의 유효범위는 0~100입니다.");
                    }while(!(0<=math && 100>=math));
                    
                    // System.out.print("Korean grade: ");
                    // int kor = Integer.parseInt(scan.nextLine());
                    // System.out.print("English grade: ");
                    // int eng = Integer.parseInt(scan.nextLine());
                    // System.out.print("Math grade: ");
                    // int math = Integer.parseInt(scan.nextLine());
    
                    FileOutputStream fos = new FileOutputStream("res/exams.csv", true);
                    PrintStream out = new PrintStream(fos);
                    
                    out.printf("\n%d,%d,%d",kor,eng,math);
                    
                    out.close();
                    fos.close();
                }
                {
                    System.out.println("──────────────────────────────");
                    System.out.println("Press any key to Contiue>");
                    scan = new Scanner(System.in);
                    scan.nextLine();
                }
            }
            else if(menu == 3)
                break;
            // 사용자가 잘못된 메뉴를 입력했을 경우 오류메세지 출력
            else
            {
                clear();
                System.out.println("┌──────────────────────────────┐");
                System.out.println("│             Error            │");
                System.out.println("└──────────────────────────────┘");
                System.out.println("Value out of range. \nPlease select a valid option form menu!");
                System.out.println("──────────────────────────────");
                System.out.println("Press any key to Contiue>");
                scan = new Scanner(System.in);
                    scan.nextLine();
            }
            
        }
        System.out.println("Bye~");
        

        /*
        FileInputStream fis = new FileInputStream("res/exams.csv");
        Scanner scan = new Scanner(fis);
        FileOutputStream fos = new FileOutputStream("res/exams.out");
        PrintStream out = new PrintStream(fos);

        if(scan.hasNextLine())
            scan.nextLine();

        out.println("KOR,ENG,MATH,TOTAL,AVG");

        int index = 0;
        //int total 
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            String[] tokens = line.split(",");
            int kor = Integer.parseInt(tokens[0]);
            int eng = Integer.parseInt(tokens[1]);
            int math = Integer.parseInt(tokens[2]);
            int total = kor+eng+math;
            double avg = total/3.0D;
            
            out.printf("%d,%d,%d,%d,%.2f", kor, eng, math, total, avg);
            if(scan.hasNextLine())
                out.println();
            // index++;
        }
        scan.close();
        fis.close();
        fos.close();
        out.close();

         */
    }

    public static void clear() {
        try {
            String operatingSystem = System.getProperty("os.name");
            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
