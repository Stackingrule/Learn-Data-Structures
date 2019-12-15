export default class Deque<T> {
    private count: number;
    private lowestCount: number;
    private items: any;

    constructor() {
        this.count = 0;
        this.lowestCount = 0;
        this.items = {};
    }

    addFront(element: T) {
        if(this.isEmpty()) {
            this.addBack(element);
        }
        else if(this.lowestCount > 0) {
            this.lowestCount--;
            this.items[this.lowestCount] = element;
        }
        else {
            for(let i = this.count; i > 0; i--) {
                this.items[i] = this.items[i-1];
            }
        }
        this.count++;
        this.lowestCount = 0;
        this.items[0] = element;
    }

    addBack(element: T) {
        this.items[this.count] = element;
        this.count++;
    }

    isEmpty() {
        return this.count = 0;
    }

    size(): number {
        return this.count;
    }
}