package com.lowkaze.backpack;

import java.util.Scanner;

public class Main {
    private static Backpack backpack = new Backpack();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showOptions();

            int selectedOption = scanner.nextInt();

            try {
                switch (selectedOption) {
                    case 1:
                        showItems();
                        break;
                    case 2:
                        addItem();
                        break;
                    case 3:
                        removeItem();
                        break;
                    case 4:
                        useItem();
                        break;
                    case 5:
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println();
                        System.out.println("The selected option doesn't exist.");
                        System.out.println();
                }
            } catch (EmptyBackpackException | ItemNotFoundException e) {
                System.out.println();
                System.out.println(e.getMessage());
                System.out.println();
            }
        }
    }

    private static void showOptions() {
        System.out.println("Your backpack has " + backpack.size() + (backpack.size() == 1 ? " item." : " items."));
        System.out.println();
        System.out.println(
            """
            What you want to do?

            1. Show items
            2. Add item
            3. Remove item
            4. Use item
            5. Exit
            """
        );
        System.out.print("> ");
    }

    private static void showItems() {
        int index = 0;

        for (Item item : backpack) {
            if (index == 0) {
                System.out.println();
                System.out.println("Items:");
                System.out.println();
            }

            System.out.println(++index + ". " + item.toString());
        }

        System.out.println();
    }

    private static void addItem() {
        System.out.print("What's the name of the item? ");

        Scanner scanner = new Scanner(System.in);

        backpack.add(new Item(scanner.nextLine()));
    }

    private static void removeItem() {
        showItems();
        System.out.print("Which item you want to remove? ");

        Scanner scanner = new Scanner(System.in);

        backpack.remove(scanner.nextInt() - 1);
    }

    private static void useItem() {
        showItems();
        System.out.print("Which item you want to use? ");

        Scanner scanner = new Scanner(System.in);

        backpack.remove(scanner.nextInt() - 1);
    }
}
