// 5.8.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>

using namespace std;

int main()
{
	setlocale(LC_ALL, "RUS");
	double kg = 0.453;
	cout << "Таблица соответствия между весом в фунтах и весом в килограммах" << endl;
	for (int i = 1; i < 11; i++)
	{
		cout << i << " фт" << " = " << kg * i << " кг" << endl;
	}
	system("pause");
    return 0;
}

