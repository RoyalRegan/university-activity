// 6.57.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include <vector>
#include <ctime>
#include <string>

using namespace std;

bool check(vector<double>p,double a)
{
	for (int i = 0; i < p.size(); i++)
	{
		if (p[i] == a)
		{
			return true;
		}
	}
	return false;
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
	setlocale(LC_ALL, "Russian");
	srand(time(0));
	vector<double> posl;
	double n;
	double digit;
	int number;
	bool ch = false;
	for (int i = 0; i < 15; i++)
	{
		double dig = ((double)(rand()) / RAND_MAX * 40)-20;
		while (check(posl, dig))
		{
			dig = ((double)(rand()) / RAND_MAX * 40) - 20;
		}
		posl.push_back(dig);
	}
	for (int i = 0; i < 15; i++)
	{
		for (int j = 0; j < 14; j++)
		{
			if (posl[j] > posl[j + 1])
			{
				double tmp = posl[j];
				posl[j] = posl[j + 1];
				posl[j + 1] = tmp;
			}
		}
	}
	cout << "Последовательность" << endl;
	for (int i = 0; i < 15; i++)
	{
		cout << posl[i] << endl;
	}
	cout << "Введите число(n). Число должно быть больше первого и меньше последнего числа последовательности: " << endl;
	while (!(cin >> n) || (n<posl[0] || n>posl[14] || check(posl, n)) || !proverka(ch))
	{
		if (ch != true)
		{
			cin.clear();
			while (cin.get() != '\n');

		}
		ch = false;
		cout << "Введите корректное число " << endl;
	}
	double cash = posl[14] + 1;
	for (int i = 1; i < 14; i++)
	{
		if (cash > abs(n - posl[i]))
		{
			digit = posl[i];
			number = i + 1;
			cash = abs(n - posl[i]);
		}
	}
	cout << "Ближайшее число к n: " << digit << endl << "Его номер в последовательности: " << number;
	system("pause");
    return 0;
}

