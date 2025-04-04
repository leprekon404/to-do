package org.example;

import java.util.*;

public class Main {

    static final String ID = "id";
    static final String NAME = "name";
    static final String DESC = "desc";
    static final String STATUS = "status";


    public static void main(String[] args) throws Exception{
        System.out.println("Добро пожаловать в менеджер задач");



        // {
        //  "name": "Моя задача",
        //  "desc": "Моя самая первая задача",
        //  "status": "OPEN,"
        // }



       // List<Map<String,String>> tasks = new ArrayList<>();
        Storage storage = new Storage();
        Scanner scanner = new Scanner(System.in);
        while(true) {

            System.out.println("1 - Вывести задачи");
            System.out.println("2 - Добавить задачу");
            System.out.println("3 - Изменить статус");
            System.out.println("0 - Выход");
            System.out.print(">");

            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> {
                    System.out.println("Все задачи");
                    List<Map<String, String>> tasks = storage.getAll();
                    if (tasks.isEmpty()){
                        System.out.println("Задачи отсутствуют");
                    } else {
                        for (Map<String, String> task : tasks) {
                            System.out.println("№ " + task.get(ID));
                            System.out.println("Имя " + task.get(NAME));
                            System.out.println("Описание " + task.get(DESC));
                            System.out.println("Статус " + task.get(STATUS));
                        }
                    }
                }
                case "2" -> {
                    System.out.println("Создание задачи");
                    Map<String,String> task = new HashMap<String, String>();

                    System.out.print("Введите имя задачи: ");
                    String taskName = scanner.nextLine();
                    task.put(NAME, taskName);

                    System.out.print("Введите описание задачи: ");
                    String taskDesk = scanner.nextLine();
                    task.put(DESC, taskDesk);

                    System.out.print("Введите статус задачи: ");
                    String taskStatus = scanner.nextLine();
                    task.put(STATUS, taskStatus);
                    storage.addNew(task);
                }
                case "3" -> {
                    System.out.println("Обновление задачи");
                    if (storage.getAll().isEmpty()){ //получаем все задачи
                        System.out.println("Задачи отсутсвуют");
                    } else {
                        System.out.print("Введите номер задачи для обновления: ");
                        int taskId = scanner.nextInt();
                        scanner.nextInt();
                        System.out.print("Введите статус задачи: ");
                        String taskStatus = scanner.nextLine();
                        storage.changeStatus(taskId, taskStatus);
                    }
                }
                case "0" -> {
                    System.out.println("Выход");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Команда не поддерживается");
            }
        }
    }
}