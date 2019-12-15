export default class Stack<T> {
    private count: number;
    private items: any;

    constructor() {
        this.count = 0;
        this.items = {};
    }

    push(elemet: T): void {
        this.items[this.count] = elemet;
        this.count++;
    }

    pop() {
        if (this.isEmpty()) {
            return undefined;
        }

        this.count--;
        const result = this.items[this.count]
        delete this.items[this.count];
        return result;
    }

    isEmpty(): boolean {
        return this.count == 0;
    }

    size(): number {
        return this.count;
    }

    peek() {
        if (this.isEmpty()) {
            return undefined;
        }
        return this.items[this.count - 1];
    }

    clear(): void {
        this.items = {};
        this.count = 0;
    }

    toString(): string {
        if (this.isEmpty()) {
            return ' ';
        }
        let objString = '${this.items[0]}';
        for (let i = 0; i < this.count; i++) {
            objString = '${objString},${this.items[i]}';
        }
        return objString;
    }



}