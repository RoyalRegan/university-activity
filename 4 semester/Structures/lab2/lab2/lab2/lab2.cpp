
#include "pch.h"
#include "BinarTree.h"

int main()
{
	BinarTree *tree = new BinarTree();
	cout << "//////FirstTree///////" << endl;
	tree->insert(10);
	tree->insert(6);
	tree->insert(14);
	tree->insert(5);
	tree->insert(8);
	tree->insert(18);
	tree->insert(11);
	tree->print();
	cout << "//////SecondTree///////" << endl;
	tree = new BinarTree();
	tree->insert(1);
	tree->insert(2);
	tree->insert(3);
	tree->insert(4);
	tree->insert(5);
	tree->insert(6);
	tree->insert(-1);
	tree->print();
	cout << "//////ThreeTree///////" << endl;
	tree = new BinarTree();
	tree->insert(2);
	tree->insert(7);
	tree->insert(8);
	tree->insert(3);
	tree->insert(5);
	tree->insert(1);
	tree->insert(0);
	tree->print();
	system("pause");
}
