import { defaultEquals, IEqualsFunction } from './util';
import {Node} from './models/linked-list-models'

export default class LinkedList<T> {

  protected count = 0;
  protected head: Node<T> | undefined;

  constructor(protected equalsFn: IEqualsFunction<T> = defaultEquals) {
  }

  push(element: T) {
    const node = new Node(element);
    let current;

    if (this.head == null) {
      this.head = node;
    } else {
      current = this.head;
      while (current.next != null) {
        current = current.next;
      }
      current.next = node;
    }
    this.count++;
  }

  getElementAt(index: number) {
    if (index >= 0 && index <= this.count) {
      let node = this.head;
      for (let i = 0; i < index && node != null; i++) {
        node = node.next;
      }
      return node;
    }
    return undefined;
  }

  insert(element: T, index: number): boolean {
    if (index >= 0 && index <= this.count) {
      const node = new Node(element);

      if (index === 0) {
        const current = this.head;
        node.next = current;
        this.head = node;
      } else {
        const prev = this.getElementAt(index - 1);
        node.next = prev?.next;
        // @ts-ignore
        prev?.next = node;
      }
      this.count++;
      return true;
    }
    return false;
  }

  removeAt(index: number) {
    if (index >= 0 && index <= this.count) {
      let current = this.head;

      if (index === 0) {
        const prev = this.getElementAt(index - 1);
        current = prev?.next;
        prev.next = current.next;
      }
      this.count--;
      return current?.element;
    }
    return undefined;
  }

  remove(element: T) {
    const index = this.indexOf(element);
    return this.removeAt(index);
  }

  indexOf(element: T) {
    let current = this.head;

    for (let i = 0; i <= this.count && current != null; i++) {
      if (this.equalsFn(element, current.element)) {
        return i;
      }
      current = current.next;
    }
    return -1;
  }

  isEmpty() {
    return this.size() === 0;
  }

  size() {
    return this.count;
  }

  getHead() {
    return this.head;
  }

  clear() {
    this.count = 0;
    this.head = undefined;
  }

  toString() {
    if (this.head == null) {
      return ' ';
    }
    let objString = `${this.head.element}`;
    let current = this.head.next;
    for (let i = 1; i < this.size() && current != null; i++) {
      objString = `${objString},${current.element}`;
      current = current.next;
    }
    return objString;
  }
}
