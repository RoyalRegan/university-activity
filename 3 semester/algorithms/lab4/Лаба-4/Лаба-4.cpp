// Лаба-4.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include <string>
using namespace std;

int sum_mas(int n,int* mas,int sum)
{
	if (n == 0)
	{
		return sum;
	}
	else
	{
		sum += mas[n - 1];
		n--;
		return sum_mas(n, mas,sum);
	}
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
	while (!(cin >> in) || !check(checked))
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

int main()
{
	setlocale(LC_ALL, "RUS");
	int num;
	int sum = 0;
	cout << "Введите длинну массиву: "; input(num);
	while (num<=0)
	{
		cout << "Введите корректое значение" << endl;
		input(num);
	}
	int* mas = new int[num];
	cout << "Заполните массив" << endl;
	for (int i = 0; i < num; i++)
	{
		input(mas[i]);
	}
	cout <<"Сумма всех элементов массива: " <<sum_mas(num,mas,sum)<<endl;
	system("pause");
    return 0;
}

