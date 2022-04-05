#pragma once
#include <iostream>

using namespace std;


struct node {
	int value;
	node *left;
	node *right;
};

class BinarTree {
public:
	BinarTree();
	~BinarTree();

	void insert(int key);
	void destroyTree();
	void print();

private:
	void destroyTree(node *leaf);
	void insert(int key, node *leaf);
	void print(node *leaf, int step_value);
	node *root;
};


BinarTree::BinarTree() {
	root = NULL;
}

BinarTree::~BinarTree() {
	destroyTree();
}

void BinarTree::destroyTree(node *leaf) {
	if (leaf != NULL) {
		destroyTree(leaf->left);
		destroyTree(leaf->right);
		delete leaf;
	}
}

void BinarTree::insert(int key, node *leaf) {

	if (key < leaf->value) {
		if (leaf->left != NULL) {
			insert(key, leaf->left);
		}
		else {
			leaf->left = new node;
			leaf->left->value = key;
			leaf->left->left = NULL;
			leaf->left->right = NULL;
		}
	}
	else if (key >= leaf->value) {
		if (leaf->right != NULL) {
			insert(key, leaf->right);
		}
		else {
			leaf->right = new node;
			leaf->right->value = key;
			leaf->right->right = NULL;
			leaf->right->left = NULL;
		}
	}

}

void BinarTree::insert(int key) {
	if (root != NULL) {
		insert(key, root);
	}
	else {
		root = new node;
		root->value = key;
		root->left = NULL;
		root->right = NULL;
	}
}


void BinarTree::destroyTree() {
	destroyTree(root);
}

void BinarTree::print(node *leaf, int step_value) {
	string step = " ";
	if (leaf != NULL) {
		
		print(leaf->left,step_value+1);
		for (int i = 0; i < step_value; i++) {
			cout << "  ";
		}
		cout << leaf->value <<endl;
		print(leaf->right, step_value+1);
	}
}

void BinarTree::print() {
	int step_value = 0;
	print(root, step_value);
	cout << "\n";
}