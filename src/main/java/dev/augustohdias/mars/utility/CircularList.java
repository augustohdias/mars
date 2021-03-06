package dev.augustohdias.mars.utility;

import java.util.Optional;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

public class CircularList<T> {
  private Node<T> head;

  @Getter private int size = 0;

  /**
   * A node holding it's neighbors references.
   *
   * @param <T> Node data type.
   */
  @RequiredArgsConstructor
  @Accessors(fluent = true, chain = true)
  static class Node<T> {
    @NonNull @Getter private T value;

    @Getter private Node<T> next;

    @Getter private Node<T> prev;
  }

  /**
   * Search for an element and returns a reference to it.
   *
   * @param element Element value to look for.
   * @return Element's node reference if it succeeds, null otherwise.
   */
  public Optional<Node<T>> findAndGetReference(T element) {
    Node<T> currentPosition = this.head;
    int counter = 0;
    while (currentPosition.value != element && counter < this.size) {
      currentPosition = currentPosition.next();
      counter += 1;
    }
    return currentPosition.value == element ? Optional.of(currentPosition) : Optional.empty();
  }

  /**
   * Get element at index.
   *
   * @param index Element index.
   * @return Reference to element.
   */
  public Node<T> get(int index) {
    while (index < 0) index += this.size;

    Node<T> temp = this.head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  /**
   * Adds a new node.
   *
   * @param data Node data.
   * @return Self reference.
   */
  public CircularList<T> push(T data) {
    this.size += 1;
    if (head == null) {
      this.head = new Node<>(data);
      this.head.next = this.head;
      this.head.prev = this.head;
      return this;
    }

    Node<T> newNode = new Node<>(data);
    Node<T> temp = this.head;
    newNode.next = this.head;
    this.head.prev = newNode;

    while (temp.next != this.head) temp = temp.next;
    temp.next = newNode;
    newNode.prev = temp;

    return this;
  }
}
