import java.util.*;

/*
Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки,
отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
 */
public class dd1 {
    public static void main(String[] args) {
        Set<Notebook> notebooks = newSet();
        try (Scanner scaner = new Scanner(System.in)) {
            List<String> parametersInteger = Arrays.asList("2", "3", "6");
            List<String> parametersString = Arrays.asList("1", "4", "5");
            Map<String, String> filter = new HashMap<String, String>();

            printNotebooks(notebooks, filter);
            while (true) {
                System.out.println("Введите цифру, соответствующую необходимому параметру:");
                System.out.println("1 - Производитель");
                System.out.println("2 - Минимальный объём ОЗУ (Гб)");
                System.out.println("3 - Минимальный объём HHD или SSD (Гб)");
                System.out.println("4 - Операционная система");
                System.out.println("5 - Цвет");
                System.out.println("6 - Минимальный размер экрана (дюйм)");
                System.out.println("0 - Сброс");
                System.out.println("-1 - Выход");
                System.out.print("Номер параметра: ");

                String key = scaner.nextLine();
                if (key != null)
                    key = key.trim();
                else
                    continue;
                if (key.equalsIgnoreCase("-1"))
                    break;
                if (key.equalsIgnoreCase("0")) {
                    filter.clear();
                    printNotebooks(notebooks, filter);
                }
                if (parametersInteger.contains(key) || parametersString.contains(key)) {
                    System.out.print("Значение параметра: ");
                    String value = scaner.nextLine();
                    if (value != null)
                        value = value.trim();
                    else
                        continue;

                    if (value.equals("")) {
                        filter.put(key, value);
                    } else {
                        //
                        if (parametersString.contains(key)) {
                            filter.put(key, value);
                        } else {
                            try {
                                filter.put(key, value);
                            } catch (NumberFormatException e) {
                                System.out.println();
                                System.out.println("Для числового критерия (" + key + ") введено нечисловое значение");
                                continue;
                            }
                        }
                    }
                    //
                    printNotebooks(notebooks, filter);
                } else {
                    System.out.println();
                    System.out.println(String.format("!Критерий %s отсутствует", key));
                }
            }
        }
    }

    public static Set<Notebook> newSet() {
        Notebook note1 = new Notebook(111, "Lenovo", 4, 512, "Windows", "Черный", 15);
        Notebook note2 = new Notebook(222, "Samsung", 8, 256, "Linux", "Серый", 13);
        Notebook note3 = new Notebook(333, "HP", 16, 1024, null, "Белый", 17);
        Notebook note4 = new Notebook(444, "Lenovo", 8, 512, "Windoes", "Серый", 13);
        Notebook note5 = new Notebook(555, "Macbook", 16, 512, "MacOS", "Белый", 12);
        Set<Notebook> set = new HashSet<>();
        set.add(note1);
        set.add(note2);
        set.add(note3);
        set.add(note4);
        set.add(note5);
        return set;
    }

    private static void printNotebooks(Set<Notebook> notebooks, Map<String, String> filter) {
        List<String> forPrint = new ArrayList<String>();
        for (Notebook n : notebooks) {
            if (filter(n, filter)) {
                String s = String.format("S/N: %d, название: %s, ОЗУ(Гб):%s, диск(Гб): %d, ОС: %s, " +
                        "цвет: %s, экран(дюйм): %d",
                        n.getSN(),
                        n.getName(),
                        n.getRAM(),
                        n.getSSD(),
                        n.getOS(),
                        n.getColor(),
                        n.getSize());
                forPrint.add(s);
            }
        }

        System.out.println();
        System.out.println(String.format("Ноутбуки. Результат (%d из %d)", forPrint.size(), notebooks.size()));
        for (String s : forPrint) {
            System.out.println(s);
        }
    }

    private static boolean filter(Notebook n, Map<String, String> filter) {
        boolean result = true;

        for (String key : filter.keySet()) {
            String value = filter.get(key);
            if (value == null || value.trim().equals(""))
                continue;
            if (key.equals("1")) {
                if (n.getName().equalsIgnoreCase(value)) {
                } else {
                    result = false;
                    break;
                }
            } else if (key.equals("2")) {
                try {
                    int i = Integer.parseInt(value);
                    if (n.getRAM() >= i) {
                    } else {
                        result = false;
                        break;
                    }
                } catch (NumberFormatException e) {
                    result = false;
                    break;
                }
            } else if (key.equals("3")) {
                try {
                    int i = Integer.parseInt(value);
                    if (n.getSSD() >= i) {
                    } else {
                        result = false;
                        break;
                    }
                } catch (NumberFormatException e) {
                    result = false;
                    break;
                }
            } else if (key.equals("4")) {
                if (n.getOS().equalsIgnoreCase(value)) {
                } else {
                    result = false;
                    break;
                }
            } else if (key.equals("5")) {
                if (n.getColor().toUpperCase().contains(value.toUpperCase())) {
                } else {
                    result = false;
                    break;
                }
            } else if (key.equals("6")) {
                try {
                    int i = Integer.parseInt(value);
                    if (n.getSSD() >= i) {
                    } else {
                        result = false;
                        break;
                    }
                } catch (NumberFormatException e) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

}