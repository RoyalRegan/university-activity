// Лаба-2.cpp: определяет точку входа для консольного приложения.
//

#include "stdafx.h"
#include <iostream>
#include <iomanip>
#include "locale.h"
#include <time.h> 

using namespace std;
void MasVvodStat(int x[25][20], int n, int m); // заполнение массива(статического)
void MasVivodStat(int x[25][20], int n, int m); // вывод массива(статического)
int Kolvo1(int x[25][20], int n, int m);// задание 1(кол-во 1 в массиве)
void MasVvodDin(int**x, int n); // заполнение массива(динамического)
void MasVvodDinAuto(int**x, int n); // заполнение массива(динамического,рандомно)
void MasVivodDin(int**x, int n); // вывод массива(динамического)
void Transpr(int** x, int n); // задание 2(транспонирование)
int MasElm(int** x, int n); // задание 3(максимальный элемент в требуемой области)

int main()
{
	setlocale(LC_ALL, "RUS");
	srand((int)time(0));
	int vbr1 = 10;
	int vbr2 = 10;
	int vbr3 = 10;
	int Mas1[25][20];
	int rad;
	int ** Mas2;
	int ** Mas3;
	int N;
	bool c = false;
	while (vbr1 != 0)
	{
		system("cls");
		cout << "Лаба №-2" << endl;
		cout << "ИКБО-07-17 Ануфриев В.В" << endl;
		cout << "Меню" << endl;
		cout << "1) Задание 1" << endl;
		cout << "2) Задание 2" << endl;
		cout << "3) Задание 3" << endl;
		cout << "0) Выход" << endl;
		cout << "Ваш выбор: ";
		cin >> vbr1;
		system("cls");
		switch (vbr1)
		{
		case 1:
		{
			cout << "Задание 1:" << endl;
			cout << "Посчитать количество единиц в выбранном ряду(всего их 25)" << endl;
			cout << "Матрица:" << endl;
			MasVvodStat(Mas1, 25, 20);
			MasVivodStat(Mas1, 25, 20);
			cout << "Введите ряд:";
			cin >> rad;
			while ((rad > 25) || (rad <= 0))
			{
				cout << "Введеный ряд должен быть больше 0 и меньше 26" << endl;
				cin >> rad;
			}
			cout << "Единиц:" << Kolvo1(Mas1, rad, 20) << endl;
			system("pause");
			break;
		}
		case 2:
		{
			vbr2 = 10;
			cout << "Задание 2:" << endl;
			cout << "Сделать транспонирование мантрицы квадратной матрицы" << endl;
			cout << "Введите размер матрицы:" << endl;
			cin >> N;
			while (N <= 0)
			{
				cout << "Размер матрицы должен быть больше 0" << endl;
				cin >> N;
			}
			Mas2 = new int*[N];
			for (int i = 0; i < N; i++)
			{
				Mas2[i] = new int[N];
			}
			while ((vbr2 != 3) && (c == false))
			{
				system("cls");
				cout << "Выберите ввод" << endl;
				cout << "1) Авто" << endl;
				cout << "2) Ручной" << endl;
				cout << "3) Выход" << endl;
				cin >> vbr2;
				system("cls");
				switch (vbr2)
				{
				case 1:
				{
					MasVvodDinAuto(Mas2, N);
					cout << "Исходная матрица:" << endl;
					MasVivodDin(Mas2, N);
					Transpr(Mas2, N);
					cout << "Транспонированная" << endl;
					MasVivodDin(Mas2, N);
					for (int count = 0; count < N; count++)
					{
						delete[]Mas2[count];
					}
					delete[]Mas2;
					system("pause");
					c = true;
					break;
				}
				case 2:
				{
					cout << "Введите значения:" << endl;
					MasVvodDin(Mas2, N);
					cout << "Исходная матрица:" << endl;
					MasVivodDin(Mas2, N);
					Transpr(Mas2, N);
					cout << "Транспонированная" << endl;
					MasVivodDin(Mas2, N);
					for (int count = 0; count < N; count++)
					{
						delete[]Mas2[count];	
					}
					delete[]Mas2;
					system("pause");
					c = true;
					break;

				}
				default:
					break;
				}
			}
			c = false;
			break;
		}
		case 3:
		{
			cout << "Задание 3:" << endl;
			cout << "Найти наибольшее число в верхней области(над пересечением главной и побочной \nдиагоналей)" << endl;
			cout << "Введите размер матрицы:" << endl;
			cin >> N;
			while (N <= 0)
			{
				cout << "Размер матрицы должен быть больше 0" << endl;
				cin >> N;
			}
			Mas3 = new int*[N];
			for (int i = 0; i < N; i++)
			{
				Mas3[i] = new int[N];
			}
			while ((vbr2 != 3) && (c == false))
			{
				system("cls");
				cout << "Выберите ввод" << endl;
				cout << "1) Авто" << endl;
				cout << "2) Ручной" << endl;
				cout << "3) Выход" << endl;
				cin >> vbr2;
				system("cls");
				switch (vbr2)
				{
				case 1:
				{
					MasVvodDinAuto(Mas3, N);
					cout << "Исходная матрица:" << endl;
					MasVivodDin(Mas3, N);
					if (N < 3)
					{
						cout << "Наибольшее число:" << endl << "Не существует" << endl;
					}
					else
					{
						cout << "Наибольшее число:" << MasElm(Mas3, N) << endl;
					}
					for (int count = 0; count < N; count++)
					{
						delete[]Mas3[count];
					}
					delete[]Mas3;
					system("pause");
					c = true;
					break;
				}
				case 2:
				{
					cout << "Введите значения:" << endl;
					MasVvodDin(Mas3, N);
					cout << "Исходная матрица:" << endl;
					MasVivodDin(Mas3, N);
					if (N < 3)
					{
						cout << "Наибольшее число:" << endl << "Не существует" << endl;
					}
					else
					{
						cout << "Наибольшее число:" << MasElm(Mas3, N) << endl;
					}
					for (int count = 0; count < N; count++)
					{
						delete[]Mas3[count];
					}
					delete[]Mas3;
					system("pause");
					c = true;
					break;
				}
				default:
					break;
				}
			}
			c = false;
			break;
		}
		default:
			break;
		}
	}
	return 0;
}

