// Lab1.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include "pch.h"
#include <iostream>
#include <list>
#include <algorithm>
#include <iterator>

using namespace std;

std::list<int>::iterator setIterator(list<int>&myList, int index) {
	int i = 0;
	for (std::list<int>::iterator it = myList.begin(); it != myList.end(); ++it, i++) {
		if (index == i) {
			return it;
		}
	}
}

int getFromList(list<int>&myList,int index) {
	int i = 0;
	for (std::list<int>::iterator it = myList.begin(); it != myList.end(); ++it, i++) {
		if (index == i) {
			return *it;
		}
	}
}

list<int> sort_1(list<int> &unsortedList) {
	list<int> sortedList;
	for (int i = 0; i < unsortedList.size(); i++) {
		if (getFromList(unsortedList, i) >= 0) {
			sortedList.push_back(getFromList(unsortedList, i));
		}
	}
	sortedList.sort();
	for (int i = 0; i < unsortedList.size(); i++) {
		if (getFromList(unsortedList, i) < 0) {
			if (sortedList.size() != i) {
				sortedList.insert(setIterator(sortedList, i), getFromList(unsortedList, i));
			}
			else
			{
				sortedList.push_back(getFromList(unsortedList, i));
			}

		}

	}
	return sortedList;
}

list<int> sort_2(list<int> &unsortedList) {
	list<int> sortedList;
	for (int i = 0; i < unsortedList.size(); i++) {
		if (i % 2 != 0) {
			sortedList.push_back(getFromList(unsortedList, i));
		}
	}
	sortedList.sort();
	for (int i = 0; i < unsortedList.size(); i++) {
		if (i % 2 == 0) {
			if (sortedList.size() != i) {
				sortedList.insert(setIterator(sortedList, i), getFromList(unsortedList, i));
			}
			else
			{
				sortedList.push_back(getFromList(unsortedList, i));
			}

		}

	}
	return sortedList;
}


list<int> sort_3(list<int> &unsortedList) {
	list<int> sortedList;
	for (int i = 0; i < unsortedList.size(); i++) {
		if (i % 2 != 0 && getFromList(unsortedList, i) >= 0) {
			sortedList.push_back(getFromList(unsortedList, i));
		}
	}
	sortedList.sort();
	for (int i = 0; i < unsortedList.size(); i++) {
		if (i % 2 == 0||getFromList(unsortedList, i) < 0) {
			if (sortedList.size() != i) {
				sortedList.insert(setIterator(sortedList, i), getFromList(unsortedList, i));
			}
			else
			{
				sortedList.push_back(getFromList(unsortedList, i));
			}

		}

	}
	return sortedList;
}

int main()
{
	list<int> unsortedList;
	list<int> sortedList;
	for (int i = 0; i < 20; i++) {
		unsortedList.push_back(rand() % 100 - 50);
	}
	cout << "Начальная последовательность" << endl;
	for (int a : unsortedList) {
		cout << a << endl;
	}
	cout << "Сортировка только положительных" << endl;
	for (int a : sort_1(unsortedList)) {
		cout << a << endl;
	}
	cout << "Сортировка только четных" << endl;
	for (int a : sort_2(unsortedList)) {
		cout << a << endl;
	}
	cout << "Сортировка только положит и четных" << endl;
	for (int a : sort_3(unsortedList)) {
		cout << a << endl;
	}
	system("pause");
}
