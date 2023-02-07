//--------------------------------------------------
//Name     :    Khaled Hamdy Elgohary
//Student Number : 7924188
// Course   :  COMP 2150
// Instructor : Olivier tremblay-savard
// Assignment: Assignment 1( Activity tracker).
// Question : The whole Assignment is the code
//
//Remarks: by implementing my own ADT and using object
//oriented techniques, the program accepts a file name
//by the user, the file contains activities done by the
//user, and the goal of the program is to summarise the
//activities entered by the user and run some queries
//
//note: the main function contains a couple of static methods
//that helped the implementation of the activity tracker
//all the static methods are used, and there are no
//redundant methods.
//---------------------------------------------------

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Date;

//-----------------------------------------------
//Main
//
// Purpose: the main method is responsible for
//running the program, and parsing the file from user
//and also handles the logic of the queries and
//the creation of the activity objects
//Returns: void, but prints the whole summarization
//of the activities from the file
//---------------------------------------------------

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        GenericList activities=new GenericList();
        StringTokenizer st;
        System.out.println("Please input the file name: ");
        Scanner fetch=new Scanner(System.in);
        String filePath= fetch.nextLine();
        final Scanner fileIn=new Scanner(Files.newInputStream(Path.of(filePath)));
        String line= fileIn.nextLine();
        while(fileIn.hasNextLine()){
            /*a line in the file if it involves an activity input it should include 7 tokens */
            st=new StringTokenizer(line," ");
            if(st.countTokens()!=7 && !checkQActivity(line) && ! quit(line) && !checkTotalT(line) && !queryDates(line)){
                System.out.println("the line has one of it's variables in the wrong format, this line " +
                        "will be skipped and won't be included in the activities stored");
            }
            else{
                String type=st.nextToken();
                switch (type) {
                    case "CYCLING" -> {
                        String name = st.nextToken();
                        String loc = st.nextToken();
                        String date = st.nextToken();
                        String time = st.nextToken();
                        String totalD = st.nextToken();
                        String ele = st.nextToken();
                        if(date.equals("today")){
                            date=getCurrentDate();
                        }
                        CyclingAtom a = new CyclingAtom(name, loc, date, getDuration(time), Integer.parseInt(totalD), Integer.parseInt(ele));
                        activities.insertFront(a);
                        System.out.println("Adding activity: "+a.getData().toString(convertTime(a.getTime())));
                    }
                    case "RUNNING" -> {
                        String name = st.nextToken();
                        String loc = st.nextToken();
                        String date = st.nextToken();
                        String time = st.nextToken();
                        String totalD = st.nextToken();
                        String ele = st.nextToken();
                        if(date.equals("today")){
                            date=getCurrentDate();
                        }
                        RunningAtom a = new RunningAtom(name, loc, date, getDuration(time), Integer.parseInt(totalD), Integer.parseInt(ele));
                        activities.insertFront(a);
                        System.out.println("Adding activity: "+a.getData().toString(convertTime(a.getTime())));
                    }
                    case "WALKING" -> {
                        String name = st.nextToken();
                        String loc = st.nextToken();
                        String date = st.nextToken();
                        String time = st.nextToken();
                        String totalD = st.nextToken();
                        String ele = st.nextToken();
                        if(date.equals("today")){
                            date=getCurrentDate();
                        }
                        WalkingAtom a = new WalkingAtom(name, loc, date, getDuration(time), Integer.parseInt(totalD), Integer.parseInt(ele));
                        activities.insertFront(a);
                        System.out.println("Adding activity: "+a.getData().toString(convertTime(a.getTime())));
                    }
                    case "SWIMMING" -> {
                        String name = st.nextToken();
                        String loc = st.nextToken();
                        String date = st.nextToken();
                        String time = st.nextToken();
                        String labs = st.nextToken();
                        String labLength = st.nextToken();
                        if(date.equals("today")){
                            date=getCurrentDate();
                        }
                        SwimmingAtom a = new SwimmingAtom(name, loc, date, getDuration(time), Integer.parseInt(labs), Integer.parseInt(labLength));
                        activities.insertFront(a);
                        System.out.println("Adding activity: "+a.getData().toString(convertTime(a.getTime())));
                    }
                }
            }
            if(checkTotalT(line)){
                int time=0;
                Node top= activities.getTop();
                ListItem item;
                String x="";
                while(top!=null){
                    item=top.getData();
                    if(item instanceof CyclingAtom){
                        time=time+((CyclingAtom) item).getTime();
                    }
                    else if(item instanceof WalkingAtom){
                        time=time+((WalkingAtom) item).getTime();
                    }
                    else if(item instanceof RunningAtom) {
                        time = time + ((RunningAtom) item).getTime();
                    }
                    else if(item instanceof SwimmingAtom){
                        time=time+ ((SwimmingAtom) item).getTime();
                    }
                    top=top.getNext();
                }
                System.out.println("Querying total activity time (time is displayed in hh:mm format) :");
                System.out.println(convertTime(time));
            }
            else if(checkQActivity(line)){
                Node top= activities.getTop();
                String[] words =line.split(" ");
                System.out.println("Querying activities of type "+words[2]);
                System.out.println("======== Activities ========");
                switch (words[2]) {
                    case "CYCLING":
                        while (top != null) {
                            ListItem item = top.getData();
                            if (item instanceof CyclingAtom) {
                                int time=((CyclingAtom) item).getTime();
                                System.out.println(((CyclingAtom)item).getData().toString(convertTime(time)));
                            }
                            top = top.getNext();
                        }
                    case "RUNNING":
                        while (top != null) {
                            ListItem item = top.getData();
                            if (item instanceof RunningAtom) {
                                int time=((RunningAtom) item).getTime();
                                System.out.println(((RunningAtom)item).getData().toString(convertTime(time)));
                            }
                            top = top.getNext();
                        }
                    case "WALKING":
                        while (top != null) {
                            ListItem item = top.getData();
                            if (item instanceof WalkingAtom) {
                                int time=((WalkingAtom) item).getTime();
                                System.out.println(((WalkingAtom)item).getData().toString(convertTime(time)));
                            }
                            top = top.getNext();
                        }
                    case "SWIMMING":
                        while (top != null) {
                            ListItem item = top.getData();
                            if (item instanceof SwimmingAtom) {
                                int time=((SwimmingAtom) item).getTime();
                                System.out.println(((SwimmingAtom)item).getData().toString(convertTime(time)));
                            }
                            top = top.getNext();
                        }
                }

            }
            else if(queryDates(line)){
                int totalTime=0;
                String []range=line.split(" ");
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                Date start=sdf.parse(range[2]);
                Date end=sdf.parse(range[3]);
                Node top= activities.getTop();
                System.out.println("Querying activity time between "+range[2]+" and "+range[3]);
                System.out.println("======== Activities ========");
                while(top!=null){
                    ListItem item=top.getData();
                    switch (top.getData().getType()) {
                        case "CYCLING" -> {
                            Date date = sdf.parse(((CyclingAtom) item).getDate());
                            if ((date.before(end) && date.after(start)) || date.equals(start) || date.equals(end)) {
                                int time = ((CyclingAtom) item).getTime();
                                totalTime = totalTime + time;
                                System.out.println(((CyclingAtom) item).getData().toString(convertTime(time)));
                            }
                        }
                        case "RUNNING" -> {
                            Date date = sdf.parse(((RunningAtom) item).getDate());
                            if ((date.before(end) && date.after(start)) || date.equals(start) || date.equals(end)) {
                                int time = ((RunningAtom) item).getTime();
                                totalTime = totalTime + time;
                                System.out.println(((RunningAtom) item).getData().toString(convertTime(time)));
                            }
                        }
                        case "WALKING" -> {
                            Date date = sdf.parse(((WalkingAtom) item).getDate());
                            if ((date.before(end) && date.after(start)) || date.equals(start) || date.equals(end)) {
                                int time = ((WalkingAtom) item).getTime();
                                totalTime = totalTime + time;
                                System.out.println(((WalkingAtom) item).getData().toString(convertTime(time)));
                            }
                        }
                        case "SWIMMING" -> {
                            Date date = sdf.parse(((SwimmingAtom) item).getDate());
                            if ((date.before(end) && date.after(start)) || date.equals(start) || date.equals(end)) {
                                int time = ((SwimmingAtom) item).getTime();
                                totalTime = totalTime + time;
                                System.out.println(((SwimmingAtom) item).getData().toString(convertTime(time)));
                            }
                        }
                    }
                    top=top.getNext();
                }
                System.out.println("Total time for the specific date period is "+convertTime(totalTime));
            }
            else if(quit(line)){
                System.out.println("==================");
                System.out.println("Thanks for using the activity tracker !");
                System.out.println("PROGRAM HALT...");
                break;
            }
            line= fileIn.nextLine();
        }
        fileIn.close();
    }

    public static String getCurrentDate(){
        return LocalDate.now().toString();
    }

    public static int getDuration(String text){
        return (int)Duration.parse(text).toMinutes();
    }

    public static boolean checkTotalT(String text){
        return text.contains("QUERY TOTAL_TIME");
    }

    public static boolean checkQActivity(String text){
        return text.contains("QUERY ACTIVITY");
    }

    public static boolean quit(String text){
        return text.contains("QUIT");
    }

    public static boolean queryDates(String text){
        return text.contains("QUERY BETWEEN");
    }

    public static String convertTime(int minutes){
        return LocalTime.MIN.plus(Duration.ofMinutes(minutes)).toString();
    }
}
