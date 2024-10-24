package lab6;

import java.util.Objects;

/**
 * Абстрактний клас, що представляє базові властивості броні.
 * Містить поля для ваги та вартості.
 *
 * @author Denys
 */
public abstract class Armor {
  private final double weight;  // Вага амуніції в кг
  private final double cost;    // Вартість амуніції в грошових одиницях

  /**
   * Конструктор, що приймає вагу та ціну броні.
   * Якщо вага або ціна менші нуля, викликає виключення.
   *
   * @param weight вага броні
   * @param cost ціна броні
   */
  public Armor(double weight, double cost) {
    if (weight <= 0 || cost <= 0) {
      throw new IllegalArgumentException("Вага і вартість повинні бути більше нуля.");
    }
    this.weight = weight;
    this.cost = cost;
  }

  public double getWeight() {
    return weight;
  }

  public double getCost() {
    return cost;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " [Вага: " + weight + " кг, Вартість: " + cost + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Armor armor = (Armor) o;
    return Double.compare(armor.getWeight(), getWeight()) == 0 &&
            Double.compare(armor.getCost(), getCost()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWeight(), getCost());
  }
}