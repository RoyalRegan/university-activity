// 10.13.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <math.h>
#include<string>
using namespace std;

int poln(vector<int> d)
{
	int count = 0;
	for (int i = 0; i < d.size(); i++)
	{
		int sq = 1;
		while (d[i] > pow(sq, 2))
		{
			sq++;
		}
		if (d[i] == pow(sq, 2))
		{
			count++;
		}
	}
	return count;
}

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
	setlocale(LC_ALL, ("RUS"));
	int n;
	bool check = false;
	vector<int> dig;
	cout << "Введите количество чисел: " << endl;
	while (!(cin >> n) || (n <= 0) || !proverka(check))
	{
		if (check != true)
		{
			cin.clear();
			while (cin.get() != '\n');

		}
		check = false;
		cout << "Введите корректное число" << endl;
	}
	cout << "Введите " << n << " чисел" << endl;
	for (int i = 0; i < n; i++)
	{
		int d;
		while (!(cin >> d) || !proverka(check))
		{
			if (check != true)
			{
				cin.clear();
				while (cin.get() != '\n');

			}
			check = false;
			cout << "Введите корректное число" << endl;
		}
		dig.push_back(d);
	}
	cout << "Количество чисел являющихся полными квадратами: " << poln(dig)<<endl;
	system("pause");
    return 0;
}

