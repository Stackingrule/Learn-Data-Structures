export default class Queue<T> {
    private count: number;
    private lowestCount: number;
    private items: any;

    constructor() {
        this.count = 0;
        this.lowestCount = 0;
        this.items = {};
    }

    enqueue(element: T) {
        this.items[this.count] = element; 
        this.count++;
    }

    dequeue(element: T) {
        if(this.isEmpty()) {
            return undefined;
        }
        const result = this.items[this.lowestCount];
        delete this.items[this.lowestCount];
        return result;
    }

    peek() {
        if(this.isEmpty) {
            return undefined;
        }
        return this.items[this.lowestCount];
    }

    isEmpty() {
        return this.count == 0;
    }

    size(): number {
        return this.count - this.lowestCount;
    }

    clear(): void {
        this.count = 0;
        this.lowestCount = 0;
        this.items = {};
    }

    toString(): string {
        if(this.isEmpty()) {
            return ' ';
        }
        let objString = `${this.items[this.lowestCount]}`;
        for(let i = this.lowestCount + 1; i < this.count; i++) {
            objString = `${objString}, ${this.items[i]}`;
        }
        return objString;
    }
}