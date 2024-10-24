package lab6;

/**
 * Клас, що представляє щит як елемент амуніції.
 *
 * @author Denys
 */
public class Shield extends Armor {

  /**
   * Конструктор, що приймає вагу та ціну щита.
   * Якщо вага або ціна менші нуля, викликає виключення.
   *
   * @param weight вага щита
   * @param cost ціна щита
   */
  public Shield(double weight, double cost) {
    super(weight, cost);
  }
}
