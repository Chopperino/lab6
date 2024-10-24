package lab6;

/**
 * Клас, що представляє нагрудник як елемент амуніції.
 *
 * @author Denys
 */
public class Breastplate extends Armor {

  /**
   * Конструктор, що приймає вагу та ціну нагрудника.
   * Якщо вага або ціна менші нуля, викликає виключення.
   *
   * @param weight вага нагрудника
   * @param cost ціна нагрудника
   */
  public Breastplate(double weight, double cost) {
    super(weight, cost);
  }
}
