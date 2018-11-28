package com.example.javajokes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Joker {

    private List<String> allJokes = new ArrayList<>();

    public Joker() {
        initAllJokes();
    }

    public String getRandomJoke() {
        Random random = new Random();
        int index = random.nextInt(allJokes.size());
        return allJokes.get(index);
    }

    private void initAllJokes() {
        allJokes = Arrays.asList(
                "Q: How many programmers does it take to change a light bulb?\n\n" +
                        "A: None. It's a hardware problem.",
                "Q: Why do programmers always mix up Halloween and Christmas?\n\n" +
                        "A: Because 31 OCT = 25 DEC.",
                "There are 10 types of people in the world: those who understand binary and those who don't.","Debugging /diːˈbʌɡɪŋ/ being a detective in a crime movie where you are also the murderer","Interviewer:What's your biggest strength\n" +
                        "Me:I am good at machine learning\n" +
                        "Interviewer:What's 6*5?\n" +
                        "Me:5\n" +
                        "Interviewer: Not even close.\n" +
                        "Me:32\n" +
                        "Interviewer: still 30\n" +
                        "Me:30\n" +
                        "Interviewer: You're hired.\n","Favourite horror movie of a front end developer? Json vs Freddie.\n",
                "How do you learn coding in a single night? \n" +
                        "Pack a laptop and travel to the North Pole in the beginning of Winter. You'll have 6 months of a night to learn coding.\n",
                "From quora: Why should I hire a software engineer if I can just copy and paste code from Stack Overflow.",
                "Favourtite place for a programmer at the airport?\n" +
                        "Terminal.\n","\n" +
                        "A user interface is like a joke. If you have to explain it then probably, it's not that good.\n",
                "So, where did you two meet?\n" +
                        "Windows users:at the office\n" +
                        "Mac users:at starbucks\n" +
                        "Linux users:Github\t\n,",
                "Documentation is like sex.\n" +
                        "When it's good, it's very goodl.\n" +
                        "When it's bad. it's better than nothing.\n,","How real men play russian roulette?\n" +
                        "[ $[$RANDOM%6]==0] && rm -rf /* || echo *click*\n","From Siri conversations:\n" +
                        "Who is your boyfriend?\n" +
                        "I'll leave the relationships to the databases.\n"," \"Windows Vista supports real multitasking - it can boot and crash simultaneously.\","
        );
    }

}
