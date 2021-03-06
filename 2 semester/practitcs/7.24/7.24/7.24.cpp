// 7.24.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <string>
using namespace std;

bool proverka(bool &c)
{
	cin.clear();
	string s;
	getline(cin, s, '\n');
	for (auto x : s)
	{
		if (x<'0' || x>'9')
		{
			cin.clear();
			c = true;
			return false;
		}
	}
	return true;
}

int main()
{
	setlocale(LC_ALL, "RUS");
	vector<int> school;
	int ppl;
	int all=0;
	bool check = false;
	for (int i = 0; i < 11; i++)
	{
		cout << "Введите число детей учашихся во всех " << i + 1 << " классах" << endl; 
		while (!(cin >> ppl) || (ppl <= 0) || !proverka(check))
		{
			if (check != true)
			{
				cin.clear();
				while (cin.get() != '\n');

			}
			check = false;
			cout << "Введите корректное количество детей" << endl;
		}
		school.push_back(ppl);
	}
	for (int i = 0; i < 11; i++)
	{
		if (i % 2 == 0)
		{
			all += school[i];
		}
	}
	cout << "Общее количество детей в нечетных классах: " << all << endl;
	system("pause");
	return 0;
}

