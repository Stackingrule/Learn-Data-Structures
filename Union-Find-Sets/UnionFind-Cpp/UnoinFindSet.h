#include <iostream>

class UnionFindSet {
private:
	int* parent;
	int count;

public:
	UnionFindSet(int count) {
		parent = new int[count];
		this->count = count;
		for(int i = 0; i < count; i++) {
			parent[i] = i;
		}
	}

	~UnionFindSet() {
		delete[] parent;
	}

	int find(int p) {
		while(p != parent[i]) {
			p = parent[p];
		}
		return p;
	}

	bool isConnected(int p, int q) {
		return (find[p] == find[q]);
	}

	void unionElements(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);

		if(qRoot == pRoot)
			return;

		parent[pRoot] = qRoot;
	}
};