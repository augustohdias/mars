package dev.augustohdias.mars.utility;

import dev.augustohdias.mars.utility.CircularList.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CircularListTest {

  @Test
  void elementPushTest() {
    CircularList<Integer> list = new CircularList<>();
    list.push(0);
    Assertions.assertEquals(1, list.getSize());
  }

  @Test
  void elementsPushTest() {
    CircularList<Integer> list = new CircularList<>();
    list.push(0).push(1).push(2);
    Assertions.assertEquals(3, list.getSize());
  }

  @Test
  void getElementTest() {
    CircularList<Integer> list = new CircularList<>();
    list.push(0).push(1).push(3).push(2);
    Assertions.assertEquals(1, list.get(1).value());
    Assertions.assertEquals(3, list.get(2).value());
    Assertions.assertEquals(2, list.get(3).value());
    Assertions.assertEquals(0, list.get(0).value());
  }

  @Test
  void getEachElementWithNegativeIndexTest() {
    CircularList<Integer> list = new CircularList<>();
    list.push(0).push(1).push(3).push(2);

    int negativeIndex = 0;
    for (int i = 0; i < list.getSize(); i++) {
      negativeIndex--;
      int positiveIndex = list.getSize() + negativeIndex;
      int bigNegativeIndex = list.getSize() * -10 + negativeIndex;

      Assertions.assertEquals(list.get(negativeIndex), list.get(positiveIndex));
      Assertions.assertEquals(list.get(bigNegativeIndex), list.get(negativeIndex));
      Assertions.assertEquals(list.get(bigNegativeIndex), list.get(positiveIndex));
    }
  }

  @Test
  void findAndGetReferenceTest() {
    CircularList<Integer> list = new CircularList<>();
    list.push(0).push(1).push(2);
    Node<Integer> reference = list.findAndGetReference(2).orElse(null);
    Assertions.assertNotNull(reference);
  }

  @Test
  void findAndGetReferenceInvalidElementTest() {
    CircularList<Integer> list = new CircularList<>();
    list.push(0).push(1).push(2);
    Node<Integer> reference = list.findAndGetReference(20).orElse(null);
    Assertions.assertNull(reference);
  }

  @Test
  void neighborhoodTest() {
    CircularList<Integer> list = new CircularList<>();
    list.push(0).push(1).push(2);
    Node<Integer> reference = list.findAndGetReference(2).orElseGet(() -> new Node<>(-999));
    Assertions.assertEquals(0, reference.next().value());
    Assertions.assertEquals(1, reference.prev().value());
  }
}
