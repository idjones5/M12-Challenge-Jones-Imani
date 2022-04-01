package com.company;

import java.util.*;
import java.util.Scanner;

public class App {

    public static void nextChoiceMessage() {
        System.out.println("What would you like to do next? If nothing, enter none.");
    }

    public static void invalidOptionMessage() {
        System.out.println("Invalid. Please enter one of the options");
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String userInput;


        List<String> cityList = new ArrayList<>();
        List<City> addCityToStateList;
        List<String> statesList = new ArrayList<>();
        List<State> statesObjectsList = new ArrayList<>();


        // allowing the user to add states to a list

        System.out.println("Hello, welcome. What would you like to do?: ");
        System.out.println("Add a state\n" + "Add a delete a State\n" + "List all the states\n");
        System.out.println("Add a city\n" + "Delete a city\n" + "List the cities for a state\n");
        userInput = scan.nextLine();

        if (userInput.equals("Add a state") || userInput.equals("Delete a state") || userInput.equals("add a state") || userInput.equals("List all the states")) {

            while (userInput.equals("Add a state") || userInput.equals("Delete a state") || userInput.equals("add a state") || userInput.equals("List all the states")) {

                if (userInput.equals("Add a state") || userInput.equals("add a state")) {
                    System.out.println("Please enter the state you would like to add");
                    userInput = scan.nextLine();

                    if (statesList.contains(userInput)) {

                        while (statesList.contains(userInput)) {
                            System.out.println("You have already entered this state.");
                            System.out.println("Please enter a state you would like to add");
                            userInput = scan.nextLine();
                        }

                    }
                    if (!statesList.contains(userInput)) {

                        statesList.add(userInput);

                        State s = new State(statesList.get(statesList.size() - 1));
                        statesObjectsList.add(s);

                        nextChoiceMessage();
                        userInput = scan.nextLine();
                    }

                } else if (userInput.equals("Delete a state") && statesList.size() != 0) {
                    System.out.println("Here are a list of the states. Which one would you like to delete?:\n ");

                    for (State state : statesObjectsList) {
                        System.out.println(state.getName());
                    }

                    System.out.println("\n");

                    userInput = scan.nextLine();
                    State s = new State(userInput);
                    String stateName = s.getName();
                    int stateIndex = 0;

                    for (int i = 0; i < statesList.size(); i++) {
                        if (statesList.get(i).equals(stateName)) {
                            stateIndex = i;
                        }
                    }

                    statesObjectsList.remove(stateIndex);

                    nextChoiceMessage();
                    userInput = scan.nextLine();

                } else if (userInput.equals("List all the states") && statesList.size() != 0) {

                    System.out.println("Here are all the states you have entered:");

                    for (State state : statesObjectsList) {
                        System.out.print(state.getName() + " ");
                    }

                    nextChoiceMessage();
                    userInput = scan.nextLine();

                }
            }
        } if (userInput.equals("Add a city") || userInput.equals("a") || userInput.equals("Delete a city") || userInput.equals("d") || userInput.equals("List the cities for state") || userInput.equals("l")) {

            while (userInput.equals("Add a city") || userInput.equals("a") || userInput.equals("Delete a city") || userInput.equals("d") || userInput.equals("List the cities for state") || userInput.equals("l")) {

                if (userInput.equals("Add a city") || userInput.equals("a")) {

                    System.out.println("For what state would you like to add a city?");
                    userInput = scan.nextLine();
                    String state = userInput;
                    int userStateIndex = 0;

                    if (statesList.contains(state)) {

                        cityList.add(state);

                        for (int i=0; i < statesList.size(); i++) {
                            if (statesList.contains(state)) {
                                userStateIndex = i;
                            }
                        }

                        State userStateObject = statesObjectsList.get(userStateIndex);

                        if (userStateObject.getCityList() == null) {
                            userStateObject.setCityList(new ArrayList<>());
                        }

                        System.out.println("What city would you like to add?");
                        userInput = scan.nextLine();
                        String userCity = userInput;

                        System.out.println("What is the population of this city?");
                        userInput = scan.nextLine();
                        int cityPopulation = Integer.parseInt(userInput);

                        System.out.println("Enter true if this city is the Capital of this state. Otherwise enter false");
                        userInput = scan.nextLine();
                        boolean isCapital = Boolean.parseBoolean(userInput);

                        City c = new City(userCity, cityPopulation, state, isCapital);

                        userStateObject.getCityList().add(c);

//                        for (City ct : userStateObject.getCityList()) {
//                            System.out.print(ct.getName() + " \n");
//                        }

                        nextChoiceMessage();
                        userInput = scan.nextLine();

                    } else {
                        System.out.println("This state is not in the list. Please add the state to the list to continue.");
                    }

                } else if (userInput.equals("Delete a city") || userInput.equals("d")) {

                    System.out.println("What city would you like to delete");
                    userInput = scan.nextLine();
                    String userCity = userInput;
                    int userCityIndex = 0;

                    for (int i=0; i < statesObjectsList.size(); i++) {
                        if (statesObjectsList.get(i).getCityList().contains(userCity)) {
                            userCityIndex = i;
                            statesObjectsList.get(i).getCityList().remove(userCityIndex);
                        }
                    }

//                    for (int i=0; i < statesObjectsList.size(); i++) {
//                        for (int j=0; j < statesObjectsList.get(i).getCityList().size(); j++) {
//                            System.out.println(statesObjectsList.get(i).getCityList().get(j).getName());
//                        }
//                    }


                } else if (userInput.equals("List the cities for state") || userInput.equals("l")) {

                    System.out.println("What state would you like to list the cities for?");
                    userInput = scan.nextLine();

                    // complete next session


                }

            }
        } else if (userInput.equals("none")) {
            System.out.println("Thank you. GoodBye.");
        } else {
            invalidOptionMessage();
        }




        // allowing users to add cities and subsequently cities to states













        System.out.println("\n\nlist of states: " + statesList + "\n");

//        for (State s: statesObjectsList) {
//            System.out.println(s.getName());
//        }



    }
}
