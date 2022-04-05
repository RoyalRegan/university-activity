package com.company;
import java.util.Scanner;
import java.util.Stack;

public class DrunkGame {
    private Scanner scanner = new Scanner(System.in);
    private Stack<Integer> firstPlayer = new Stack<>();
    private Stack<Integer> secondPlayer = new Stack<>();
    private int firstPlayerCardCount = 5;
    private int secondPlayerCardCount = 5;
    private int round = 1;

    private boolean inputCheck(int number) {
        if (number >= 0 && number <= 9) {
            if (firstPlayer.search(number) != -1) {
                System.out.println("Данная карта(" + number + ") уже имеется в руке 1-ого игрока");
                return false;
            }
            if (secondPlayer.search(number) != -1) {
                System.out.println("Данная карта(" + number + ") уже имеется в руке 2-ого игрока");
                return false;
            }
        } else {
            System.out.println("Номер карты должен быть в пределах 0-9");
            return false;
        }
        return true;
    }

    private void input(Stack<Integer> player) {
        String cards = new StringBuffer(scanner.nextLine()).reverse().toString();
        int countOfCards = 0;
        while (countOfCards != 5) {
            for (int i = 0; i < cards.length(); i++) {
                if (cards.charAt(i) != ' ') {
                    if (inputCheck(Character.getNumericValue(cards.charAt(i)))) {
                        player.push(Character.getNumericValue(cards.charAt(i)));
                        countOfCards++;
                    } else {
                        player.clear();
                        cards = new StringBuffer(scanner.nextLine()).reverse().toString();
                        i = -1;
                        countOfCards = 0;
                    }
                }
            }
            if (countOfCards != 5) {
                System.out.println("Введите 5 карт");
                player.clear();
                cards = new StringBuffer(scanner.nextLine()).reverse().toString();
                countOfCards = 0;
            }
        }
        System.out.println();
    }

    private void addInEndOfStack(Stack<Integer> stack, int value1, int value2) {
        Stack<Integer> newStack = new Stack<>();
        while (!stack.empty()) {
            newStack.push(stack.pop());
        }
        stack.push(value1);
        stack.push(value2);
        while (!newStack.empty()) {
            stack.push(newStack.pop());
        }
    }

    @SuppressWarnings("Duplicates")
    private void play() {
        int left;
        int right;
        while (firstPlayerCardCount != 10 && secondPlayerCardCount != 10) {
            if (round % 2 == 0) {
                left = firstPlayer.pop();
                right = secondPlayer.pop();
                if (left == 0 && right == 9) {
                    addInEndOfStack(secondPlayer, left, right);
                    firstPlayerCardCount--;
                    secondPlayerCardCount++;
                    System.out.println("Раунд: " + round);
                    System.out.println(left + ">" + right);
                    System.out.println("Второй забирает карты\n");
                } else {
                    if (left == 9 && right == 0) {
                        addInEndOfStack(firstPlayer, right, left);
                        firstPlayerCardCount++;
                        secondPlayerCardCount--;
                        System.out.println("Раунд: " + round);
                        System.out.println(left + "<" + right);
                        System.out.println("Первый забирает карты\n");
                    } else {
                        if (left > right) {
                            addInEndOfStack(secondPlayer, left, right);
                            firstPlayerCardCount--;
                            secondPlayerCardCount++;
                            System.out.println("Раунд: " + round);
                            System.out.println(left + ">" + right);
                            System.out.println("Второй забирает карты\n");
                        } else {
                            addInEndOfStack(firstPlayer, right, left);
                            firstPlayerCardCount++;
                            secondPlayerCardCount--;
                            System.out.println("Раунд: " + round);
                            System.out.println(left + "<" + right);
                            System.out.println("Первый забирает карты\n");
                        }
                    }
                }
                round++;
            } else {
                left = secondPlayer.pop();
                right = firstPlayer.pop();
                if (left == 0 && right == 9) {
                    addInEndOfStack(firstPlayer, left, right);
                    firstPlayerCardCount++;
                    secondPlayerCardCount--;
                    System.out.println("Раунд: " + round);
                    System.out.println(left + ">" + right);
                    System.out.println("Первый забирает карты\n");
                } else {
                    if (left == 9 && right == 0) {
                        addInEndOfStack(secondPlayer, right, left);
                        firstPlayerCardCount--;
                        secondPlayerCardCount++;
                        System.out.println("Раунд: " + round);
                        System.out.println(left + "<" + right);
                        System.out.println("Второй забирает карты\n");
                    } else {
                        if (left > right) {
                            addInEndOfStack(firstPlayer, left, right);
                            firstPlayerCardCount++;
                            secondPlayerCardCount--;
                            System.out.println("Раунд: " + round);
                            System.out.println(left + ">" + right);
                            System.out.println("Первый забирает карты\n");
                        } else {
                            addInEndOfStack(secondPlayer, right, left);
                            firstPlayerCardCount--;
                            secondPlayerCardCount++;
                            System.out.println("Раунд: " + round);
                            System.out.println(left + "<" + right);
                            System.out.println("Второй забирает карты\n");
                        }
                    }
                }
                round++;
            }
        }
        if (firstPlayerCardCount == 10) {
            System.out.println("Победитель второй игрок " + round + " раунда");
        } else {
            System.out.println("Победитель первый игрок " + round + " раунда");
        }
    }

    public DrunkGame() {
        System.out.println("Введите карты 1-ого игрока");
        input(firstPlayer);
        System.out.println("Введите карты 2-ого игрока");
        input(secondPlayer);
        play();
    }
}
