// Домаха-1.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include "locale.h"
#include <cmath>
using namespace std;
int Sum(int a); //задание 1(прототип)
void SumMul(int a, int& b, int& c); //задание 2(прототип)
bool simple(int element); //проверка простое ли число
bool Marsen(int a); //является ли число числом марсена

int main()
{
	int c;
	int sum;
	int mul;
	int num;
	int a;
	int count=0;
	int max=0;
	setlocale(LC_ALL, "RUS");
	cout << "Введите чиcло: ";
	cin >> c;
	cout << "Сумма цифр числа: " << c << ":= " << Sum(c) << endl;
	SumMul(c,sum,mul);
	cout << "Cумма и произведение цифр числа: " << c << endl << "Сум: " << sum << endl << "Произв: " << mul << endl;
	cout << "Введите длинну последовательности" << endl;
	cin >> num;
	while (num<=0)
	{
		cout << "Длинна последоветальности должна быть больше 0" << endl;
		
	}
	cout << "Введите числа:" << endl;
	while (num != 0)
	{ 
		cin >> a;
		if (Marsen(a)) // Задание 3 и 4
		{
			if (a > max)
			{
				max = a;
			}
			count++;
		}
		num--;
	}	
	cout << endl;
	cout << "Чисел Марсена в последовательнсти и максимальное: " << endl << "Чисел: " << count << endl << "Максимальное: " << max << endl;
	system("pause");
	return 0;
}

int Sum(int a) // задание 1
{
	int b = 0;
	while (a != 0)
	{
		b += a % 10;
		a /= 10;
	}
	return b;
}

void SumMul(int a,int &b,int &c) // задание 2
{
	int g = 0;
	int temp = a;
	while (temp != 0)
	{
		g += temp % 10;
		temp /= 10;
	}
	b = g;
	g = 1;
	temp = a;
	while (temp != 0)
	{
		g *= temp % 10;
		temp /= 10;
	}
	c = g;
	return;
}

bool simple(int element) // Проверка простое ли число
{
	if (element == 0 || element == 1)
	{
		return false;
	}
	else if (element == 2)
	{
		return true;
	}
	else
	{
		int calc = 0;
		for (int i = 2; i <= element / 2; i++)
		{
			if (!(element % i))
			{
				calc++;
			}
		}
		if (calc >= 1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}

bool Marsen(int a) //является ли число числом марсена
{
	if (simple(a))
	{
		for (int p = 0; p < 10000; p++)
		{
			if (a + 1 == pow(2, p) && (simple(p)))
			{
				return true;
			}
		}
	}
	else
	{
		return false;
	}
	return false;
}

		