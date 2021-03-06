// 1.27.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include <math.h>
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
	int r = 6500;
	double h;
	bool check=false;
	cout << "Введите высоту(км)" << endl;
	while (!(cin >> h) || h <= 0 || !proverka(check))
	{
		if (check != true)
		{
			cin.clear();
			while (cin.get() != '\n');

		}
		check = false;
		cout << "Введите корректную высоту(км)" << endl;
	}
	cout << "Расстояние до линии горизонта: " << pow((pow(r + h, 2) - pow(r, 2)), 0.5) << "км" << endl;
	system("pause");
    return 0;
}

