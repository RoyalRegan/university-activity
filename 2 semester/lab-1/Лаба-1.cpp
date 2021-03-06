// Лаба-1.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include "locale.h"
#include "time.h"

using namespace std;
#define Len 100
bool MasVvod(int M[Len], int K); //ввода массива(с клавиатуры)
void MasVivod(int M[Len], int K); //вывод массива
bool rand(int M[Len], int K); //ввода массива(рандомными числами)
int MinChet(int M[Len], int K); // задание

int main()
{
	int vbr = 10;
	setlocale(LC_ALL, "RUS");
	int M[Len];
	int K;
	bool ok = false;

	while (vbr != 0) 
	{
		system("cls");
		cout << "Задание 1" << endl;
		cout << "ИКБО-07-17 Ануфриев В.В" << endl;
		cout << "Меню\n";
		cout << "1) Заполнить массив(руч)\n";
		cout << "2) Заполнить массив(авто)\n";
		cout << "3) Вывести массив\n";
		cout << "4) Найти минимальное среди четных чисел этого массива\n";
		cout << "0) Выход\n";
		cout << "Ваш выбор: ";
		cin >> vbr;
		system("cls");
		switch (vbr)
		{
		case 1: 
		{
			cout << "Введите кол-во элементов в массиве: ";
			cin >> K;
			if (!MasVvod(M,K))
			{
				cout << "Длинна последоветальности должна быть больше нуля или меньше 100" << endl;
			}
			else
			{
				ok = true;
			}
			system("pause");
			break;
		}
		case 2:
		{
			cout << "Введите кол-во элементов в массиве: ";
			cin >> K;
			if (!rand(M, K))
			{
				cout << "Длинна последоветальности должна быть больше нуля и меньше 100" << endl;
			}
			else
			{
				ok = true;
			}
			system("pause");
			break;
		}
		case 3: 
		{
			if (ok == true)
			{
				cout << "Вывод массива\n";
				MasVivod(M, K);
				cout << endl;
			}
			else
			{
				cout << "Введите массив" << endl;
			}
			system("pause");
			break;
		}
		case 4: 
		{
			if (ok == true)
			{
				if (MinChet(M, K) != 100001)
				{
					cout << "Минимальное среди четных чисел этого массива\n" << MinChet(M, K) << endl;
				}
				else
				{
					cout << "Минимальное среди четных чисел этого массива\n" << "Не существует" << endl;
				}
			}
			else
			{
				cout << "Введите массив" << endl;
			}
			system("pause");
			break;
		}
		default:
			break;
		}
	}
	system("pause");
	return 0;
}

bool MasVvod(int M[Len], int K) //ввода массива(с клавиатуры)
{
	int q;
	if (K > 0 && K <= Len)
	{
		cout << "Введите " << K << " чисел" << endl;
		for (int i = 0;i < K;i++)
		{ 
			cin >> q;
			if ((q > -10000) && (q < 10000))
			{
				M[i]=q;
			}
			else
			{
				cout << "Число должно быть больше -10000 и меньше 10000" << endl;
				i--;
			}
		}
	}
	else
	{
		return false;
	}
	return true;
}

bool rand(int M[Len], int K) //ввода массива(рандомными числами)
{
	srand((unsigned)time(NULL));
	if (K > 0 && K <= Len)
	{
		for (int i = 0;i < K;i++)
		{
			M[i] = -10000+rand() % 20000;
		}
	}
	else
	{
		return false;
	}
	return true;
}

void MasVivod(int M[Len], int K) // Вывод массива
{
	if (K > 0 && K < Len)
	{
		for (int i = 0; i < K;i++)
		{
			cout << M[i] << " ";
		}
	}
	return;
}

int MinChet(int M[Len], int K) // задание
{
	int min = 10001;
	for (int i = 0; i < K;i++)
	{
		if (M[i] % 2 == 0)
		{
			if (M[i] < min)
				min = M[i];
		}
	}
	return min;
}

	