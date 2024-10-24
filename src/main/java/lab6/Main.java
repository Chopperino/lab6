package lab6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    // Створення екземпляру LinkedArmorSet
    LinkedArmorSet<Armor> armorSet = new LinkedArmorSet<>();

    // Створення об'єктів типу Armor
    Armor helmet = new Helmet(1.5, 100.0);
    Armor shield = new Shield(3.0, 150.0);
    Armor breastplate = new Breastplate(5.0, 300.0);
    Armor secondHelmet = new Helmet(1.5, 100.0); // Дублікований об'єкт для перевірки

    // Додавання об'єктів до набору
    armorSet.add(helmet);
    armorSet.add(shield);
    armorSet.add(breastplate);
    armorSet.add(secondHelmet); // Цей об'єкт не повинен додатися, бо він дублює перший

    // Виведення розміру набору після додавання
    System.out.println("Розмір набору: " + armorSet.size()); // Очікується: 3

    // Видалення об'єкта
    armorSet.remove(helmet);

    // Виведення розміру набору після видалення
    System.out.println("Розмір набору після видалення: " + armorSet.size()); // Очікується: 2

    // Перевірка чи міститься об'єкт shield
    boolean containsShield = armorSet.contains(shield);
    System.out.println("Чи містить набір щит: " + containsShield); // Очікується: true

    // Перевірка чи міститься видалений об'єкт helmet
    boolean containsHelmet = armorSet.contains(helmet);
    System.out.println("Чи містить набір шолом: " + containsHelmet); // Очікується: false

    // Перевірка методу isEmpty()
    System.out.println("Чи порожній набір: " + armorSet.isEmpty()); // Очікується: false

    // Перевірка методу clear()
    armorSet.clear();
    System.out.println("Розмір набору після очищення: " + armorSet.size()); // Очікується: 0
    System.out.println("Чи порожній набір після очищення: " + armorSet.isEmpty()); // Очікується: true

    // Створення другого екземпляру LinkedArmorSet через конструктор з одним об'єктом
    LinkedArmorSet<Armor> singleArmorSet = new LinkedArmorSet<>(helmet);
    System.out.println("Розмір нового набору з одним об'єктом: " + singleArmorSet.size()); // Очікується: 1

    // Створення колекції об'єктів Armor
    Set<Armor> armorCollection = new HashSet<>();
    armorCollection.add(helmet);
    armorCollection.add(shield);
    armorCollection.add(breastplate);

    // Створення третього екземпляру LinkedArmorSet через конструктор з колекцією
    LinkedArmorSet<Armor> collectionArmorSet = new LinkedArmorSet<>(armorCollection);
    System.out.println("Розмір набору з колекцією: " + collectionArmorSet.size()); // Очікується: 3

    // Перевірка роботи ітератора
    System.out.println("Елементи в наборі з колекцією:");
    for (Armor armor : collectionArmorSet) {
      System.out.println(armor);
    }

    // Спроба додати дубльовані елементи
    collectionArmorSet.add(helmet); // Цей об'єкт вже є в наборі
    System.out.println("Розмір набору після спроби додати дубль: " + collectionArmorSet.size()); // Очікується: 3

    // Перевірка методу equals() для наборів
    LinkedArmorSet<Armor> sameArmorSet = new LinkedArmorSet<>(armorCollection);
    System.out.println("Чи рівні два набори з однаковими елементами: " + collectionArmorSet.equals(sameArmorSet)); // Очікується: true

  }
}

