// 4.6.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
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
	setlocale(LC_ALL, "Russian");
	double a, b;
	bool check = false;
	cout << "Введите первое число(вещественное): " << endl;
	while (!(cin >> a) || !proverka(check))
	{
		if (check != true)
		{
			cin.clear();
			while (cin.get() != '\n');

		}
		check = false;
		cout << "Введите корректное число" << endl;
	}
	cout << "Введите второе число(вещественное): " << endl;
	while (!(cin >> b) || !proverka(check))
	{
		if (check != true)
		{
			cin.clear();
			while (cin.get() != '\n');

		}
		check = false;
		cout << "Введите корректное число" << endl;
	}
	if (a > b)
	{
		cout << "а) первое число больше второго" << endl;
		cout << "б) второе число меньше первого" << endl;
	}
	else
	{
		if (a != b)
		{
			cout << "а) второе число больше первого" << endl;
			cout << "б) первое число меньше второго" << endl;
		}
		else
		{
			cout << "а) числа равны" << endl;
			cout << "б) числа равны" << endl;
		}
	}
	system("pause");
    return 0;
}

