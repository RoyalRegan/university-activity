// 2.9.cpp: определяет точку входа для консольного приложения.
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
	int n;
	int x = 1;
	bool check = false;
	cout << "Введите количество пройденных месяцев" << endl;
	while (!(cin >> n) || n <= 0 || !proverka(check))
	{
		if (check != true)
		{
			cin.clear();
			while (cin.get() != '\n');

		}
		check = false;
		cout << "Введите корректное число" << endl;
	}
	cout << "Номер месяца: " << (x += n % 12) << endl;
	system("pause");
    return 0;
}

