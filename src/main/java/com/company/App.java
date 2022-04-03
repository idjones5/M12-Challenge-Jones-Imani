package com.company;


import com.sun.prism.shader.Solid_TextureRGB_AlphaTest_Loader;

import java.sql.SQLOutput;
import java.util.*;
import java.util.Scanner;


public class App {

    public static void nextChoiceMessage() {
        System.out.println("What would you like to do next? If nothing, enter none.");
    }

    public static void invalidOptionMessage() {
        System.out.println("Invalid. Please enter one of the options");
    }

    public static boolean searchThroughList(List<String> list, String item) {
        return list.contains(item);
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String userInput;


        List<String> cityList = new ArrayList<>();
        List<String> addCityToStateList =  new ArrayList<>();
        List<String> statesList = new ArrayList<>();
        List<State> statesObjectsList = new ArrayList<>();


        // menu options

        System.out.println("Hello, welcome. What would you like to do?: ");
        System.out.println("Add a state\n" + "Add a delete a State\n" + "List all the states\n" + "Search for a state\n" + "List the capital for a state\n" + "Search for greater population");
        System.out.println("Add a city\n" + "Delete a city\n" + "List the cities for a state\n" + "Search for a city\n");
        userInput = scan.nextLine();

        if (userInput.equals("Add a state") || userInput.equals("Delete a state") || userInput.equals("add a state")
                || userInput.equals("List all the states") || userInput.equals("Search for a state") || userInput.equals("List the capital for a state")
                    || userInput.equals("Search for greater population") || userInput.equals("Search for lesser population")) {

            while (userInput.equals("Add a state") || userInput.equals("Delete a state") || userInput.equals("add a state")
                    || userInput.equals("List all the states") || userInput.equals("Search for a state") || userInput.equals("List the capital for a state")
                        || userInput.equals("Search for greater population") || userInput.equals("Search for lesser population")) {

                if (userInput.equals("Add a state") || userInput.equals("add a state")) {

                    // allowing users to add a state to the list

                    System.out.println("Please enter the state you would like to add");
                    userInput = scan.nextLine();

                    if (searchThroughList(statesList, userInput)) {

                        while (searchThroughList(statesList, userInput)) {
                            System.out.println("You have already entered this state.");
                            System.out.println("Please enter a state you would like to add");
                            userInput = scan.nextLine();
                        }

                    }
                    if (!searchThroughList(statesList, userInput)) {

                        statesList.add(userInput);

                        State s = new State(statesList.get(statesList.size() - 1));
                        statesObjectsList.add(s);

                        nextChoiceMessage();
                        userInput = scan.nextLine();
                    }

                } else if (userInput.equals("Delete a state") && statesList.size() != 0) {

                    // allowing the users to delete a state from the list

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

                    // allowing users to list all the states in the list

                    System.out.println("Here are all the states you have entered: ");

                    for (State state : statesObjectsList) {
                        System.out.print(state.getName() + " " + "\n");
                    }

                    nextChoiceMessage();
                    userInput = scan.nextLine();

                } else if (userInput.equals("Search for a state")) {

                    // allowing to search for a state by name

                    System.out.println("Enter the state you would like to search for: ");
                    userInput = scan.nextLine();
                    String userState = userInput;

                        if (searchThroughList(statesList, userState)) {
                            System.out.println("This state exists.\n");
                        } else if (!searchThroughList(statesList, userState) || statesList.size() == 0){
                            System.out.println("This state does not exist.\n");
                        }

                    nextChoiceMessage();
                    userInput = scan.nextLine();
                } else if (userInput.equals("List the capital for a state")) {

                    // allowing users to list the capital for a state

                    System.out.println("What state would you like to list the capital for");
                    userInput = scan.nextLine();
                    String userState = userInput;

                    if (searchThroughList(statesList, userState)) {

                        for (State s : statesObjectsList) {

                            for (City c : s.getCityList()) {

                                if (c.getCapital()) {
                                    System.out.println(c.getName() + " is the capital of " + userState);
                                } else {
                                    System.out.println("No capital listed.");
                                }

                            }

                        }

                    } else {
                        System.out.println("No state is listed under that name.");
                    }

                    nextChoiceMessage();
                    userInput = scan.nextLine();

                } else if (userInput.equals("Search for greater population")) {

                    // allows users to search for a city or state that has a greater poulation than the one entered

                    nextChoiceMessage();
                    userInput = scan.nextLine();

                } else if (userInput.equals("Search for lesser population")) {

                    // allows users to search for a city or state that has a greater poulation than the one entered

                    nextChoiceMessage();
                    userInput = scan.nextLine();

                }
            }
        } if (userInput.equals("Add a city") || userInput.equals("a") || userInput.equals("Delete a city")
                || userInput.equals("d") || userInput.equals("List the cities for state") || userInput.equals("l") || userInput.equals("Search for a city")
                || userInput.equals("Search for greater population") || userInput.equals("Search for lesser population")) {

            while (userInput.equals("Add a city") || userInput.equals("a") || userInput.equals("Delete a city")
                    || userInput.equals("d") || userInput.equals("List the cities for state") || userInput.equals("l") || userInput.equals("Search for a city")
                    || userInput.equals("Search for greater population") || userInput.equals("Search for lesser population")) {

                if (userInput.equals("Add a city") || userInput.equals("a")) {

                    // allows users to add a city to a state

                    System.out.println("For what state would you like to add a city?");
                    userInput = scan.nextLine();
                    String state = userInput;
                    int userStateIndex = 0;

                    if (searchThroughList(statesList, state)) {

                        cityList.add(state);

                        for (int i=0; i < statesList.size(); i++) {
                            if (searchThroughList(statesList, state)) {
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
                        addCityToStateList.add(userCity);

                        nextChoiceMessage();
                        userInput = scan.nextLine();

                    } else {
                        System.out.println("This state is not in the list. Please add the state to the list to continue.");
                    }

                } else if (userInput.equals("Delete a city") || userInput.equals("d")) {

                    // allowing users to delete a city from a state

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

                } else if (userInput.equals("List the cities for state") || userInput.equals("l") && statesList.size() != 0) {

                    // allowing users to list all the cities for a state

                    System.out.println("What state would you like to list the cities for?");
                    userInput = scan.nextLine();
                    String userState = userInput;

                    for (State s : statesObjectsList) {
                        if (searchThroughList(statesList, userState) && s.getCityList() != null) {

                            for (City c : s.getCityList()) {
                                System.out.println(c.getName() + " ");
                            }

                        } else if (!searchThroughList(statesList, userState)) {
                            System.out.println("This state does not exist");
                        } else if (s.getCityList() == null) {
                            System.out.println("This state does not have any cities listed. Please add some cities to this state to continue.\n");
                        } else {
                            System.out.println("Invalid.");
                        }
                    }

                    nextChoiceMessage();
                    userInput = scan.nextLine();

                } else if (userInput.equals("Search for a city")) {

                    // allowing users to search for cities by name for a state

                    System.out.println("What city would you like to search for?");
                    userInput = scan.nextLine();
                    String userCity = userInput;

                    for (State s : statesObjectsList) {
                        if (s.getCityList().contains(userCity)) {
                            System.out.println("This city exists\n");
                        } else if (s.getCityList().size() == 0 || !s.getCityList().contains(userCity)) {
                            System.out.println("Error city not found.\n");
                        } else {
                            System.out.println("Invalid.");
                        }
                    }
                        if (statesObjectsList.size() == 0) {
                            System.out.println("Error city not found.\n");
                        } else {
                            System.out.println("Invalid\n");
                        }

                    nextChoiceMessage();
                    userInput = scan.nextLine();

                } else if (userInput.equals("Search for greater population")) {

                    // allows users to search for a city or state that has a greater poulation than the one entered

                    System.out.println("Here are all the locations with a greater population\n");


                    nextChoiceMessage();
                    userInput = scan.nextLine();

                } else if (userInput.equals("Search for lesser population")) {

                    // allows users to search for a city or state that has a greater poulation than the one entered

                    System.out.println("Here are all the locations with a lesser population\n");


                    nextChoiceMessage();
                    userInput = scan.nextLine();

                }

            }
        } else if (userInput.equals("none")) {
            System.out.println("Thank you. GoodBye.");
        } else {
            invalidOptionMessage();
        }

    }
}
