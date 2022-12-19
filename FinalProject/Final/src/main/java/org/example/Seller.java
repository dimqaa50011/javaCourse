package org.example;

import java.util.*;

public class Seller {
    private String name;
    private Store store;
    private Map<String, Object> userFilter = new HashMap<>();
    private Scanner scan = new Scanner(System.in);
    private String promptString = "=> ";

    public Seller(String name) {
        this.name = name;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getName() {
        return name;
    }

    public void sale(User user) {

        System.out.printf("Добрый день, %s! Добро пожаловать в %s.\n", user.getName(), store.getName());

        String endUserMessage;

        processAddUserFilter();
        editFilter();
        List<Laptop> laptops = searchResult();
        int numLaptop = selectLaptop(laptops);
        Laptop selectedLaptop = laptops.get(numLaptop - 1);
        if (user.buyALaptop(selectedLaptop)) {
            user.purchaseConfirm(selectedLaptop);
            endUserMessage = String.format("Спасибо за покупку ноутбука, %s\n.Ждем вас снова.", user.getNewLaptop());
        } else
            endUserMessage = String.format("%s, у вас недостаточно стредств дла покупки. ", user.getName());
        userFilter.clear();
        endUser(endUserMessage);
        System.out.println();
        System.out.println("------------------------------------------------------------------");
    }

    private int selectFeature() {
        System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                           "1 - ОЗУ\n" +
                           "2 - Объем ЖД\n" +
                           "3 - Операционная система\n" +
                           "4 - Цвет\n" +
                           "5 - Тип ЖД\n" +
                           "6 - Цена");
        System.out.print(promptString);
        return scan.nextInt();
    }

    private String getProperty(int field) {
        String property;
        switch (field) {
            case 1 -> property = "ram";
            case 2 -> property = "memoryDisc";
            case 3 -> property = "os";
            case 4 -> property = "color";
            case 5 -> property = "typeDisc";
            case 6 -> property = "price";
            default -> property = "";
        }
        return property;
    }

    private Object getPropertyValue() {
        System.out.println("Введите значение свойства");
        System.out.print(promptString);
        return scan.next();
    }

    private void clearUserFilter() {
        userFilter.put("os", null);
        userFilter.put("ram", null);
        userFilter.put("typeDisc", null);
        userFilter.put("memoryDisc", null);
        userFilter.put("color", null);
        userFilter.put("price", null);
    }

    private List<Laptop> searchResult() {
        List<Laptop> laptops = new ArrayList<>();
        for (Laptop laptop : store.getAssortment()) {
            if (isMatch(laptop))
                laptops.add(laptop);
        }
        return laptops;
    }

    private boolean isMatch(Laptop laptop) {
        boolean flag = false;
        for (Map.Entry<String, Object> item : userFilter.entrySet()) {
            Object laptopProperty = laptop.getFieldByName(item.getKey());
            if (laptopProperty != null) {
                if (isString(laptopProperty)) {
                    if (((String) laptopProperty).equals(((String) item.getValue()))) {
                        flag = true;
                    }
                } else if (Integer.parseInt(laptopProperty.toString()) >= Integer.parseInt(item.getValue().toString())) {
                    flag = true;
                } else flag = false;
            }
        }
        return flag;
    }

    private boolean isString(Object item) {
        try {
            String value = ((String) item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void addUserFilter(String key, Object value) {
        userFilter.put(key, value);
    }

    private void processAddUserFilter() {
        int numberProperty = selectFeature();
        String propertyName = getProperty(numberProperty);
        Object propertyValue = getPropertyValue();
        addUserFilter(propertyName, propertyValue);
    }

    private int selectLaptop(List<Laptop> laptops) {
        System.out.println("По вашим критериям найдены следующие ноутбуки");
        for (int i = 0; i < laptops.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, laptops.get(i));
        }
        System.out.println("Введите цифру, соответствующую необходимому ноутбуку");
        System.out.print(promptString);
        return scan.nextInt();
    }

    private void editFilter() {
        System.out.print("Желаете добавить критерий? [y/n]");
        System.out.print(promptString);
        String answer = scan.next();
        if (answer.equals("y"))
            processAddUserFilter();
        return;
    }

    private void endUser(String msg) {
        System.out.println(msg);
    }


    @Override
    public String toString() {
        return "Seller{" +
               "name='" + name + '\'' +
               '}';
    }
}