void MasVvodStat(int x[25][20], int n, int m) // заполнение массива(статического)
{
	int q;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{	
			q = 0 + rand() % 2;
			x[i][j] = q;
		}
	}
}

void MasVivodStat(int x[25][20], int n, int m) // вывод массива(статического)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cout.width(3);
			cout << x[i][j] << setw(2);
		}
		cout << endl;
	}
}

int Kolvo1(int x[25][20], int n, int m) // задание 1(кол-во 1 в массиве)
{
	int a = 0;
	for (int j = 0; j < m; j++)
	{
		if (x[n-1][j] == 1)
		{
			a++;
		}
	}
	return a;
}

void MasVvodDin(int**x, int n) // заполнение массива(динамического)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cin >> x[i][j];
		}
	}
}

void MasVvodDinAuto(int**x, int n) // заполнение массива(динамического,рандомно)
{
	int q;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			q = -100 + rand() % 200;
			x[i][j] = q;
		}
	}
}

void MasVivodDin(int** x, int n) // вывод массива(динамического)
{
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			cout.width(5);
			cout << x[i][j] << setw(3);
		}
		cout << endl;
	}
}

void Transpr(int** x, int n) // задание 2(транспонирование)
{
	int tmp = 0;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < i; j++)
		{
			tmp = x[i][j];
			x[i][j] = x[j][i];
			x[j][i] = tmp;
		}
	}
}

int MasElm(int** x, int n) // задание 3(максимальный элемент в требуемой области)
{
	int max= -2147483647;
	for (int i = 0; i < n / 2; i++)
	{
		for (int j = 0; j < n - i - 1; j++)
		{
			if (i < j)
			{
				if (x[i][j] > max)
				{
					max = x[i][j];
				}
			}
		}
	}
	return max;
}