package lab6;

/**
 * Клас, що представляє шолом як елемент амуніції.
 *
 * @author Denys
 */
public class Helmet extends Armor {

  /**
   * Конструктор, що приймає вагу та ціну шолома.
   * Якщо вага або ціна менші нуля, викликає виключення.
   *
   * @param weight вага шолома
   * @param cost ціна шолома
   */
  public Helmet(double weight, double cost) {
    super(weight, cost);
  }
}