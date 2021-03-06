// Лаба1.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

bool check(bool &c)
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

void input(double &in)
{
	bool checked = false;
	while (!(cin >> in) ||!check(checked))
	{
		if (checked != true)
		{
			cin.clear();
			while (cin.get() != '\n');

		}
		checked = false;
		cout << "Введите корректое значение" << endl;
	}
}

bool dot_check(double x, double y, double square, double triangle)
{
	if ((x <= 0 && y >= 0) && (x >= -square && y <= square))
	{
		cout << "Точка попадает в область квадрата" << endl;
		return true;
	}
	else
	{
		if ((x >= 0 && y <= 0) && (abs(x) + abs(y) <= triangle))
		{
			cout << "Точка попадает в область треугольника"<<endl;
			return true;
		}
	}
	return false;
}

int main()
{
	setlocale(LC_ALL, "RUS");
	double x, y,square, triangle;
	cout << "Введите координату x: "; input(x);
	cout << "Введите координату y: "; input(y);
	cout << "Введите длинну стороны квадрата: "; input(square);
	while (square<=0)
	{
		cout << "Введите корректое значение" << endl;
		input(square);
	}
	cout << "Введите длинну стороны треугольника: "; input(triangle);
	while (triangle <= 0)
	{
		cout << "Введите корректое значение" << endl;
		input(triangle);
	}
	if (!dot_check(x, y, square, triangle))
	{
		cout << "Точка не попадает не в одну из областей" << endl;
	}
	system("pause");
    return 0;
}

