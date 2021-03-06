// Лаба-3.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include <string>
#include<math.h>

using namespace std;

float f(float x,float k)
{
	return pow(x, k)*exp(-x);
}

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

void input(int &in)
{
	bool checked = false;
	while (!(cin >> in) || in <= 0 || !check(checked))
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

float metod(float a, float b, int step,int k)
{
	float h,sum,integral;
	float* x_i = new float[step+1];
	h = (b - a) / step;
	sum = a;
	for (int i = 0; i < step+1; i++)
	{
		x_i[i] = f(sum, k);
		sum += h;
	}
	integral = (x_i[0] + x_i[step - 1]) / 2;
	for (int i = 1; i < step - 1; i++)
	{
		integral += x_i[i];
	}
	return h * integral;
}

int main()
{
	setlocale(LC_ALL, "RUS");
	const float a = 0, b = 1.5;
	int step;
	cout << "Исходный интеграл: x^(k)*e^(-x)" << endl;
	cout << "Введите количество элементарных отрезков: "; input(step);
	for (int k = 0; k < 5; k++)
	{
		cout <<"k= "<<k<<" Ответ: "<<metod(a, b, step, k)<<endl;
	}
	system("pause");
    return 0;
}

