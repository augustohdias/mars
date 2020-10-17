package dev.augustohdias.mars.utility;

import java.util.Optional;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
public class CircularList<T> {
  private Node<T> head;
  private int size = 0;

  @RequiredArgsConstructor
  @Accessors(fluent = true, chain = true)
  static class Node<T> {
    @NonNull
    @Getter
    private T value;

    @Getter
    private Node<T> next;

    @Getter
    private Node<T> prev;
  }

  public Optional<Node<T>> findAndGetReference(T element) {
    Node<T> currentPosition = this.head;
    int counter = 0;
    while (currentPosition.value != element && counter < this.size) {
      currentPosition = currentPosition.next();
      counter += 1;
    }
    return currentPosition.value == element? Optional.of(currentPosition) : Optional.empty();
  }

  public Node<T> get(int index) {
    while (index < 0) index += this.size;

    Node<T> temp = null;
    for (int i = 0; i < index; i++) {
      temp = this.head.next;
    }
    return temp;
  }

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
