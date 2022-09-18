package ATM;

import java.util.Scanner;

import static java.lang.System.exit;

public class ATM{
    Scanner scanner = new Scanner(System.in);
    private int action;
    private int money;
    String cardNumber;

    /**
     * Создание объекта
     */
    public ATM() {
        System.out.println("Добро пожаловать!");
        System.out.println("Выберите операцию: ");
        System.out.println("1. Оплата услуг");
        System.out.println("2. Перевод");
        System.out.println("3. Выход");
        action = scanner.nextInt();

        if (action == 1) {
            Pay();
        }
        else if (action == 2) {
            MoneyTransfer();
        }
        else if (action == 3) {
            System.out.println("Вы вышли!");
            exit(0);
        }
    }

    /**
     * Метод реализующий создания чека
     */
    private void Check() {
        System.out.println("Ваш чек: ");
        System.out.println("Сумма оплаты: " + money + "р");
        System.out.println("Номер карты: " + cardNumber);
        System.out.println("----------------------------------->");
    }

    private void NoCheck() {
        System.out.println("Чек не распечатан!");
        System.out.println("----------------------------------->");
    }

    /**
     * Метод для выхода в главное меню банкомата
     */
    private void Exit() {
        System.out.print("Хотите выйти в главное меню? Напишите 0 если да: ");
        int stop = scanner.nextInt();

        if (stop != 0) {
            System.out.println("Введите корректную цифру!");
            return;
        }

        System.out.println("Вы вернулись в главное меню");
        new ATM();
    }


    private void Pay() {
        System.out.println("Выберите операцию: ");
        System.out.println("1. Погашение задолжности кредитной карты");
        System.out.println("2. Оплата коммунальных услуг");
        action = scanner.nextInt();

        if (action == 1) {
            RepaymentOfDebt();
        }
        else if (action == 2) {
            System.out.println("Выберите операцию: ");
            System.out.println("1. Оплата за коммунальные услуги");
            System.out.println("2. Оплата за электричество");
            action = scanner.nextInt();

            if (action == 1 ) {
                CommunalServices();
            }
            else if (action == 2) {
                PayElectricity();
            }
        }
        Exit();
    }

    /**
     * Метод реализующий за погашения кредитной карты
     */
    private void RepaymentOfDebt() {
        System.out.print("Введите номер карты: ");
        cardNumber = scanner.next();

        System.out.print("Введите сумму для погашения задолжности: ");
        money = scanner.nextInt();

        System.out.println("Оплата прошла успешно!! Распечатать чек? 1/0: ");
        action = scanner.nextInt();

        if (action == 1) {
            Check();
        }
        else if (action == 0) {
            NoCheck();
        }
        Exit();
    }

    /**
     * Метод реализует оплату за коммунальные услуги (вода, газ и тд)
     */
    private void CommunalServices() {
        System.out.print("Введите номер карты: ");
        cardNumber = scanner.next();

        System.out.print("Введите сумму: ");
        money = scanner.nextInt();

        System.out.print("Оплата прошла успешно!! Распечатать чек? 1/0: ");
        action = scanner.nextInt();

        if (action == 1) {
            Check();
        }
        else if (action == 2) {
            NoCheck();
        }
        Exit();
    }

    /**
     * Метод реализует оплату электричество
     */
    private void PayElectricity() {
        System.out.print("Введите номер карты для оплаты услуги: ");
        cardNumber = scanner.next();

        System.out.print("Введите сумму: ");
        money = scanner.nextInt();

        System.out.print("Оплата прошла успешно!! Распечатать чек? 1/0: ");
        action = scanner.nextInt();

        if (action == 1) {
            Check();
        }
        else if (action == 2) {
            NoCheck();
        }
        Exit();
    }

    /**
     * Метод реализует перевод денег
     */
    private void MoneyTransfer(){
        System.out.print("Введите номер телефона или карты человека, которому хотите перевести деньги: ");
        String cardOfNumber = scanner.next();

        System.out.print("Введите номер карты с которого хотите переводить сумму денег: ");
        cardNumber = scanner.next();

        System.out.print("Введите сумму для перевода: ");
        money = scanner.nextInt();

        System.out.print("Оплата прошла успешно!! Распечатать чек? 1/0: ");
        action = scanner.nextInt();

        if (action == 1) {
            Check();
            System.out.println("Перевели: " + cardOfNumber);
            System.out.println("Сумма: " + money + "р");
            System.out.println("----------------------------------->");
        }
        else if (action == 2) {
            NoCheck();
        }
        Exit();
    }
}
